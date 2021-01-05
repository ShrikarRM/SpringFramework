package com.account.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "patient_details")
public class PatientDTO {
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Id
	@Column(name = "p_name")
	private String name;
	@Column(name = "p_age")
	private int age;
	@Column(name = "p_mobile")
	private long mobile;
	@Column(name = "p_email")
	private String email;
	@Column(name = "p_address")
	private String address;
	@Column(name = "p_result")
	private String result;
	@Column(name = "p_state")
	private String state;

	public PatientDTO() {
		System.out.println(this.getClass().getSimpleName()+" created");
	}
}
