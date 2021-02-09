package com.account.springbootdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.springbootdemo.dto.RegisterDTO;

public interface Repository extends JpaRepository<RegisterDTO, Long>{

	RegisterDTO findByfirstName(String firstName); 
	//use parameter name of DTO in custom methodname. Here ...findby"firstName"()

}
