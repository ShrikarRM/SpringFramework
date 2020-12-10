package com.account.di;

public class Fuel {
	private String type;
	private double price;
	private double quantity;

	public String burn() {
		String burn="no";
		if(this.quantity>0){
		System.out.println("fuel is burning");
		burn="yes";
		}else{
			System.out.println("fuel is not burning");
		}
		return burn;
	
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
