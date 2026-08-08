package com.artikunazo.shorterurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ShorterUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShorterUrlApplication.class, args);
	}

}
