package com.account.init.resource;

import java.util.Date;

public class Rocket {

	private String country;
	private Date launchingDate;
	private double cost;

	public Rocket() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLaunchingDate() {
		return launchingDate;
	}

	public void setLaunchingDate(Date launchingDate) {
		this.launchingDate = launchingDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
