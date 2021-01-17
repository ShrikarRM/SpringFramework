package com.account.module.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

	private String email;
	private String password;

	public LoginDTO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
}
