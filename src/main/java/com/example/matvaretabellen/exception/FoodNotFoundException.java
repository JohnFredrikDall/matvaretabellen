package com.example.matvaretabellen.exception;

public class FoodNotFoundException extends RuntimeException{
    public FoodNotFoundException(String message) {
        super(message);
    }
}
