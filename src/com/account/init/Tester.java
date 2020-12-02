package com.account.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	public static void main(String[] args) {

		//String configFileName = "resources/init.xml";

		ApplicationContext container = new ClassPathXmlApplicationContext("resources/init.xml");
		Hotel ref = container.getBean("hotel",Hotel.class);
		System.out.println(ref.getName());
		
		Hotel ref1 = container.getBean("location",Hotel.class);
		System.out.println(ref1.getLocation());
		
		Hotel ref2 = container.getBean("type",Hotel.class);
		System.out.println(ref2.isType());
	}
}
