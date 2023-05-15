package com.example.sportyShoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.sportyShoes.repository")
@EntityScan(basePackages = "com.example.sportyShoes.model")
public class SportyShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	}

}
