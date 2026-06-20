package com.bankingsystem.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AuditResponse {

    private Long auditId;

    private String action;

    private String performedBy;

    private String description;

    private LocalDateTime timestamp;
}