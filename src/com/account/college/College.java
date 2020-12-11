package com.account.college;

public class College {
	private String name;
	private int noOfFaculty;
	private String address;
	private Student stu;

	public College() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public College(String name, int noOfFaculty) {
		super();
		this.name = name;
		this.noOfFaculty = noOfFaculty;
		this.stu.setName("sagar");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public College(Student stu) {
		super();
		this.stu = stu;
		this.stu.study();
	}

}
