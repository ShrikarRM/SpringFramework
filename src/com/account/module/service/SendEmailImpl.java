package com.account.module.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.ServiceException;
@Service
public class SendEmailImpl implements SendEmail{
	@Autowired
	private JavaMailSender mailSender;
	static Logger logger = Logger.getLogger(RegisterServiceImpl.class);

public boolean sendMail(RegisterDTO dto) throws MailException, ServiceException {

		logger.info("invoked sendMail");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(dto.getEmail());
		mailMessage.setSubject("X-workz common module registration ");
		mailMessage.setText("Hi "+dto.getFirstName()+"\n"+"\n"+" registration successful."+ "\n"+"Please login with your userID & password "+ 
		"\n"+ "\n"+"Thank you, "+ "\n"+"X-workz");
		
		try {
			mailSender.send(mailMessage);
			logger.info("Mail sent");
			return true;
		} catch (MailException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return false;
	}


}
