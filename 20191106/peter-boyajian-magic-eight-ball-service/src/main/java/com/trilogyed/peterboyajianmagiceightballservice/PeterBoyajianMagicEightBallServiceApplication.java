package com.trilogyed.peterboyajianmagiceightballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PeterBoyajianMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeterBoyajianMagicEightBallServiceApplication.class, args);
	}

}
