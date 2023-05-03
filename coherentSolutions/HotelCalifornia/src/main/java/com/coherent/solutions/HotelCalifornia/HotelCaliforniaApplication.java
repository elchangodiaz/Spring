package com.coherent.solutions.HotelCalifornia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HotelCaliforniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelCaliforniaApplication.class, args);
	}

}
