package com.example.KafkaConcurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class KafkaConcurrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConcurrentApplication.class, args);
	}

}
