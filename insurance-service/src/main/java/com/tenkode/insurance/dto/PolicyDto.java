package com.tenkode.insurance.dto;

import java.math.BigDecimal;

public class PolicyDto {
	private String name;
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
