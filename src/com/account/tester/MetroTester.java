package com.account.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.part.Metro;

public class MetroTester {

	public static void main(String[] args) {
		String configFile = "resources/Metro.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFile);
		Metro namma = spring.getBean("namma",Metro.class);
		Metro greenLine=spring.getBean("purpleMetro",Metro.class);
		Metro purpleLine=spring.getBean("greenLine",Metro.class);

	}

}
