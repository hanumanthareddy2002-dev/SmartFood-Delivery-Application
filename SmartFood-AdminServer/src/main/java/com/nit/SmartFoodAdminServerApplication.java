package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SmartFoodAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartFoodAdminServerApplication.class, args);
	}

}
