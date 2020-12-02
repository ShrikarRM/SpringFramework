package com.account.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitOfWraperClassTester {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("resources/InitWraper.xml");

		Byte b = container.getBean(Byte.class);
		System.out.println(b);

		Short s = container.getBean(Short.class);
		System.out.println(s);

		Character c = container.getBean(Character.class);
		System.out.println(c);

		Integer i = container.getBean(Integer.class);
		System.out.println(i);

		Float f = container.getBean(Float.class);
		System.out.println(f);

		Double d = container.getBean(Double.class);
		System.out.println(d);

		Long l = container.getBean(Long.class);
		System.out.println(l);

		Boolean bl = container.getBean(Boolean.class);
		System.out.println(bl);

		// task of init String and printing Xworkz
		String str = container.getBean(String.class);
		System.out.println(str);
	}

}
