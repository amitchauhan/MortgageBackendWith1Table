package com.amit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Capstone2Application {

	public static void main(String[] args) {
		SpringApplication.run(Capstone2Application.class, args);
		System.out.println("Mortgage Backend Application started");
	}

}
