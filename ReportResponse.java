package com.bankingsystem.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ReportResponse {

    private Long accountId;

    private String accountNumber;

    private BigDecimal balance;

    private Long totalTransactions;
}