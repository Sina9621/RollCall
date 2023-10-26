package com.rollcall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.rollcall.repository"})
@EntityScan(basePackages = {"com.rollcall.model"})
@SpringBootApplication
public class RollCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollCallApplication.class, args);
	}

}
