package com.account.patient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@RequestMapping("/")
public class PatientDetailsComponent {
private List<String> states;
	public PatientDetailsComponent() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
	@PostConstruct
	public void init(){
		this.states=new ArrayList<String>();
		this.states.add("KA");
		this.states.add("MH");
	
	}
	@RequestMapping("/landing.do")
	public String landingPage(Model model){
		System.out.println("invoked landingPage()");
		model.addAttribute("states",this.states);
		return "index";
	}
	@PreDestroy
	public void destroy(){
		System.out.println("invoked pre-destroy");
		this.states=null;
	}
	
}
