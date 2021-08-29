package com.mobiquity.atmlocator;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@SpringBootApplication
public class AtmlocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmlocatorApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
	
		return new RestTemplate();
	}

}
