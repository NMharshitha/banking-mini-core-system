package com.bankingsystem.dto.response;

import com.bankingsystem.entity.AccountType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountResponse {

    private Long accountId;

    private String accountNumber;

    private AccountType accountType;

    private BigDecimal balance;

    private Long customerId;
}