package com.account.treeset;

import java.util.TreeSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTester {

	public static void main(String[] args) {

		ApplicationContext container = new ClassPathXmlApplicationContext("resources/treesetConfig.xml");
		TreeSetExample set = container.getBean("months", TreeSetExample.class);
		TreeSet<String> months=set.getMonths();
		System.out.println(months);
	}

}
