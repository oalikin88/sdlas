package com.example.sdlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class SdlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdlasApplication.class, args);
	}

}
