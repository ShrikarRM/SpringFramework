package com.account.spring_relations;

public class Person {
	private String name;
	private Mobile mobile=new Mobile(); // person can have methods or members of mobile

	public Person() {
		System.out.println("ceated " + this.getClass().getSimpleName());
	}

	public void call() {
		System.out.println("invoked call method in person");
		System.out.println(this.name.toLowerCase());
		this.mobile.call();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
}
