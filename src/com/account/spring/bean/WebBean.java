package com.account.spring.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class WebBean {
	public WebBean() {

		System.out.println("webBean created");
	}

	@RequestMapping("/call.do")
	public String callMe() {
		System.out.println("invoked call me");
		return "index.html";   
		//return null; then multiple times sysout stmts
	}
}
