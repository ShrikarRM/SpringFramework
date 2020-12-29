package com.account.login.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
	private String name;
	private String brand;
	private int quantity;
	private double price;

	public ProductDTO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
}
