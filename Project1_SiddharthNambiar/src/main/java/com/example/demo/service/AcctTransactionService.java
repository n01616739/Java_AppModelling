package com.example.demo.service;

import com.example.demo.model.AcctTransaction;
import com.example.demo.repository.AcctTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AcctTransactionService {

    @Autowired
    private AcctTransactionRepository transactionRepository;

    public AcctTransaction reserveStock(AcctTransaction tx) {
        tx.setOrderDateTime(LocalDateTime.now());
        tx.setTransactionType("SELL");
        tx.setBalanceAmt(tx.getOrderAmt() - tx.getTransactionPrice());
        tx.setAttribute("Reserved for sell");
        return transactionRepository.save(tx);
    }
}
