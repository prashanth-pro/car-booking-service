package com.rentals.bookingservice.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.bookingservice.model.Location;
import com.rentals.bookingservice.service.LocationService;

// access: admin
@RestController
@RequestMapping("/locations")
public class LocationController {
    
    @Autowired
    private LocationService locationService;

    // apis for admins
    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    // apis for admins
    @PostMapping
    public ResponseEntity<Location> createCar(@RequestBody Location location) throws URISyntaxException {
        Location savedLocation = locationService.save(location);
        return ResponseEntity.created(new URI("/locations/" + savedLocation.getId())).body(savedLocation);
    }

}
