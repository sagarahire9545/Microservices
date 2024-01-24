package com.sysmbiosis;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

//component scan
@ComponentScan({ "com.sysmbiosis", "com.controller", "com.dao", "com.model", "com.service", "com.exception",
		"com.payload" ,"com.externel.services" })
@EntityScan("com.model")
@EnableJpaRepositories(basePackages = "com.dao")

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.externel.services")
public class UserServiceApplication {

	@Bean
	@LoadBalanced  //used becoz the removing the host & port 
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		
		
	}

}
