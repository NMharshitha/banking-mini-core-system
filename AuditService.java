package com.bankingsystem.service;

import com.bankingsystem.dto.response.AuditResponse;

import java.util.List;

public interface AuditService {

    void saveAudit(
            String action,
            String performedBy,
            String description);

    List<AuditResponse> getAllAudits();
}