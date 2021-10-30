package com.ironhack.adopterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdopterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopterServiceApplication.class, args);
	}

}
