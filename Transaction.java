package com.bankingsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private String transactionType;

    private BigDecimal amount;

    private LocalDateTime transactionDate;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}