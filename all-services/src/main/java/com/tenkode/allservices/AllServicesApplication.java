package com.tenkode.allservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.tenkode.*" })
public class AllServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllServicesApplication.class, args);
	}

}
