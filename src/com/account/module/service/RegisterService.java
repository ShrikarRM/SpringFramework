package com.account.module.service;

import java.util.List;

import org.springframework.mail.MailException;

import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.dto.ResetDTO;
import com.account.module.exceptions.ServiceException;

public interface RegisterService {
	public String validateAndSave(RegisterDTO dto) throws ServiceException;
	//public boolean sendMail(RegisterDTO dto) throws MailException,ServiceException;
	public String validateAndLogin(RegisterDTO dto,LoginDTO loginDTO ) throws ServiceException;
	public List<RegisterDTO> loginDetails(RegisterDTO dto) throws ServiceException;
	public String validateAndResetPassword(RegisterDTO dto) throws ServiceException;
	public String validateAndUpdateNewPassword(ResetDTO resetDTO) throws ServiceException;
	//public RegisterDTO getUserByEmail(String email);
}
