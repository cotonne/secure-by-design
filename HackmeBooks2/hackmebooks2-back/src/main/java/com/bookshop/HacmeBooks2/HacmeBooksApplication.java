package com.bookshop.HacmeBooks2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class HacmeBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(HacmeBooksApplication.class, args);
	}

}
