package com.joe.roomBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	// http://localhost:8086/roomBooking/swagger-ui/index.html
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
}
