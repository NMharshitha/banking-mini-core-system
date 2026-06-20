package com.bankingsystem.controller;

import com.bankingsystem.dto.request.CreateAccountRequest;
import com.bankingsystem.dto.response.AccountResponse;
import com.bankingsystem.service.AccountService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {


private final AccountService accountService;

@PostMapping
public AccountResponse createAccount(
        @RequestBody CreateAccountRequest request) {

    return accountService.createAccount(request);
}

@GetMapping("/{id}")
public AccountResponse getAccountById(
        @PathVariable Long id) {

    return accountService.getAccountById(id);
}

@GetMapping
public List<AccountResponse> getAllAccounts() {

    return accountService.getAllAccounts();
}

@DeleteMapping("/{id}")
public String deleteAccount(
        @PathVariable Long id) {

    accountService.deleteAccount(id);

    return "Account deleted successfully";
}


}
