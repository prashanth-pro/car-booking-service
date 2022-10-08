package com.rentals.bookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentals.bookingservice.model.Location;
import com.rentals.bookingservice.repositories.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
}
