package com.example.learning.user_demo.dto;

public class TransactionResponseDto {
    private String message;

    public TransactionResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
