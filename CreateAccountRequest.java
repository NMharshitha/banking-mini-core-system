package com.bankingsystem.dto.request;

import com.bankingsystem.entity.AccountType;

import lombok.Data;

@Data
public class CreateAccountRequest {

    private Long customerId;

    private AccountType accountType;
}