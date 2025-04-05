package com.example.demo.repository;

import com.example.demo.model.MarketOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends MongoRepository<MarketOrder, String> {
}
