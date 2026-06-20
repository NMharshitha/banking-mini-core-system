package com.bankingsystem.controller;

import com.bankingsystem.dto.response.AuditResponse;
import com.bankingsystem.service.AuditService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
@RequiredArgsConstructor
public class AuditController {


private final AuditService auditService;

@GetMapping
public List<AuditResponse> getAllAudits() {

    return auditService.getAllAudits();
}


}
