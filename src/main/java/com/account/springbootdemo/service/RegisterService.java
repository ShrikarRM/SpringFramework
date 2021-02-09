package com.account.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.springbootdemo.dto.RegisterDTO;
import com.account.springbootdemo.repo.Repository;

@Service
public class RegisterService {
	@Autowired
	private Repository repository;

	public RegisterDTO saveDetails(RegisterDTO dto) {
		return repository.save(dto);
	}

	public RegisterDTO getDetailsByName(String firstName) {
		return repository.findByfirstName(firstName);
	}

	public RegisterDTO getDetailsById(long id) {
		return repository.findById(id).orElse(null);
	}

	public String deleteByID(long id) {
		repository.deleteById(id);
		return "details deleted for id="+id;
	}
	
	public RegisterDTO updateDetailsBy(RegisterDTO dto){
		RegisterDTO oldDetails=repository.findById(dto.getId()).orElse(null);
		oldDetails.setFirstName(dto.getFirstName());
		oldDetails.setLastName(dto.getLastName());
		oldDetails.setPassword(dto.getPassword());
		oldDetails.setEmail(dto.getEmail());
		return repository.save(oldDetails);
		
	}
}
