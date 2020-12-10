package com.account.spring_relations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTester {
	public static void main(String[] args) {
		
		ApplicationContext container = new ClassPathXmlApplicationContext("context.xml");

		Person person = container.getBean(Person.class);
		person.call();
		
	}
}
