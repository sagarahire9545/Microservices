package com.sysmbiosis.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({ "com.sysmbiosis.hotel", "com.controller", "com.dao", "com.model", "com.service","com.exception" })
@EntityScan("com.model")
@EnableJpaRepositories(basePackages = "com.dao")

@SpringBootApplication
@EnableEurekaClient
public class HotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
	}

}
