package com.account.college;

public class Student {
	private String id;
	private String name;
	private int rollNum;

	public Student() {
		System.out.println("student obj created");
	}

	public void study() {
		System.out.println("studying");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

}
