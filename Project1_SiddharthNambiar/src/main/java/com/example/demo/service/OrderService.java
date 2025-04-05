package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private FeeService feeService;

    @Autowired
    private AcctTransactionService transactionService;

    @Autowired
    private MarketService marketService;

    @Autowired
    private OrderRepository orderRepository;

//    public Order placeFullOrderFlow(Order order) {
//        // Step 1: Fee Calculation
//        Fee fee = new Fee();
//        fee.setExchange(order.getExchange());
//        fee.setFeeType("BUY".equalsIgnoreCase(order.getOrderType()));
//        fee.setQuantity(order.getQuantity());
//
//        Fee calculatedFee = feeService.calculateAndSaveFee(fee);
//        order.setFeeAmt(calculatedFee.getFeeAmt());
//
//        // Step 2: Reservation if SELL
//        if ("SELL".equalsIgnoreCase(order.getOrderType())) {
//            AcctTransaction tx = new AcctTransaction();
//            tx.setOrderId(order.getId());
//            tx.setTickerSymbol(order.getStockName());
//            tx.setOrderAmt(order.getOrderAmt());
//            tx.setTransactionPrice(order.getOrderAmt() * 0.98);
//            transactionService.reserveStock(tx);
//        }
//
//        // Step 3: Market Order
//        MarketOrder mo = new MarketOrder();
//        mo.setOrderId(order.getId());
//        mo.setTypeOfExchange(order.getExchange());
//        mo.setLast(order.getOrderAmt());
//        marketService.placeMarketOrder(mo);
//
//        // Step 4: Save Order
//        return orderRepository.save(order);
//    }
    
    
    public Order placeFullOrderFlow(Order order) {
        // Step 1: Fee Calculation
        Fee fee = new Fee();
        fee.setExchange(order.getExchange());
        fee.setFeeType("BUY".equalsIgnoreCase(order.getOrderType()));
        fee.setQuantity(order.getQuantity());

        Fee calculatedFee = feeService.calculateAndSaveFee(fee);
        order.setFeeAmt(calculatedFee.getFeeAmt());

        // ✅ Step 2: Save the order FIRST to get the ID
        Order savedOrder = orderRepository.save(order);

        // Step 3: Reservation if SELL
        if ("SELL".equalsIgnoreCase(savedOrder.getOrderType())) {
            AcctTransaction tx = new AcctTransaction();
            tx.setOrderId(savedOrder.getId());
            tx.setTickerSymbol(savedOrder.getStockName());
            tx.setOrderAmt(savedOrder.getOrderAmt());
            tx.setTransactionPrice(savedOrder.getOrderAmt() * 0.98);
            transactionService.reserveStock(tx);
        }

        // Step 4: Market Order
        MarketOrder mo = new MarketOrder();
        mo.setOrderId(savedOrder.getId());
        mo.setTypeOfExchange(savedOrder.getExchange());
        mo.setLast(savedOrder.getOrderAmt());
        marketService.placeMarketOrder(mo);

        return savedOrder;
    }

}
