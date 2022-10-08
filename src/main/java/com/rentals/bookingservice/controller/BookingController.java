package com.rentals.bookingservice.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.bookingservice.dto.ReservationRequestDto;
import com.rentals.bookingservice.dto.ReservationResponseDto;
import com.rentals.bookingservice.model.Reservation;
import com.rentals.bookingservice.service.BookingService;
import com.rentals.bookingservice.validator.ReservationValidator;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ReservationValidator reservationValidator;

    // api for customers
    @PostMapping
    public ResponseEntity<ReservationResponseDto> bookCar(@RequestBody ReservationRequestDto reservationRequestDto)
            throws URISyntaxException, NoSuchAlgorithmException {

        // validate request and construct reservation
        Reservation reservation = reservationValidator.validateAndConvertReservation(reservationRequestDto);
        ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
        final String bookingId = generateBookingId();
        // generate booking id
        try {
            reservation.setBookingId(bookingId);
            bookingService.save(reservation);
            // reservation response
            reservationResponseDto.setBookingId(bookingId);
            reservationResponseDto.setStatus("SUCCESS");
        } catch (Exception ex) {
            reservationResponseDto.setBookingId(bookingId);
            reservationResponseDto.setStatus("FAILED");
        }

        return ResponseEntity.created(new URI("/cars/" + reservation.getId()) ).body(reservationResponseDto);
    }

    private String generateBookingId() throws NoSuchAlgorithmException {
        String chrs = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        String bookingId = secureRandom.ints(15, 0, chrs.length()).mapToObj(i -> chrs.charAt(i))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        return bookingId;
    }

    // apis for admins
    @GetMapping
    public List<Reservation> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
