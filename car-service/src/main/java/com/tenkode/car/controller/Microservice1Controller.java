package com.tenkode.car.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenkode.car.dto.CarDto;

@RestController
@RequestMapping("/ms1")
public class Microservice1Controller {

	@GetMapping("/car")
	public ResponseEntity<CarDto> getCar() {
		final CarDto carDto = new CarDto();
		carDto.setMake("Opel");
		carDto.setModel("Manta");
		return ResponseEntity.ok(carDto);
	}
}