package com.account.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyTester {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/context.xml");) {
			Company company = container.getBean(Company.class);
		company.development();
		
		}

	}

}
