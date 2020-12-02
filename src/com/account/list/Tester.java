package com.account.list;

import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

	public static void main(String[] args) {
		String configFile = "resources/config.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(configFile);
		
		ListExample alistConfig = spring.getBean("listexample",ListExample.class);
        ArrayList<String> names = alistConfig.getNames();
        ListIterator<String> lIterator = names.listIterator();
       
        while(lIterator.hasNext()){
              System.out.println(lIterator.next());
        }
	}

}
