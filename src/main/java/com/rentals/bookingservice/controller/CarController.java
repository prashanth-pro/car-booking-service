package com.rentals.bookingservice.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.bookingservice.model.Car;
import com.rentals.bookingservice.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // apis for customers
    @GetMapping("/available")
    public List<Car> getAllAvailableCars(
            @RequestParam("pickup") @DateTimeFormat(pattern = "yyyy-MM-dd") Date pickupTime,
            @RequestParam("drop") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dropTime,
            @RequestParam("location") Long id) {
        return carService.getAllAvailableCars(pickupTime, dropTime, id);
    }

    // apis for admins - start
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCarById(id).get();
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) throws URISyntaxException {
        Car savedCar = carService.save(car);
        return ResponseEntity.created(new URI("/cars/" + savedCar.getId())).body(savedCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car updatedCar = carService.update(id, car);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.ok().build();
    }
    // apis for admins - end

}
