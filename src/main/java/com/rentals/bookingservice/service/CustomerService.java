package com.rentals.bookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentals.bookingservice.model.Customer;
import com.rentals.bookingservice.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
