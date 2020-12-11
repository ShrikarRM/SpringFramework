package com.account.bus;

public class Passenger {
	private String name;
	private int seatNo;
public Passenger() {
System.out.println("pass created");
}
	public void travel() {
		System.out.println("passenger is travelling in bus");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(name);
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
}
