package com.bankingsystem.service;

import com.bankingsystem.dto.request.CreateCustomerRequest;
import com.bankingsystem.dto.request.UpdateCustomerRequest;
import com.bankingsystem.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(
            CreateCustomerRequest request);

    CustomerResponse getCustomerById(
            Long customerId);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse updateCustomer(
            Long customerId,
            UpdateCustomerRequest request);

    void deleteCustomer(
            Long customerId);
}