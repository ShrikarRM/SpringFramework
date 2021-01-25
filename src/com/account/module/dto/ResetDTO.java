package com.account.module.dto;

import org.apache.log4j.Logger;

import com.account.module.service.RegisterServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResetDTO {

	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
	static Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	public ResetDTO() {
		logger.info(this.getClass().getSimpleName() + " created");
	}
}
