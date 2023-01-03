package com.la.springboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class BootWebAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootWebAdminApplication.class, args);
	}

}
