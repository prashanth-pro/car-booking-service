package com.rentals.bookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentals.bookingservice.model.Reservation;
import com.rentals.bookingservice.repositories.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public Reservation save(Reservation reservation) {
        return bookingRepository.save(reservation);
    }

    public List<Reservation> getAllBookings() {
        return bookingRepository.findAll();
    }

}
