package com.nexx.spring.eventmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = {EventManagementApiApplication.class,Jsr310Converters.class}) //Scan these classes for entities, JSR310 is for time conversion 
public class EventManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApiApplication.class, args);
	}

}
