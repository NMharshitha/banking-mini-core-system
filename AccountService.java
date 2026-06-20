package com.bankingsystem.service;

import com.bankingsystem.dto.request.CreateAccountRequest;
import com.bankingsystem.dto.response.AccountResponse;

import java.util.List;

public interface AccountService {

    AccountResponse createAccount(
            CreateAccountRequest request);

    AccountResponse getAccountById(
            Long accountId);

    List<AccountResponse> getAllAccounts();

    void deleteAccount(
            Long accountId);
}