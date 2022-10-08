package com.rentals.bookingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentals.bookingservice.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {  
}
