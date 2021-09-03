package com.project.delivery.project.delivery.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProjectDeliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectDeliveryApiApplication.class, args);
	}

}
