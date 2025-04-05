package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Market")
public class MarketOrder {

    @Id
    private String id;

    private String orderId;
    private int transactionId;
    private double feeId;
    private double bid;
    private double ask;
    private double previous;
    private double last;
    private String typeOfExchange;
    private String confirmationStatus;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public double getFeeId() { return feeId; }
    public void setFeeId(double feeId) { this.feeId = feeId; }

    public double getBid() { return bid; }
    public void setBid(double bid) { this.bid = bid; }

    public double getAsk() { return ask; }
    public void setAsk(double ask) { this.ask = ask; }

    public double getPrevious() { return previous; }
    public void setPrevious(double previous) { this.previous = previous; }

    public double getLast() { return last; }
    public void setLast(double last) { this.last = last; }

    public String getTypeOfExchange() { return typeOfExchange; }
    public void setTypeOfExchange(String typeOfExchange) { this.typeOfExchange = typeOfExchange; }

    public String getConfirmationStatus() { return confirmationStatus; }
    public void setConfirmationStatus(String confirmationStatus) { this.confirmationStatus = confirmationStatus; }
}
