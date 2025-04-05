package com.example.demo.service;

import com.example.demo.model.Fee;
import com.example.demo.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    public Fee calculateAndSaveFee(Fee fee) {
        double rate;

        switch (fee.getExchange().toUpperCase()) {
            case "NYSE" -> rate = 0.01;
            case "NASDAQ" -> rate = 0.015;
            case "TSX" -> rate = 0.02;
            default -> rate = 0.01;
        }

        double feeAmount = fee.isFeeType()
                ? fee.getQuantity() * rate
                : fee.getQuantity() * (rate + 0.005);

        fee.setFeeAmt(feeAmount);
        fee.setFeeDate(LocalDate.now().toString());
        fee.setFeeTime(LocalTime.now().toString());
        fee.setAttribute("Auto-calculated");

        return feeRepository.save(fee);
    }
}
