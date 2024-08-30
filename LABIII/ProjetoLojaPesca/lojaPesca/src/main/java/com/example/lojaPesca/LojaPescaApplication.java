package com.example.lojaPesca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.lojaPesca", "com.example.lojaPescaController"})
public class LojaPescaApplication {


	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("SPRING_MAIL_HOST", dotenv.get("SPRING_MAIL_HOST"));
        System.setProperty("SPRING_MAIL_PORT", dotenv.get("SPRING_MAIL_PORT"));
        System.setProperty("SPRING_MAIL_USERNAME", dotenv.get("SPRING_MAIL_USERNAME"));
        System.setProperty("SPRING_MAIL_PASSWORD", dotenv.get("SPRING_MAIL_PASSWORD"));
        SpringApplication.run(LojaPescaApplication.class, args);
    }
}
