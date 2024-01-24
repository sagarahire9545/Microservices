package com.sysmbiosis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan({"com.sysmbiosis","com.controller","com.dao","com.model","com.service"})
@EntityScan("com.model")
@EnableMongoRepositories(basePackages="com.dao")



@SpringBootApplication
@EnableEurekaClient
public class RatingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServicesApplication.class, args);
	}

}
