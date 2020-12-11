package com.account.company;

public class Company {
	private String name;
	private int noOfEmployees;
	private String address;
	private Employee emp;

	public void paySalary() {
		System.out.println("crediting the salary");
	}

	
	public void development() {
		System.out.println("Improving growth rate");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
