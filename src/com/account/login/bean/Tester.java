package com.account.login.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tester {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext  contextObj = new AnnotationConfigApplicationContext ();
        contextObj.register(SpringConfig.class);
        contextObj.refresh();
 ProductComponent compo=contextObj.getBean(ProductComponent.class);
	}

}
