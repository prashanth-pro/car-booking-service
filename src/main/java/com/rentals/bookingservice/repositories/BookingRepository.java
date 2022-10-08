package com.rentals.bookingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentals.bookingservice.model.Reservation;

public interface BookingRepository extends JpaRepository<Reservation, Long> {
}
