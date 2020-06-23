package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class SsoKerberosLinhApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoKerberosLinhApplication.class, args);
		System.out.println("Dm linh");
	}

}
