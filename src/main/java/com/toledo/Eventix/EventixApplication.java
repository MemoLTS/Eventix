package com.toledo.Eventix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.toledo")
public class EventixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventixApplication.class, args);
	}

}
