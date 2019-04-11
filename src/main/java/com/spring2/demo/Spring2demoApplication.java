package com.spring2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring2demoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.main.lazy-initialization", "true");
		SpringApplication.run(Spring2demoApplication.class, args);
	}

}
