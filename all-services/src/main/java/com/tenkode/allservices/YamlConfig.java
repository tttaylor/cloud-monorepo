package com.tenkode.allservices;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YamlConfig {
	private Set<String> applications;

	public Set<String> getApplications() {
		return applications;
	}

	public void setApplications(Set<String> applications) {
		this.applications = applications;
	}
}
