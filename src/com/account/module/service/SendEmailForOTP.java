package com.account.module.service;

import org.springframework.mail.MailException;

import com.account.module.dto.RegisterDTO;
import com.account.module.dto.ResetDTO;
import com.account.module.exceptions.ServiceException;

public interface SendEmailForOTP {

	public boolean onSendOTP(RegisterDTO dto, String tempPasswords) throws MailException, ServiceException;

}
