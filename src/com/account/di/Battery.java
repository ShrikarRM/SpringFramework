package com.account.di;

public class Battery {
	private double capacity;
	private int power;

	public boolean charging() {
		boolean charging = false;
		if (this.power > 0) {
			System.out.println("Battery is charging");
			charging = true;
		} else {
			System.out.println("Battery is not charging");
		}
		return charging;
	}

	public boolean discharge() {
		boolean started = false;
		if (this.capacity > 0) {
			System.out.println("battery is discharging");
			started = true;
		} else {
			System.out.println("battery is not discharging");
		}
		return started;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
}