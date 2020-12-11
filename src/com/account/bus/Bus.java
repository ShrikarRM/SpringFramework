package com.account.bus;

public class Bus {
	private String name;
	private double fare;
	private int noOfPassengers;
	private Passenger passenger;

	public Bus() {
		System.out.println("created" + this.getClass().getSimpleName());
	}

	public void move() {
		System.out.println("bus started form origin");
		this.passenger.travel();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
}
