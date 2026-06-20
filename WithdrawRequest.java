package com.bankingsystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawRequest {


private Long accountId;

private BigDecimal amount;


}