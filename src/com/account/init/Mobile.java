package com.account.init;

public class Mobile {
	private String brand;
	private double price;
	private boolean lteSupported;


	public Mobile(String brand) {
		this.brand = brand;
		System.out.println(brand);
	}

	public Mobile(double price) {
		this.price = price;
		System.out.println(price);
	}

	public boolean isLteSupported() {
		return lteSupported;
	}

	public void setLteSupported(boolean lteSupported) {
		this.lteSupported = lteSupported;
	}

}
