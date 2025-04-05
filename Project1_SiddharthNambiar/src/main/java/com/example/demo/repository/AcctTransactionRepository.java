package com.example.demo.repository;

import com.example.demo.model.AcctTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcctTransactionRepository extends MongoRepository<AcctTransaction, String> {
}
