package com.bankingsystem.repository;

import com.bankingsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}