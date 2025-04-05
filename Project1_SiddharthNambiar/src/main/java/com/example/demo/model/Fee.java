package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Fee")
public class Fee {

    @Id
    private String id;

    private String exchange;
    private boolean feeType; // true = BUY, false = SELL
    private int quantity;
    private double feeAmt;
    private String feeDate;
    private String feeTime;
    private String attribute;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getExchange() { return exchange; }
    public void setExchange(String exchange) { this.exchange = exchange; }

    public boolean isFeeType() { return feeType; }
    public void setFeeType(boolean feeType) { this.feeType = feeType; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getFeeAmt() { return feeAmt; }
    public void setFeeAmt(double feeAmt) { this.feeAmt = feeAmt; }

    public String getFeeDate() { return feeDate; }
    public void setFeeDate(String feeDate) { this.feeDate = feeDate; }

    public String getFeeTime() { return feeTime; }
    public void setFeeTime(String feeTime) { this.feeTime = feeTime; }

    public String getAttribute() { return attribute; }
    public void setAttribute(String attribute) { this.attribute = attribute; }
}
