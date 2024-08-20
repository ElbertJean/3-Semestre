package com.example.lojaPesca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.lojaPesca", "com.example.lojaPescaController"})
public class LojaPescaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaPescaApplication.class, args);
	}
}
