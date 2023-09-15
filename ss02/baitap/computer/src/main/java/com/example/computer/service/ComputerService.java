package com.example.computer.service;

import org.springframework.stereotype.Service;

@Service
public class ComputerService {
    public double Calculate(String calculation,int number1, int number2){
        double result = 0;
        switch (calculation){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        return result;
    }
}
