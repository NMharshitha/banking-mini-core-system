package com.bankingsystem.service.impl;

import com.bankingsystem.dto.response.AuditResponse;
import com.bankingsystem.entity.Audit;
import com.bankingsystem.repository.AuditRepository;
import com.bankingsystem.service.AuditService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {


private final AuditRepository auditRepository;


@Override
public void saveAudit(
        String action,
        String performedBy,
        String description) {

    Audit audit = Audit.builder()
            .action(action)
            .performedBy(performedBy)
            .description(description)
            .timestamp(LocalDateTime.now())
            .build();

    auditRepository.save(audit);
}


@Override
public List<AuditResponse> getAllAudits() {

    return auditRepository.findAll()
            .stream()
            .map(audit ->
                    AuditResponse.builder()
                            .auditId(
                                    audit.getAuditId())
                            .action(
                                    audit.getAction())
                            .performedBy(
                                    audit.getPerformedBy())
                            .description(
                                    audit.getDescription())
                            .timestamp(
                                    audit.getTimestamp())
                            .build())
            .collect(Collectors.toList());
}


}
