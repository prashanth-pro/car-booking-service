package com.rentals.bookingservice.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentals.bookingservice.dto.ReservationRequestDto;
import com.rentals.bookingservice.exception.InvalidRequestException;
import com.rentals.bookingservice.model.Car;
import com.rentals.bookingservice.model.Customer;
import com.rentals.bookingservice.model.Location;
import com.rentals.bookingservice.model.Reservation;
import com.rentals.bookingservice.repositories.CarRepository;
import com.rentals.bookingservice.repositories.CustomerRepository;
import com.rentals.bookingservice.repositories.LocationRepository;

@Component
public class ReservationValidator {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarRepository carRepository;
     
    public Reservation validateAndConvertReservation(ReservationRequestDto reservationRequestDto) throws InvalidRequestException {
        Reservation reservation = new Reservation();

        List<String> errors = new ArrayList<>();
        validateCustomer(reservationRequestDto, reservation, errors);
        validateCar(reservationRequestDto, reservation, errors);
        validateLocation(reservationRequestDto, reservation, errors);
        validateDates(reservationRequestDto, reservation, errors);

        // check if the booking is already present
        if (errors.size() > 0) {
            throw new InvalidRequestException(errors);
        }

        return reservation;
    }

    private void validateDates(ReservationRequestDto reservationRequestDto,  Reservation reservation, List<String> errors) {
        Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
        if (reservationRequestDto.getPickupTime().compareTo(tomorrow) < 0 ||
        reservationRequestDto.getDropTime().compareTo(tomorrow) < 0 ||
        reservationRequestDto.getDropTime().compareTo(reservationRequestDto.getPickupTime()) == 0 ||
        reservationRequestDto.getDropTime().compareTo(reservationRequestDto.getPickupTime()) == -1) {
            errors.add("invalid pickup time and drop time");
        } else {
            reservation.setPickupTime(reservationRequestDto.getPickupTime());
            reservation.setDropTime(reservationRequestDto.getDropTime());
        }
    }

    private void validateCustomer(ReservationRequestDto reservationRequestDto, Reservation reservation, List<String> errors) {
        if (reservationRequestDto.getCustomerId() == null) {
            errors.add("invalid customer id");
        } else {
            Optional<Customer> customer = customerRepository.findById(reservationRequestDto.getCustomerId());
            if (customer.isEmpty()) {
                errors.add("invalid customer id");
            } else {
                reservation.setCustomer(customer.get());
            }
        }
    }

    private void validateLocation(ReservationRequestDto reservationRequestDto, Reservation reservation, List<String> errors) {
        if (reservationRequestDto.getLocationId() == null) {
            errors.add("invalid location id");
        } else {
            Optional<Location> location = locationRepository.findById(reservationRequestDto.getLocationId());
            if (location.isEmpty()) {
                errors.add("invalid location id");
            } else {
                reservation.setLocation(location.get());
            }
        }
    }

    private void validateCar(ReservationRequestDto reservationRequestDto, Reservation reservation, List<String> errors) {
        if (reservationRequestDto.getCarId() == null) {
            errors.add("invalid car id");
        } else {
            Optional<Car> car = carRepository.findById(reservationRequestDto.getCarId());
            if (car.isEmpty()) {
                errors.add("invalid car id");
            } else {
                reservation.setCar(car.get());
            }
        }
    }
}
