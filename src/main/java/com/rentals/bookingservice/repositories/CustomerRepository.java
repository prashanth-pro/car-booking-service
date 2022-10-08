package com.rentals.bookingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentals.bookingservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {  
}
