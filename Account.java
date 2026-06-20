package com.bankingsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private BigDecimal balance;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}