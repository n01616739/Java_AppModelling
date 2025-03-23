package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ConsumerController {

    private final WebClient.Builder webClientBuilder;

    public ConsumerController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/call-provider")
    public Mono<String> callProvider(@RequestParam(defaultValue = "web") String clientType) {
        return webClientBuilder.build()
                .get()
                .uri("http://service-provider/message")
                .header("X-Client-Type", clientType)
                .retrieve()
                .bodyToMono(String.class);
    }
}
