```sql
-- ============================================
-- SAMPLE TEST DATA
-- Banking Mini Core System
-- ============================================

USE banking_system;

-- ============================================
-- CUSTOMERS
-- ============================================

INSERT INTO customers
(first_name, last_name, email, mobile_number)
VALUES
('Harshitha', 'NM', 'harshitha@gmail.com', '9876543210'),
('Ananya', 'Rao', 'ananya@gmail.com', '9876543211'),
('Rahul', 'Kumar', 'rahul@gmail.com', '9876543212'),
('Priya', 'Sharma', 'priya@gmail.com', '9876543213'),
('Arjun', 'Patel', 'arjun@gmail.com', '9876543214'),
('Sneha', 'Reddy', 'sneha@gmail.com', '9876543215');

-- ============================================
-- ACCOUNTS
-- ============================================

INSERT INTO accounts
(account_number, account_type, balance, customer_id)
VALUES
('ACC100001', 'SAVINGS', 5000.00, 1),
('ACC100002', 'CURRENT', 8000.00, 2),
('ACC100003', 'SAVINGS', 10000.00, 3),
('ACC100004', 'CURRENT', 12000.00, 4),
('ACC100005', 'SAVINGS', 7500.00, 5),
('ACC100006', 'CURRENT', 9000.00, 6);

-- ============================================
-- BANK TRANSACTIONS
-- ============================================

INSERT INTO bank_transactions
(transaction_type, amount, transaction_date, account_id)
VALUES
('DEPOSIT', 5000.00, NOW(), 1),
('DEPOSIT', 8000.00, NOW(), 2),
('DEPOSIT', 10000.00, NOW(), 3),
('WITHDRAW', 2000.00, NOW(), 1),
('TRANSFER', 1500.00, NOW(), 2);

-- ============================================
-- AUDIT LOGS
-- ============================================

INSERT INTO audit_logs
(action, performed_by, action_time)
VALUES
('CUSTOMER_CREATED', 'SYSTEM', NOW()),
('ACCOUNT_CREATED', 'SYSTEM', NOW()),
('DEPOSIT_COMPLETED', 'SYSTEM', NOW()),
('WITHDRAWAL_COMPLETED', 'SYSTEM', NOW()),
('TRANSFER_COMPLETED', 'SYSTEM', NOW());

-- ============================================
-- END OF SAMPLE DATA
-- ============================================
```
