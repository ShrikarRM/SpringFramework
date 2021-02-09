package com.account.module.dto;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateDTO {
	private String firstName;
	private String lastName;
	private String email;
	static Logger logger = Logger.getLogger(RegisterDTO.class);

	public UpdateDTO() {
		logger.info(this.getClass().getSimpleName() + " created");
	}
}
