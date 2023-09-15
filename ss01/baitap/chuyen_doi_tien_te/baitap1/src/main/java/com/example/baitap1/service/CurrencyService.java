package com.example.baitap1.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService{
    //fixed
    public float currencyCalculation(float usd) {
        return usd * 24000;
    }
}
