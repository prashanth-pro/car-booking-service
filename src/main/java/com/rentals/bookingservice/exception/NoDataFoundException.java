package com.rentals.bookingservice.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super(String.format("The requested object not found."));
    }
}
