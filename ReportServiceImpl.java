package com.bankingsystem.service.impl;

import com.bankingsystem.dto.response.BalanceSummaryResponse;
import com.bankingsystem.dto.response.StatementResponse;
import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.Transaction;
import com.bankingsystem.exception.AccountNotFoundException;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.TransactionRepository;
import com.bankingsystem.service.ReportService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


private final AccountRepository accountRepository;

private final TransactionRepository transactionRepository;


@Override
public BalanceSummaryResponse getBalanceSummary(
Long accountId) {


Account account = accountRepository
        .findById(accountId)
        .orElseThrow(() ->
                new AccountNotFoundException(
                        "Account not found"));

return BalanceSummaryResponse.builder()
        .accountId(
                account.getAccountId())
        .accountNumber(
                account.getAccountNumber())
        .balance(
                account.getBalance())
        .build();


}

@Override
public List<StatementResponse> getStatement(
        Long accountId) {

    List<Transaction> transactions =
            transactionRepository
                    .findByAccountAccountId(
                            accountId);

    return transactions.stream()
            .map(transaction ->
                    StatementResponse.builder()
                            .transactionId(
                                    transaction.getTransactionId())
                            .transactionType(
                                    transaction.getTransactionType())
                            .amount(
                                    transaction.getAmount())
                            .transactionDate(
                                    transaction.getTransactionDate())
                            .build())
            .collect(Collectors.toList());
}


}
