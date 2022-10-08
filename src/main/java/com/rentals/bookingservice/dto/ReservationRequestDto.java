package com.rentals.bookingservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationRequestDto {
    
    @JsonProperty("customer_id")
    private Long customerId;

    @JsonProperty("car_id")
    private Long carId;

    @JsonProperty("location_id")
    private Long locationId;

    @JsonProperty("pickupTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date pickupTime;

    @JsonProperty("dropTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dropTime;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Date getDropTime() {
        return dropTime;
    }

    public void setDropTime(Date dropTime) {
        this.dropTime = dropTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    
    
}
