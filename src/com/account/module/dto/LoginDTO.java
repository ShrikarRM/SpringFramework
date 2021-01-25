package com.account.module.dto;


import org.apache.log4j.Logger;

import com.account.module.service.RegisterServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

	private String email;
	private String password;
	static Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	public LoginDTO() {
		logger.info(this.getClass().getSimpleName() + " created");
	}
}
