package com.tenkode.insurance.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenkode.insurance.dto.PolicyDto;

@RefreshScope
@RestController
@RequestMapping("/insurance")
public class InsuranceController {

	@Value("${name:none}")
	private String name;

	@Value("${price:0.00}")
	private String price;

	@GetMapping("/tims-policy")
	public ResponseEntity<PolicyDto> getCar() {
		final PolicyDto carDto = new PolicyDto();
		carDto.setName(name);
		carDto.setPrice(new BigDecimal(price).setScale(2, RoundingMode.HALF_UP));
		return ResponseEntity.ok(carDto);
	}
}
