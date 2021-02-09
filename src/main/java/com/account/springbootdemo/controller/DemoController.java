package com.account.springbootdemo.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.springbootdemo.dto.RegisterDTO;
import com.account.springbootdemo.service.RegisterService;
//turn off server after every run to avoid message 'Server already in use'
@RestController


public class DemoController {
	@Autowired
	private RegisterService service;
	
	static Logger logger = Logger.getLogger(RegisterDTO.class);

	@PostMapping("/save")
	public String addDetails(@ModelAttribute RegisterDTO dto) {   //this is for FormData ,
						//use @RequestBody for JSON data when selecting Raw in POSTMAN
		 service.saveDetails(dto);
		 logger.info("eamil....."+dto.getEmail());
		 return "added";
	}

	@GetMapping("/detailsByID/{id}")
	public RegisterDTO findById(@PathVariable long id){
		return service.getDetailsById(id);
	}
	
	@GetMapping("/details/{firstName}")
	public RegisterDTO findByName(@PathVariable String firstName){
		return service.getDetailsByName(firstName);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteDetailsById(@PathVariable long id){
		return service.deleteByID(id);
	}
	
	@PutMapping("/update")
	//public RegisterDTO updateDetails(@ModelAttribute RegisterDTO dto){
	public RegisterDTO updateDetails(@RequestBody RegisterDTO dto){

		return service.updateDetailsBy(dto);
	}
	
	@RequestMapping("home")
	public String hello() {
		System.out.println("Hello guys");
		return "i m fine";
	}
}
