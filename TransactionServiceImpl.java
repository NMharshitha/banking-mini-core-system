package com.bankingsystem.service.impl;

import com.bankingsystem.dto.request.DepositRequest;
import com.bankingsystem.dto.request.TransferRequest;
import com.bankingsystem.dto.request.WithdrawRequest;
import com.bankingsystem.dto.response.TransactionResponse;
import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.Transaction;
import com.bankingsystem.exception.AccountNotFoundException;
import com.bankingsystem.exception.InsufficientBalanceException;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.TransactionRepository;
import com.bankingsystem.service.AuditService;
import com.bankingsystem.service.TransactionService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {


private static final Logger logger =
        LoggerFactory.getLogger(
                TransactionServiceImpl.class);

private final AccountRepository accountRepository;

private final TransactionRepository transactionRepository;

private final AuditService auditService;


@Transactional
@Override
public TransactionResponse deposit(
        DepositRequest request) {

    Account account =
            accountRepository.findById(
                    request.getAccountId())
                    .orElseThrow(() ->
                            new AccountNotFoundException(
                                    "Account not found"));

    account.setBalance(
            account.getBalance()
                    .add(request.getAmount()));

    accountRepository.save(account);

    Transaction transaction =
            Transaction.builder()
                    .transactionType("DEPOSIT")
                    .amount(request.getAmount())
                    .transactionDate(
                            LocalDateTime.now())
                    .account(account)
                    .build();

    transactionRepository.save(transaction);

    auditService.saveAudit(
            "DEPOSIT",
            "SYSTEM",
            "Deposited "
                    + request.getAmount()
                    + " to account "
                    + request.getAccountId());

    logger.info(
            "Amount {} deposited to account {}",
            request.getAmount(),
            request.getAccountId());

    return TransactionResponse.builder()
            .transactionId(
                    transaction.getTransactionId())
            .transactionType(
                    transaction.getTransactionType())
            .amount(
                    transaction.getAmount())
            .transactionDate(
                    transaction.getTransactionDate())
            .build();
}



@Transactional
@Override
public TransactionResponse withdraw(
        WithdrawRequest request) {

    Account account =
            accountRepository.findById(
                    request.getAccountId())
                    .orElseThrow(() ->
                            new AccountNotFoundException(
                                    "Account not found"));

    if (account.getBalance()
            .compareTo(request.getAmount()) < 0) {

        throw new InsufficientBalanceException(
                "Insufficient Balance");
    }

    account.setBalance(
            account.getBalance()
                    .subtract(request.getAmount()));

    accountRepository.save(account);

    Transaction transaction =
            Transaction.builder()
                    .transactionType("WITHDRAW")
                    .amount(request.getAmount())
                    .transactionDate(
                            LocalDateTime.now())
                    .account(account)
                    .build();

    transactionRepository.save(transaction);

    auditService.saveAudit(
            "WITHDRAW",
            "SYSTEM",
            "Withdrawn "
                    + request.getAmount()
                    + " from account "
                    + request.getAccountId());

    logger.info(
            "Amount {} withdrawn from account {}",
            request.getAmount(),
            request.getAccountId());

    return TransactionResponse.builder()
            .transactionId(
                    transaction.getTransactionId())
            .transactionType(
                    transaction.getTransactionType())
            .amount(
                    transaction.getAmount())
            .transactionDate(
                    transaction.getTransactionDate())
            .build();
}



@Transactional
@Override
public void transfer(
        TransferRequest request) {

    Account fromAccount =
            accountRepository.findById(
                    request.getFromAccountId())
                    .orElseThrow(() ->
                            new AccountNotFoundException(
                                    "Sender Account not found"));

    Account toAccount =
            accountRepository.findById(
                    request.getToAccountId())
                    .orElseThrow(() ->
                            new AccountNotFoundException(
                                    "Receiver Account not found"));

    if (fromAccount.getBalance()
            .compareTo(request.getAmount()) < 0) {

        throw new InsufficientBalanceException(
                "Insufficient Balance");
    }

    fromAccount.setBalance(
            fromAccount.getBalance()
                    .subtract(request.getAmount()));

    toAccount.setBalance(
            toAccount.getBalance()
                    .add(request.getAmount()));

    accountRepository.save(fromAccount);

    accountRepository.save(toAccount);


    Transaction debitTransaction =
            Transaction.builder()
                    .transactionType(
                            "TRANSFER_DEBIT")
                    .amount(
                            request.getAmount())
                    .transactionDate(
                            LocalDateTime.now())
                    .account(fromAccount)
                    .build();

    transactionRepository.save(
            debitTransaction);


    Transaction creditTransaction =
            Transaction.builder()
                    .transactionType(
                            "TRANSFER_CREDIT")
                    .amount(
                            request.getAmount())
                    .transactionDate(
                            LocalDateTime.now())
                    .account(toAccount)
                    .build();

    transactionRepository.save(
            creditTransaction);


    auditService.saveAudit(
            "TRANSFER",
            "SYSTEM",
            "Transferred "
                    + request.getAmount()
                    + " from account "
                    + request.getFromAccountId()
                    + " to account "
                    + request.getToAccountId());

    logger.info(
            "Transferred {} from {} to {}",
            request.getAmount(),
            request.getFromAccountId(),
            request.getToAccountId());
}



@Override
public List<TransactionResponse>
getTransactions(
        Long accountId) {

    List<Transaction> transactions =
            transactionRepository
                    .findByAccountAccountId(
                            accountId);

    return transactions.stream()
            .map(transaction ->
                    TransactionResponse
                            .builder()
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
