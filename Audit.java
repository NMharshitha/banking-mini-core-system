package com.bankingsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    private String action;

    private String performedBy;

    private String description;

    private LocalDateTime timestamp;

}