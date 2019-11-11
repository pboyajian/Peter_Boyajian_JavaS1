package com.trilogyed.rsvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RsvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsvpApplication.class, args);
	}

}
