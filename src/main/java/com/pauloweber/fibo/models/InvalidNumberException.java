package com.pauloweber.fibo.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The value is not a valid Integer")
public class InvalidNumberException extends RuntimeException {}

