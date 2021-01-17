package com.account.module.service;

import org.springframework.mail.MailException;

import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.ServiceException;

public interface SendEmail {
	public boolean sendMail(RegisterDTO dto) throws MailException, ServiceException;

}
