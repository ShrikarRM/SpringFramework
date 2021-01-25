package com.account.module.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.ServiceException;
@Service
public class SendEmailForOTPImpl implements SendEmailForOTP{
@Autowired
private JavaMailSender mailSender;
static Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	@Override
	public boolean onSendOTP(RegisterDTO dto,String tempPasswords) throws MailException, ServiceException {
		logger.info("invoked onSendOTP");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(dto.getEmail());
		mailMessage.setSubject("X-workz common module Password resetting ");
		mailMessage.setText("Hi "+dto.getFirstName()+"\n"+"\n"+" Please find OTP for password resetting. " +"\n"+tempPasswords
		+ "\n"+"Enter the OTP in Reset window & set your new password "+ 
		"\n"+ "\n"+"Thank you, "+ "\n"+"X-workz");
		
		try {
			mailSender.send(mailMessage);
			logger.debug("OTP Mail sent");
			return true;
		} catch (MailException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return false;
		}
	
}
