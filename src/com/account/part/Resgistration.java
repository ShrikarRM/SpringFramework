package com.account.part;

public class Resgistration {
	private int id;
	private String name;
	private long contactNum;
	private int age;

	public Resgistration() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public Resgistration(int id, String name, long contactNum, int age) {
		super();
		this.id = id;
		this.name = name;
		this.contactNum = contactNum;
		this.age = age;
		System.out.println("four arg constructor "+id+" "+name+" "+contactNum+" "+age);
	}
	
}
