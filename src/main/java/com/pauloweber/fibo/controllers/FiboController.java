package com.pauloweber.fibo.controllers;

import com.pauloweber.fibo.components.FiboLogComponent;
import com.pauloweber.fibo.models.InvalidNumberException;
import com.pauloweber.fibo.models.NumberTooHighException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FiboController {

    @Autowired
    FiboLogComponent component;

    @GetMapping("fib")
    public BigInteger getFibo(@RequestParam String n) {
        int number;
        try {
            number = Integer.parseInt(n);
        } catch (NumberFormatException nfe) {
            throw new InvalidNumberException();
        }
        if (number > 5000000) {
            throw new NumberTooHighException();
        }
        return component.getFibo(number);
    }
}