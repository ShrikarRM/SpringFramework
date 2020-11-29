package com.account.part;

public class Metro {
	private String name;

	public Metro() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public Metro(String name) {
		super();
		this.name = name;
		System.out.println("one arg "+name);
	}
	
	

}
