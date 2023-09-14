package com.example.baitap1.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService{
    public double currencyCalculation(int usd) {
        return usd * 24000;
    }
}
