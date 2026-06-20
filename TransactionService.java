package com.bankingsystem.service;

import com.bankingsystem.dto.request.DepositRequest;
import com.bankingsystem.dto.request.TransferRequest;
import com.bankingsystem.dto.request.WithdrawRequest;
import com.bankingsystem.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {

    TransactionResponse deposit(
            DepositRequest request);

    TransactionResponse withdraw(
            WithdrawRequest request);

    void transfer(
            TransferRequest request);

    List<TransactionResponse> getTransactions(
            Long accountId);
}