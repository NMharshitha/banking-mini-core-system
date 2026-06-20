package com.bankingsystem.service;

import com.bankingsystem.dto.response.BalanceSummaryResponse;
import com.bankingsystem.dto.response.StatementResponse;

import java.util.List;

public interface ReportService {

BalanceSummaryResponse getBalanceSummary(
        Long accountId);

List<StatementResponse> getStatement(
        Long accountId);


}
