package com.account.module.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.account.module.dao.RegisterDAO;
import com.account.module.dto.RegisterDTO;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDAO dao;

	public RegisterServiceImpl() {

		System.out.println("invoked service method");
	}

	@Override
	public boolean validateAndSave(RegisterDTO dto) {
		boolean valid = false;
		System.out.println("invoked validateAndSave method in serviceImpl");
try{
		if (Objects.nonNull(dto)) {
			String firstName = dto.getFirstName();
			String lastName = dto.getLastName();
			String email = dto.getEmail();

				if (!StringUtils.isEmpty(firstName) && firstName.length() > 3) {
					System.out.println("FirstName is valid");
					valid = true;
				} else {
					System.out.println("FirstName is invalid");
					valid = false;
				}
				if (valid) {
					if (!StringUtils.isEmpty(lastName)) {
						System.out.println("LastName is valid");
						valid = true;
					} else {
						System.out.println("LastName is invalid");
						valid = false;
					}
				}
				if (valid) {
					if (!StringUtils.isEmpty(email)) {
						String regExp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
								+ "A-Z]{2,7}$";

						boolean result = email.matches(regExp);
						
						System.out.println("Email is valid");
						valid = true;
					} else {
						System.out.println("Email is invalid");
						valid = false;
					}
				}
				if (valid) {
					String pwd = dto.getPassword();
					if (pwd.length() > 4) {
						System.out.println("Password is valid");
						valid = true;

					} else {
						System.out.println("Password is invalid");
						valid = false;
					}
				}
				if (valid) {
					String password = dto.getPassword();
					String cnfPassword = dto.getConfirmPassword();
					if (password.equals(cnfPassword)) {
						System.out.println("ConfirmPassword is matching with password");
						valid = true;

					} else {
						System.out.println("ConfirmPassword is not matching with password");
						valid = false;
					}
				}

				if (valid) {
					long id = dao.save(dto);
					System.out.println(id);
					System.out.println("Data is valid data saved to DB");
				} else {
					System.out.println("Data is invalid it can't be saved to DB");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

}
