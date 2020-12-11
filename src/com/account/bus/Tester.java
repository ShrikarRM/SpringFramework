package com.account.bus;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/bus-config.xml");) {
			Bus vrl = container.getBean(Bus.class);
			vrl.move();
		}
	}

}
