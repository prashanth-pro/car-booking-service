package com.rentals.bookingservice.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.bookingservice.model.Customer;
import com.rentals.bookingservice.service.CustomerService;

// access: admin
@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    // apis for admins
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // apis for admins
    @PostMapping
    public ResponseEntity<Customer> createCar(@RequestBody Customer customer) throws URISyntaxException {
        Customer savedCustomer = customerService.save(customer);
        return ResponseEntity.created(new URI("/customers/" + savedCustomer.getId())).body(savedCustomer);
    }

}
