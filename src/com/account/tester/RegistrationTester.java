package com.account.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.part.Resgistration;

public class RegistrationTester {

	public static void main(String[] args) {
		String xmlFile = "resources/Registration.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(xmlFile);
		Resgistration refOfReg= spring.getBean(Resgistration.class);
	}

}
