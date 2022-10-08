package com.rentals.bookingservice.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rentals.bookingservice.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM car c WHERE id NOT IN(SELECT r.car_id FROM reservation r WHERE (r.pickup_time BETWEEN ?1 AND ?2) OR (r.drop_time BETWEEN ?1 and ?2)) AND c.location_id = ?3", nativeQuery = true)
    List<Car> findByPickupTimeAndDropTime(Date pickupTime, Date dropTime, Long locationId);

}
