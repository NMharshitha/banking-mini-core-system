package com.bankingsystem.service.impl;

import com.bankingsystem.dto.request.CreateAccountRequest;
import com.bankingsystem.dto.response.AccountResponse;
import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.Customer;
import com.bankingsystem.exception.AccountNotFoundException;
import com.bankingsystem.exception.CustomerNotFoundException;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.CustomerRepository;
import com.bankingsystem.service.AccountService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


private final AccountRepository accountRepository;

private final CustomerRepository customerRepository;


@Override
public AccountResponse createAccount(
        CreateAccountRequest request) {

    Customer customer = customerRepository
            .findById(request.getCustomerId())
            .orElseThrow(() ->
                    new CustomerNotFoundException(
                            "Customer not found"));

    Account account = Account.builder()
            .accountNumber(
                    "ACC" +
                    UUID.randomUUID()
                            .toString()
                            .substring(0, 8))
            .accountType(
                    request.getAccountType())
            .balance(BigDecimal.ZERO)
            .customer(customer)
            .build();

    account = accountRepository.save(account);

    return AccountResponse.builder()
            .accountId(account.getAccountId())
            .accountNumber(account.getAccountNumber())
            .accountType(account.getAccountType())
            .balance(account.getBalance())
            .customerId(customer.getCustomerId())
            .build();
}


@Override
public AccountResponse getAccountById(
        Long accountId) {

    Account account = accountRepository
            .findById(accountId)
            .orElseThrow(() ->
                    new AccountNotFoundException(
                            "Account not found"));

    return AccountResponse.builder()
            .accountId(account.getAccountId())
            .accountNumber(account.getAccountNumber())
            .accountType(account.getAccountType())
            .balance(account.getBalance())
            .customerId(
                    account.getCustomer()
                           .getCustomerId())
            .build();
}


@Override
public List<AccountResponse> getAllAccounts() {

    return accountRepository.findAll()
            .stream()
            .map(account ->
                    AccountResponse.builder()
                            .accountId(account.getAccountId())
                            .accountNumber(account.getAccountNumber())
                            .accountType(account.getAccountType())
                            .balance(account.getBalance())
                            .customerId(
                                    account.getCustomer()
                                           .getCustomerId())
                            .build())
            .collect(Collectors.toList());
}


@Override
public void deleteAccount(
        Long accountId) {

    accountRepository.deleteById(accountId);
}


}
