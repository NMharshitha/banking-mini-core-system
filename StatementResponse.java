package com.bankingsystem.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class StatementResponse {


private Long transactionId;

private String transactionType;

private BigDecimal amount;

private LocalDateTime transactionDate;


}
