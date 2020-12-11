package com.account.college;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CollegeTester {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/college.xml");) {
			College dsi = container.getBean(College.class);
			
		}
	}

}
