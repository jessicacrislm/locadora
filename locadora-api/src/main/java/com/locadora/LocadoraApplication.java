package com.locadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class LocadoraApplication {
	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}
}
