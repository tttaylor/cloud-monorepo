package com.tenkode.allservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.tenkode.*" })
public class AllServicesApplication implements CommandLineRunner {
	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(AllServicesApplication.class);
		application.run();
	}

	@Autowired
	private YamlConfig config;

	@Override
	public void run(String... args) throws Exception {
		config.getApplications().forEach(applicationClassName -> {
			new ServiceThread(applicationClassName).start();
		});
	}
}
