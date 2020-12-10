package com.account.di;

public class Tester {

	public static void main(String[] args) {
		String regNo="KAERER";
		String owner="RAM";
		
		Battery battery=new Battery();
		battery.setCapacity(100);
		battery.setPower(220);
		
		Fuel fuel=new Fuel();
		fuel.burn();
		fuel.setPrice(81.44);
		fuel.setType("petrol");
	
		Vehicle  scooter=new Vehicle(regNo, owner, battery);
		scooter.setFuel(fuel);
		scooter.start();
		
	}

}
