package com.example.matvaretabellen.exception;

public class FoodListNotFoundException extends RuntimeException{
    public FoodListNotFoundException(String message) {
        super(message);
    }
}
