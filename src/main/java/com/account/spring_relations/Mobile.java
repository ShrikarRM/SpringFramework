package com.account.spring_relations;

public class Mobile {
	private String brand;
	private long imeiNum;

	public Mobile() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
	

	public void call() {
		System.out.println("invoked call method");
		System.out.println("IMEI="+this.imeiNum);
		System.out.println("brand="+this.brand);

	}
	
	public void sendSMS(){
		
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getImeiNum() {
		return imeiNum;
	}

	public void setImeiNum(long imeiNum) {
		this.imeiNum = imeiNum;
	}

}
