package com.bankingsystem.service.impl;

import com.bankingsystem.dto.request.CreateCustomerRequest;
import com.bankingsystem.dto.request.UpdateCustomerRequest;
import com.bankingsystem.dto.response.CustomerResponse;
import com.bankingsystem.entity.Customer;
import com.bankingsystem.exception.CustomerNotFoundException;
import com.bankingsystem.repository.CustomerRepository;
import com.bankingsystem.service.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


private final CustomerRepository customerRepository;


@Override
public CustomerResponse createCustomer(
        CreateCustomerRequest request) {

    Customer customer = Customer.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .mobileNumber(request.getMobileNumber())
            .build();

    customer = customerRepository.save(customer);

    return CustomerResponse.builder()
            .customerId(customer.getCustomerId())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .email(customer.getEmail())
            .mobileNumber(customer.getMobileNumber())
            .build();
}


@Override
public CustomerResponse getCustomerById(
        Long customerId) {

    Customer customer = customerRepository
            .findById(customerId)
            .orElseThrow(() ->
                    new CustomerNotFoundException(
                            "Customer not found"));

    return CustomerResponse.builder()
            .customerId(customer.getCustomerId())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .email(customer.getEmail())
            .mobileNumber(customer.getMobileNumber())
            .build();
}


@Override
public List<CustomerResponse> getAllCustomers() {

    return customerRepository.findAll()
            .stream()
            .map(customer ->
                    CustomerResponse.builder()
                            .customerId(customer.getCustomerId())
                            .firstName(customer.getFirstName())
                            .lastName(customer.getLastName())
                            .email(customer.getEmail())
                            .mobileNumber(customer.getMobileNumber())
                            .build())
            .collect(Collectors.toList());
}


@Override
public CustomerResponse updateCustomer(
        Long customerId,
        UpdateCustomerRequest request) {

    Customer customer = customerRepository
            .findById(customerId)
            .orElseThrow(() ->
                    new CustomerNotFoundException(
                            "Customer not found"));

    customer.setFirstName(request.getFirstName());
    customer.setLastName(request.getLastName());
    customer.setEmail(request.getEmail());
    customer.setMobileNumber(request.getMobileNumber());

    customer = customerRepository.save(customer);

    return CustomerResponse.builder()
            .customerId(customer.getCustomerId())
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .email(customer.getEmail())
            .mobileNumber(customer.getMobileNumber())
            .build();
}


@Override
public void deleteCustomer(
        Long customerId) {

    Customer customer = customerRepository
            .findById(customerId)
            .orElseThrow(() ->
                    new CustomerNotFoundException(
                            "Customer not found"));

    customerRepository.delete(customer);
}


}
