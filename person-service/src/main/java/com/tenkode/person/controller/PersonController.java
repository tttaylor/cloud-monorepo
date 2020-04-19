package com.tenkode.person.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenkode.person.dto.PersonDto;

@RefreshScope
@RestController
@RequestMapping("/person")
public class PersonController {

	@Value("${first:none}")
	private String first;

	@Value("${last:none}")
	private String last;

	@GetMapping("/tim")
	public ResponseEntity<PersonDto> getCar() {
		final PersonDto carDto = new PersonDto();
		carDto.setFirst(first);
		carDto.setLast(last);
		return ResponseEntity.ok(carDto);
	}
}
