package com.tenkode.car.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenkode.car.dto.CarDto;

@RefreshScope
@RestController
@RequestMapping("/car")
public class CarController {

	@Value("${make: none}")
	private String make;

	@Value("${model: none}")
	private String model;

	@GetMapping("/tims-car")
	public ResponseEntity<CarDto> getCar() {
		final CarDto carDto = new CarDto();
		carDto.setMake(make);
		carDto.setModel(model);
		return ResponseEntity.ok(carDto);
	}
}
