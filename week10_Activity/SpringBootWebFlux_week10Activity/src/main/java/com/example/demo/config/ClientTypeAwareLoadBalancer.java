package com.example.demo.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ClientTypeAwareLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    private final ObjectProvider<ServiceInstanceListSupplier> supplierProvider;

    public ClientTypeAwareLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> supplierProvider) {
        this.supplierProvider = supplierProvider;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        RequestData requestData = ((RequestDataContext) request.getContext()).getClientRequest();
        String clientType = Optional.ofNullable(requestData.getHeaders().getFirst("X-Client-Type")).orElse("web");

        return supplierProvider.getIfAvailable()  
                .get()
                .next()
                .map(instances -> {
                    List<ServiceInstance> filtered = instances.stream()
                            .filter(instance -> clientType.equals(instance.getMetadata().get("clientType")))
                            .toList();

                    if (filtered.isEmpty()) {
                        filtered = instances;
                    }

                    ServiceInstance chosen = filtered.get(ThreadLocalRandom.current().nextInt(filtered.size()));
                    return new DefaultResponse(chosen);
                });
    }
}
