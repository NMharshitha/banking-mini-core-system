package com.bankingsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String mobileNumber;

    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Account> accounts = new ArrayList<>();


    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();
    }
}