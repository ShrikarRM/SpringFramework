package com.account.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobileTester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources/mobileConfig.xml");
		Mobile refMobile = applicationContext.getBean("price",Mobile.class);
		System.out.println(refMobile.isLteSupported());
	}

}
