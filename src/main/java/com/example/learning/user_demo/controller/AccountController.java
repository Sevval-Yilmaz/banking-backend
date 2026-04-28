package com.example.learning.user_demo.controller;

import com.example.learning.user_demo.dto.AccountRequestDto;
import com.example.learning.user_demo.dto.AccountResponseDto;
import com.example.learning.user_demo.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponseDto createAccount(@RequestBody AccountRequestDto requestDto) {
        return accountService.createAccount(requestDto);
    }
}
