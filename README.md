# Banking Mini Core System

## Overview

Banking Mini Core System is a Spring Boot based REST API application that simulates core banking operations including customer management, account management, transaction processing, audit logging, and reporting.

The application is designed using a layered architecture and follows industry-standard development practices such as DTO pattern, validation, centralized exception handling, logging, and RESTful API design.

---

## Objectives

This project demonstrates the implementation of a simplified Core Banking System with:

* Customer Management
* Account Management
* Transaction Processing
* Audit Logging
* Reporting
* REST API Development
* Exception Handling
* Unit Testing

---

## Features

### Customer Management

* Create Customer
* Get Customer By ID
* Get All Customers
* Update Customer
* Delete Customer

### Account Management

* Create Savings Account
* Create Current Account
* Get Account By ID
* Get All Accounts
* Delete Account
* Balance Tracking

### Transaction Management

* Deposit Money
* Withdraw Money
* Transfer Funds
* Transaction History

### Reporting

* Balance Summary
* Account Statement

### Audit Logging

* Transaction Activity Logs
* Account Activity Logs
* Customer Activity Logs

---

## Technology Stack

| Technology         | Version  |
| ------------------ | -------- |
| Java               | 21/25    |
| Spring Boot        | 3.x      |
| Spring Data JPA    | Latest   |
| PostgreSQL / MySQL | Database |
| Maven              | Latest   |
| Lombok             | Latest   |
| Swagger OpenAPI    | Latest   |
| JUnit 5            | Latest   |
| Mockito            | Latest   |
| SLF4J              | Latest   |

---

## Project Architecture

```text
Client
   |
   v
Controller Layer
   |
   v
Service Layer
   |
   v
Repository Layer
   |
   v
Database

Service Layer
   |
   ├── Validation
   ├── Transaction Logic
   └── Audit Logging

GlobalExceptionHandler
   |
   └── Centralized Error Handling
```

---

## Package Structure

```text
src/main/java/com/banking

├── controller
├── dto
├── entity
├── exception
├── repository
├── service
├── service.impl
└── BankingApplication
```

---

## Database Schema

### Customer

* customer_id
* first_name
* last_name
* email
* mobile_number

### Account

* account_id
* account_number
* balance
* account_type
* customer_id

### Bank Transaction

* transaction_id
* transaction_type
* amount
* transaction_date
* account_id

### Audit Log

* audit_id
* action
* action_time

---

## Entity Relationship Diagram

```text
Customer (1)
      |
      | One-to-Many
      v
Account (Many)

Account (1)
      |
      | One-to-Many
      v
BankTransaction (Many)

AuditLog (Independent Entity)
```

---

## API Endpoints

### Customer APIs

| Method | Endpoint            |
| ------ | ------------------- |
| POST   | /api/customers      |
| GET    | /api/customers      |
| GET    | /api/customers/{id} |
| PUT    | /api/customers/{id} |
| DELETE | /api/customers/{id} |

### Account APIs

| Method | Endpoint           |
| ------ | ------------------ |
| POST   | /api/accounts      |
| GET    | /api/accounts      |
| GET    | /api/accounts/{id} |
| DELETE | /api/accounts/{id} |

### Transaction APIs

| Method | Endpoint                      |
| ------ | ----------------------------- |
| POST   | /api/transactions/deposit     |
| POST   | /api/transactions/withdraw    |
| POST   | /api/transactions/transfer    |
| GET    | /api/transactions/{accountId} |

### Report APIs

| Method | Endpoint                           |
| ------ | ---------------------------------- |
| GET    | /api/reports/balance/{accountId}   |
| GET    | /api/reports/statement/{accountId} |

### Audit APIs

| Method | Endpoint    |
| ------ | ----------- |
| GET    | /api/audits |

---

## Validation

Implemented using:

* @NotNull
* @NotBlank
* @Email
* @Positive

---

## Exception Handling

Centralized exception handling is implemented using:

```java
@RestControllerAdvice
```

Handled Exceptions:

* ResourceNotFoundException
* IllegalArgumentException
* Validation Exceptions
* Runtime Exceptions

---

## Logging

Implemented using SLF4J.

Logged Events:

* Customer Creation
* Account Creation
* Deposits
* Withdrawals
* Transfers
* Error Events

---

## Transaction Management

Implemented using:

```java
@Transactional
```

Supports ACID principles:

* Atomicity
* Consistency
* Isolation
* Durability

---

## Swagger Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

---

## Unit Testing

Frameworks:

* JUnit 5
* Mockito

Coverage Includes:

* Service Layer Testing
* Validation Testing
* Exception Testing
* Transaction Testing

---

## Build and Run

### Build

```bash
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

or run:

```text
BankingApplication.java
```

---

## Deliverables

* Spring Boot Source Code
* REST API Documentation
* Database Schema Design
* ER Diagram
* Unit Test Cases
* Architecture Documentation
* Swagger Documentation

---

## Author

**Harshitha N M**
