package com.example.demo.service;

import com.example.demo.model.MarketOrder;
import com.example.demo.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public MarketOrder placeMarketOrder(MarketOrder order) {
        order.setConfirmationStatus("Placed on " + order.getTypeOfExchange());
        return marketRepository.save(order);
    }
}
