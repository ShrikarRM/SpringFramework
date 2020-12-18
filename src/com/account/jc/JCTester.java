package com.account.jc;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JCTester {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/spring.xml");) {
			//System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			container.getBean(Speaker.class);
		}
	}
}
