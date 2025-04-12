package com.sn.spring.finalex.repository;

import com.sn.spring.finalex.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, Integer> {
}
