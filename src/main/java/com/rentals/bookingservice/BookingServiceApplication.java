package com.rentals.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}

/*
 *	az spring app deploy --name todo-service --service "springmicro" --resource-group "azure-learning" --jar-path target/booking-service-0.0.1-SNAPSHOT.jar
 *
 */