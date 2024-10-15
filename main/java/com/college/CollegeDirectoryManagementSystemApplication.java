package com.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.college"})
@EntityScan(basePackages = "com.college.entity")
@EnableJpaRepositories(basePackages = "com.college.repository")

public class CollegeDirectoryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeDirectoryManagementSystemApplication.class, args);
	}
}
