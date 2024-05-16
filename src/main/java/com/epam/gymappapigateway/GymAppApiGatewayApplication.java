package com.epam.gymappapigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GymAppApiGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(GymAppApiGatewayApplication.class, args);
		Logger logger = LoggerFactory.getLogger(GymAppApiGatewayApplication.class);
		logger.info("\n\n -------------- api gateway started --------------------\n\n");
	}

}
