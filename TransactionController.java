package com.bankingsystem.controller;

import com.bankingsystem.dto.request.DepositRequest;
import com.bankingsystem.dto.request.TransferRequest;
import com.bankingsystem.dto.request.WithdrawRequest;
import com.bankingsystem.dto.response.TransactionResponse;
import com.bankingsystem.service.TransactionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {


private final TransactionService transactionService;

@PostMapping("/deposit")
public TransactionResponse deposit(
        @RequestBody DepositRequest request) {

    return transactionService.deposit(request);
}

@PostMapping("/withdraw")
public TransactionResponse withdraw(
        @RequestBody WithdrawRequest request) {

    return transactionService.withdraw(request);
}

@PostMapping("/transfer")
public String transfer(
        @RequestBody TransferRequest request) {

    transactionService.transfer(request);

    return "Amount transferred successfully";
}

@GetMapping("/{accountId}")
public List<TransactionResponse> getTransactions(
        @PathVariable Long accountId) {

    return transactionService.getTransactions(accountId);
}


}
