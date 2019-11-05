package com.trilogyed.peterboyajianrandomquoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PeterBoyajianRandomQuoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeterBoyajianRandomQuoteServiceApplication.class, args);
	}

}
