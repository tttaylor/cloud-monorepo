package com.tenkode.insurance.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenkode.insurance.dto.PolicyDto;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

	@GetMapping("/tims-policy")
	public ResponseEntity<PolicyDto> getCar() {
		final PolicyDto carDto = new PolicyDto();
		carDto.setName("Auto");
		carDto.setPrice(new BigDecimal(10.11).setScale(2, RoundingMode.HALF_UP));
		return ResponseEntity.ok(carDto);
	}
}
