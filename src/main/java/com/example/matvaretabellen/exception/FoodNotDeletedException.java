package com.example.matvaretabellen.exception;

public class FoodNotDeletedException extends RuntimeException {
    public FoodNotDeletedException(String message) {
        super(message);
    }
}
