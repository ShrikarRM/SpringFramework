package com.account.part;

public class Laptop {
	private String brand;
	private int ram;

	public Laptop() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public Laptop(String brand, int ram) {
		super();
		this.brand = brand;
		this.ram = ram;
		System.out.println(this.brand + " " + this.ram);
	}
	public Laptop( int ram,String brand) {
		super();
		this.brand = brand;
		this.ram = ram;
		System.out.println(this.brand + " " + this.ram);
	}
}
