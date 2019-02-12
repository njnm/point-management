package com.spring.pointmanagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PointManagementApplication {
	private static final Logger logger = LogManager.getLogger(PointManagementApplication.class);

	public static void main(String[] args) {
		logger.info("Application Started");
		SpringApplication.run(PointManagementApplication.class, args);
	}

}

