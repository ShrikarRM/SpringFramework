package com.account.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.part.Laptop;

public class LaptopTester {

	public static void main(String[] args) {
		String xmlFile="resources/Laptop.xml";
ApplicationContext spring = new ClassPathXmlApplicationContext(xmlFile);
Laptop dell=spring.getBean("laptop",Laptop.class);
Laptop hp=spring.getBean("another",Laptop.class);


	}

}
