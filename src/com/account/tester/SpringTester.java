package com.account.tester;

import java.awt.Label;
import java.awt.List;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.FileHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.virus.Virus;

public class SpringTester {

	public static void main(String[] args) {

		System.out.println("starting spring engine");
		String configFileName="resources/Spring.xml";
		ApplicationContext spring=new ClassPathXmlApplicationContext(configFileName);
	
		/*Virus c=spring.getBean(Virus.class);
		c.spreadDiseases();
		*/
		String ref=spring.getBean(String.class);
		System.out.println("reference of string " +ref+" is used");
		
		ArrayList i = spring.getBean(ArrayList.class);
		System.out.println("reference of arraylist " + i + " is used");
		
		/*Method[] m = i.getClass().getMethods();
		System.out.println(m);
		for (Method method : m) {
			System.out.println(method.getName());
		}*/
		/*Array a=spring.getBean(Array.class);
		Method [] md=a.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Error er=spring.getBean(Error.class);
		Method [] md=er.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Exception ex=spring.getBean(Exception.class);
		Method [] md=ex.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*FileHandler fh=spring.getBean(FileHandler.class);
		Method [] md=fh.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Label l=spring.getBean(Label.class);
		Method [] md=l.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*List li=spring.getBean(List.class);
		Method [] md=li.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Modifier mf=spring.getBean(Modifier.class);
		Method [] md=mf.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		/*Object o=spring.getBean(Object.class);
		Method [] md=o.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}*/
		
		Stack s=spring.getBean(Stack.class);
		Method [] md=s.getClass().getMethods();
		for (Method mt : md) {
			System.out.println(mt.getName());
		}
		
	}

}
