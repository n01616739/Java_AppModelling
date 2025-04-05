package com.example.demo.repository;

import com.example.demo.model.Fee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends MongoRepository<Fee, String> {
}
