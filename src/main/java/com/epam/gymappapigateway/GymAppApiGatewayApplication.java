package com.epam.gymappapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GymAppApiGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(GymAppApiGatewayApplication.class, args);
		System.out.println("\n\n -------------- api gateway started --------------------\n\n");
	}

}
