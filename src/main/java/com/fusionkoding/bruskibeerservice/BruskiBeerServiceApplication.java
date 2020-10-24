package com.fusionkoding.bruskibeerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories
public class BruskiBeerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BruskiBeerServiceApplication.class, args);
	}

}
