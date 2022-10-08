package com.rentals.bookingservice.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidRequestException extends RuntimeException {

    private List<String> errors = new ArrayList<>();

    public InvalidRequestException() {
        super(String.format("The request data is invalid."));
    }

    public InvalidRequestException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
