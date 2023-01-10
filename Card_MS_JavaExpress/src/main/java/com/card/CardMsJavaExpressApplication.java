package com.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CardMsJavaExpressApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardMsJavaExpressApplication.class, args);
	}

}
