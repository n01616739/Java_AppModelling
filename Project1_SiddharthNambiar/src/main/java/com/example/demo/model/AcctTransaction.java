package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "AcctTransaction")
public class AcctTransaction {

    @Id
    private String id;

    private String orderId;
    private String transactionType;
    private String tickerSymbol;
    private double transactionPrice;
    private LocalDateTime orderDateTime;
    private double orderAmt;
    private double balanceAmt;
    private String attribute; 

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getAttribute() { return attribute; }
    public void setAttribute(String attribute) { this.attribute = attribute; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }

    public double getTransactionPrice() { return transactionPrice; }
    public void setTransactionPrice(double transactionPrice) { this.transactionPrice = transactionPrice; }

    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public void setOrderDateTime(LocalDateTime orderDateTime) { this.orderDateTime = orderDateTime; }

    public double getOrderAmt() { return orderAmt; }
    public void setOrderAmt(double orderAmt) { this.orderAmt = orderAmt; }

    public double getBalanceAmt() { return balanceAmt; }
    public void setBalanceAmt(double balanceAmt) { this.balanceAmt = balanceAmt; }
}
