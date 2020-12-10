package com.account.di;

public class Vehicle {

	private String regNo;
	private String owner;

	private Battery battery;
	private Fuel fuel;

	public Vehicle(String regNo, String owner, Battery battery) {
		super();
		this.regNo = regNo;
		this.owner = owner;
		this.battery = battery;
	}

	public boolean start(){
		System.out.println("invoked starting the vehicle");
		boolean started =false;
		boolean batteryWorking=battery.discharge();
		this.battery.discharge();
		if(batteryWorking){
			System.out.println("battery is working, testing now fuel");
			String burn=fuel.burn();
			if("yes".equals(burn)){
			System.out.println("fuel is there, car is started");
			started=true;
			}else
			{
				System.out.println("fuel is not there, car is not started");	
			}
		}
			return started;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
}
