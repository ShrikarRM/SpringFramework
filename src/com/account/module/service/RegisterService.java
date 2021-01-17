package com.account.module.service;

import java.util.List;

import org.springframework.mail.MailException;

import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.ServiceException;

public interface RegisterService {
	public String validateAndSave(RegisterDTO dto) throws ServiceException;
	//public boolean sendMail(RegisterDTO dto) throws MailException,ServiceException;
	public List<RegisterDTO> validateAndLogin(RegisterDTO dto ) throws ServiceException;

}
