package com.account.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.account.module.dto.RegisterDTO;
import com.account.module.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegistrationController {
	@Autowired
	private RegisterService service;

	public RegistrationController() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String onSave(RegisterDTO dto, Model model) {
		System.out.println("invoked onSave " + dto);
		try {
			boolean saved = service.validateAndSave(dto);
			if (saved) {
				model.addAttribute("dto", dto);
				System.out.println("saving the details");
				return "Register";
			} 
			
		System.out.println("Not saved, Please enter valid details");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "Register";	
	}
}
