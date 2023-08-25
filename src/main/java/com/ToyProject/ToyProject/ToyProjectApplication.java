package com.ToyProject.ToyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ToyProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToyProjectApplication.class, args);
	}

}
