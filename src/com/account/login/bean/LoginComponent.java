package com.account.login.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/")
public class LoginComponent {
	public LoginComponent() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
	@RequestMapping(value="/login.dos",method=RequestMethod.POST)

	public String onLogin(String username, String password,HttpServletRequest request){
	String name="don";
		String code="123321";

		if(name.equals(username) && code.equals(password)){
			System.out.println("username & password is matching");
			request.setAttribute("message","Welcome, "+username);
			return "home";
		}else
		System.out.println("Username & passwords are mismatching");
		request.setAttribute("errorMessage","username or password is mismatching");
		return "index";
	}
}
