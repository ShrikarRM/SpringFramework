package com.account.part;

public class Season {
	private String weather;
	private float temperature;

	public Season() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public Season(String weather, float temperature) {
		super();
		this.weather = weather;
		this.temperature = temperature;
		System.out.println("created a two param constructor");
	}

	public Season(String weather) {
		System.out.println("created with string as a parameter");
	}

	public Season(float temperature) {
		System.out.println("created with float as a param");
	}
	
	public void display(){
		System.out.println(weather);
		System.out.println(temperature);
	}

}
