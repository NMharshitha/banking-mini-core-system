```sql
-- ============================================
-- Banking Mini Core System
-- Database Schema
-- ============================================

CREATE DATABASE IF NOT EXISTS banking_system;

USE banking_system;

-- ============================================
-- CUSTOMERS TABLE
-- ============================================

CREATE TABLE customers (

    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    first_name VARCHAR(255) NOT NULL,

    last_name VARCHAR(255) NOT NULL,

    email VARCHAR(255) NOT NULL UNIQUE,

    mobile_number VARCHAR(20) UNIQUE,

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP

);

-- ============================================
-- ACCOUNTS TABLE
-- ============================================

CREATE TABLE accounts (

    account_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    account_number VARCHAR(255) NOT NULL UNIQUE,

    account_type ENUM('SAVINGS','CURRENT') NOT NULL,

    balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,

    customer_id BIGINT NOT NULL,

    CONSTRAINT FK_ACCOUNT_CUSTOMER
        FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
        ON DELETE CASCADE

);

-- ============================================
-- TRANSACTIONS TABLE
-- ============================================

CREATE TABLE transactions (

    transaction_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    transaction_type VARCHAR(50) NOT NULL,

    amount DECIMAL(15,2) NOT NULL,

    transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP,

    account_id BIGINT NOT NULL,

    CONSTRAINT FK_TRANSACTION_ACCOUNT
        FOREIGN KEY (account_id)
        REFERENCES accounts(account_id)
        ON DELETE CASCADE

);

-- ============================================
-- AUDIT LOGS TABLE
-- ============================================

CREATE TABLE audit_logs (

    audit_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    action VARCHAR(255) NOT NULL,

    performed_by VARCHAR(255),

    description VARCHAR(500),

    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP

);

-- ============================================
-- END OF SCHEMA
-- ============================================
```
