package com.example.learning.user_demo.controller;

import com.example.learning.user_demo.dto.TransactionRequestDto;
import com.example.learning.user_demo.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void transfer(@RequestBody TransactionRequestDto dto) {
        transactionService.transfer(dto);
    }
}
