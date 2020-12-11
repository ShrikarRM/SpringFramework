package com.account.company;

public class Employee {
	private String id;
	private String name;
	private long contactnum;

public Employee() {
System.out.println("created empl");
}
	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void achievingTargets() {
		System.out.println("Accomplishing specified target");
	}
	public void development() {
		System.out.println("Improving growth rate");
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

	public long getContactnum() {
		return contactnum;
	}

	public void setContactnum(long contactnum) {
		this.contactnum = contactnum;
	}

}
