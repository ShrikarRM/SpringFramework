package com.account.spring_relations;

public class Tester {

	public static void main(String[] args) {
		Person person = new Person();
		String name = "SUN";
		person.setName(name);
		person.call();
		
		Mobile mobile=new Mobile();
		mobile.setBrand("samsung");
		mobile.setImeiNum(04040502);
		
		
		person.setMobile(mobile);
	}

}
