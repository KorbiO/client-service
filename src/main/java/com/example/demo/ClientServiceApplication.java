package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient

public class ClientServiceApplication {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));

		SpringApplication.run(ClientServiceApplication.class, args);
	}

}
