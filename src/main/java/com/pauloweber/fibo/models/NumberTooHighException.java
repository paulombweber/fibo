package com.pauloweber.fibo.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "the maximum allowed value is 5000000")
public class NumberTooHighException extends RuntimeException {}

