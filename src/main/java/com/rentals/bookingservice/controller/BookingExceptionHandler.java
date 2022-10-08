
package com.rentals.bookingservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rentals.bookingservice.exception.InvalidRequestException;
import com.rentals.bookingservice.exception.NoDataFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class BookingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNodataFoundException(
            NoDataFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("errors", ex.getMessage());
        //log.error("error : ", ex);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(InvalidRequestException ex,
            WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", ex.getErrors());
        // log.error("error : ", ex);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}