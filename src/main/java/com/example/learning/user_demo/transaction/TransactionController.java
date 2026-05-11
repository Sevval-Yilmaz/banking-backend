package com.example.learning.user_demo.transaction;

import com.example.learning.user_demo.transaction.dto.TransactionRequestDto;
import com.example.learning.user_demo.transaction.dto.TransactionResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDto> transfer(@Valid @RequestBody TransactionRequestDto dto) {
        transactionService.transfer(dto);
        return ResponseEntity.ok(new TransactionResponseDto("Transfer successful!"));
    }
}
