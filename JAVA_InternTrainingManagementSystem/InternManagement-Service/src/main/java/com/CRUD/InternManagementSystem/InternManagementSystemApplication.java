package com.CRUD.InternManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InternManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternManagementSystemApplication.class, args);
	}

}
