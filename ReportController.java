package com.bankingsystem.controller;

import com.bankingsystem.dto.response.BalanceSummaryResponse;
import com.bankingsystem.dto.response.StatementResponse;
import com.bankingsystem.service.ReportService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {


private final ReportService reportService;

@GetMapping("/balance/{accountId}")
public BalanceSummaryResponse getBalanceSummary(
        @PathVariable Long accountId) {

    return reportService.getBalanceSummary(accountId);
}

@GetMapping("/statement/{accountId}")
public List<StatementResponse> getStatement(
        @PathVariable Long accountId) {

    return reportService.getStatement(accountId);
}


}
