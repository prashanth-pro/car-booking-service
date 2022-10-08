package com.rentals.bookingservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationResponseDto {

    @JsonProperty("booking_id")
    private String bookingId;

    @JsonProperty("status")
    private String status;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
