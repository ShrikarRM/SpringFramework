package com.account.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientDTO {
	private String name;
	private int age;
	private long mobile;
	private String email;
	private String address;
	private boolean result;
	private String state;

	public PatientDTO() {
		System.out.println(this.getClass().getSimpleName());
	}
}
