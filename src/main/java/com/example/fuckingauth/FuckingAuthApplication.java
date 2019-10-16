package com.example.fuckingauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class FuckingAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuckingAuthApplication.class, args);
	}

}
