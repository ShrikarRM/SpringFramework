package com.account.springbootdemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;


@Entity

/*@NotNull
@NotEmpty*/
@Table(name = "springboot_table")
public class RegisterDTO {
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Id
	@Column(name = "reg_id")
	private long id;
	@Column(name = "reg_firstName")
	private String firstName;
	@Column(name = "reg_lastName")
	private String lastName;
	@Column(name = "reg_email")
	private String email;
	@Column(name = "reg_password")
	private String password;
	
	@Transient
	@Column(name = "reg_confirmPassword")
	private String confirmPassword;
	
	static Logger logger = Logger.getLogger(RegisterDTO.class);

	public RegisterDTO() {
		logger.info(this.getClass().getSimpleName()+" created");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

}
