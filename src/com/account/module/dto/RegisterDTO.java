package com.account.module.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import com.account.module.service.RegisterServiceImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@Table(name = "register_module")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterDTO other = (RegisterDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
	
}
