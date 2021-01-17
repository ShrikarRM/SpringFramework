package com.account.module.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.account.module.dao.RegisterDAO;
import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.RepositoryException;
import com.account.module.exceptions.ServiceException;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDAO dao;
	@Autowired
	private SendEmail sendEmail;
	
	public RegisterServiceImpl() {

		System.out.println("invoked service method");
	}

	@Override
	public String validateAndSave(RegisterDTO dto) throws ServiceException {
		boolean valid = false;
		String message = "NA";
		System.out.println("invoked validateAndSave method in serviceImpl");
		try {
			if (Objects.nonNull(dto)) {
				String firstName = dto.getFirstName();
				String lastName = dto.getLastName();
				String email = dto.getEmail();

				if (!StringUtils.isEmpty(firstName) || firstName.length() > 3) {
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
						String regExp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
								+ "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

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
					if (pwd.length() >= 4) {
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
					if (dao.fetchEmailCount(email) > 0) {
						message = "DUPLICATE";
						System.out.println("Email id is already exist");
					} else {
						
						boolean sentMail=sendEmail.sendMail(dto);
						if(sentMail){
						long pk = dao.save(dto);
						message = "SAVED";
						System.out.println("Data is valid data saved to DB");
						System.out.println("Data is saved to DB with id=" + pk);
						}else{
							System.out.println("Email not sent, Data not saved");
						}
					}
					
				} else {
					System.out.println("Data is invalid it can't be saved to DB");
				}
			}
		} catch (RepositoryException e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return message;
	}
	
	@Override
	public List<RegisterDTO> validateAndLogin(RegisterDTO dto) throws ServiceException {
		List<RegisterDTO> registerDTO = null;

		System.out.println("invoked validateAndLogin() in serviceImpl");
		try {
			if(Objects.nonNull(dto))
				registerDTO=dao.fetchDetailsforLogin(dto);

		} catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return registerDTO;
	}
}
