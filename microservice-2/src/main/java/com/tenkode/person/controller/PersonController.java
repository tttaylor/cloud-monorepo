package com.tenkode.person.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenkode.person.dto.PersonDto;

@RestController
@RequestMapping("/ms2")
public class PersonController {

	@GetMapping("/person")
	public ResponseEntity<PersonDto> getCar() {
		final PersonDto carDto = new PersonDto();
		carDto.setFirst("Tim");
		carDto.setLast("Taylor");
		return ResponseEntity.ok(carDto);
	}
}