package com.rentals.bookingservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentals.bookingservice.model.Car;
import com.rentals.bookingservice.repositories.CarRepository;

@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllAvailableCars(Date pickupTime, Date dropTime, Long id) {
        return carRepository.findByPickupTimeAndDropTime(pickupTime, dropTime, id);
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car get(Long id) {
        return null;
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public Car update(Long id, Car car) {
        Car updatedCar = carRepository.findById(id).orElseThrow(RuntimeException::new);
        updatedCar.setModel(car.getModel());
         
       
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}
