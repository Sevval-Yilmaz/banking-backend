package com.example.learning.user_demo.account;

import com.example.learning.user_demo.account.dto.AccountRequestDto;
import com.example.learning.user_demo.account.dto.AccountResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponseDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping
    public AccountResponseDto createAccount(@RequestBody AccountRequestDto requestDto) {
        return accountService.createAccount(requestDto);
    }
}
