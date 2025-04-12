package com.sn.spring.finalex.repository;

import com.sn.spring.finalex.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
