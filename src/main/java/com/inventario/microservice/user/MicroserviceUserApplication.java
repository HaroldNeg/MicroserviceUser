package com.inventario.microservice.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.inventario.microservice.user.entity")
@EnableJpaRepositories("com.inventario.microservice.user.repository")
public class MicroserviceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserApplication.class, args);
	}

}
