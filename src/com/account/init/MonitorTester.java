package com.account.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MonitorTester {

	public static void main(String[] args) {

		ApplicationContext container = new ClassPathXmlApplicationContext("resources/monitor.xml");
		Monitor pc = container.getBean("monitor", Monitor.class);
		System.out.println(pc.getModelNo());
		System.out.println(pc.getMfgDate());

		// Monitor desktop = container.getBean("dates", Monitor.class);

		// System.out.println(desktop.getMfgDate());

	}

}
