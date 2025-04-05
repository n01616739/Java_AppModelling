package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Order")
public class Order {

    @Id
    private String id;

    private String stockName;
    private int quantity;
    private String accountId;
    private double orderAmt;
    private Date createdAt = new Date();
    private double feeAmt;
    private String orderType;  // BUY or SELL
    private String exchange;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStockName() { return stockName; }
    public void setStockName(String stockName) { this.stockName = stockName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public double getOrderAmt() { return orderAmt; }
    public void setOrderAmt(double orderAmt) { this.orderAmt = orderAmt; }
//
//    public boolean isAddMoreAsRequired() { return addMoreAsRequired; }
//    public void setAddMoreAsRequired(boolean addMoreAsRequired) { this.addMoreAsRequired = addMoreAsRequired; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public double getFeeAmt() { return feeAmt; }
    public void setFeeAmt(double feeAmt) { this.feeAmt = feeAmt; }

    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }

    public String getExchange() { return exchange; }
    public void setExchange(String exchange) { this.exchange = exchange; }
}
