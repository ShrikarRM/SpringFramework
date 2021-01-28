package com.account.module.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.account.module.constants.AppConstant;
import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.dto.ResetDTO;
import com.account.module.exceptions.ControllerException;
import com.account.module.exceptions.ServiceException;
import com.account.module.service.RegisterService;

@Controller
@RequestMapping("/")
//@SessionAttributes("name")
public class RegistrationController {
	@Autowired
	private RegisterService service;
	static Logger logger = Logger.getLogger(RegistrationController.class);

	public RegistrationController() {
		logger.info(this.getClass().getSimpleName() + " created");
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String onSave(RegisterDTO dto, Model model) throws ControllerException {
		logger.debug("invoked onSave " + dto);
		try {
			String saved = service.validateAndSave(dto);
			if (saved.equals("DUPLICATE")) {

				// model.addAttribute("dto", dto);
				// model.addAttribute("message", saved);
				model.addAttribute("save_err", "Email alreay exists in database");
				logger.debug("not saving the details");
				return AppConstant.LANDING_PAGE;
			}
			if (saved.equals("SAVED")) {
				model.addAttribute("save", "Saved successfully & Registration mail sent");
				logger.debug("saving the details");

				/*
				 * boolean sent=service.sendMail(dto); if (sent) {
				 * model.addAttribute("success", "mail sent successfully");
				 * logger.info("invoked onSendMail"); } else {
				 * model.addAttribute("success", "mail not sent");
				 * logger.info("invoked onSendMail"); }
				 */
				return AppConstant.LANDING_PAGE;
			} else {
				model.addAttribute("save_err", "Data not Saved ");
				logger.debug("Data is not valid , not saved to DB");
				return AppConstant.LANDING_PAGE;
			}

		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String onLogin(RegisterDTO rdto, LoginDTO loginDTO, Model model) throws ControllerException {
		logger.info("invoked onLogin " + rdto + loginDTO);

		try {
			List<RegisterDTO> list=service.loginDetails(rdto);
			String dto = service.validateAndLogin(rdto, loginDTO);
			for (RegisterDTO registerDTO : list) {
				logger.debug(dto);
				if(dto.equals("SUCCESS")){
					model.addAttribute("login", "Login success");
					logger.debug("Passwords matching, Login suceesful");
					model.addAttribute("name",registerDTO.getFirstName());
					return "Home";
				}
			}
			if(dto.equals("FAIL")){
				model.addAttribute("login", "Login failed,Please check EmailID & Password ");
				logger.debug("Email/Password are incorrect, Login failed");
				return "Login";
			}
			
		
			if(dto.equals("not Registered")) {
				model.addAttribute("login", "Login failed,Please register with us");
				logger.debug("Please register with us");
				return "Login";
			}
			if(dto.equals("Maximum wrong attempts")){
				model.addAttribute("login", "you reached maximum wrong attempts ");
				logger.debug("user reached maximum wrong attempts");
				return "Login";
			}
			if(dto.equals("locked")){
				model.addAttribute("login", "your account Locked");
				logger.debug("user account has been Locked");
				return "Login";
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";
	}

	@RequestMapping(value = "/welcome.do", method = RequestMethod.POST)
	public String onWelcome(RegisterDTO rdto, LoginDTO loginDTO, Model model) throws ControllerException {
		try {
			model.addAttribute("welcome", " "+ rdto.getFirstName());

		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";
	}
	
	@RequestMapping(value = "/reset.do", method = RequestMethod.POST)
	public String onSendOTP(RegisterDTO rdto,ResetDTO resetDTO, Model model) throws ControllerException {
		logger.info("invoked onSendOTP " + rdto);
		try {
			/*RegisterDTO user=service.getUserByEmail(rdto.getEmail());
			logger.debug(user);
			*/
			String otp = service.validateAndResetPassword(rdto );
			
			if (otp.equals("SUCCESS")) {
				model.addAttribute("OTP", "Please enter the OTP you received on registered email");
				logger.debug("OTP mail sent to the registered email");
				return "ForgetPassword";
			}
			if (otp.equals("Fail")) {
				model.addAttribute("OTP", "Please enter your valid registered email to receive OTP");
				logger.debug("OTP mail not sent");
				return "Reset";
			}

		}catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} 
		catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Reset";
	}
	@RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
	public String onResetPassword(ResetDTO resetDTO,Model model) throws ControllerException {
		logger.info("invoked onResetPassword()");
		try {
		String resetPassword = service.validateAndUpdateNewPassword(resetDTO);
			if (resetPassword.equals("SUCCESS")) {
				model.addAttribute("resetPass", "Cool!! your password has been updated, Login now");
				logger.debug("new password updated successfully");
				return "Login";
				
			} else if(resetPassword.equals("Invalid_tempPassword")){
				model.addAttribute("resetPass", "Please verify your OTP & new passwords");
				logger.debug("new password not updated");
				return "ForgetPassword";
				
			}else if(resetPassword.equals("Mismatch")){
				model.addAttribute("resetPass", "Please verify your new password & confirm passwords");
				logger.debug("new password not updated due to mismatch");
				return "ForgetPassword";
				
			}else if(resetPassword.equals("NewPassword updateFail")){
				model.addAttribute("resetPass", "Please enter all valid values");
				logger.debug("Found empty fields, new password not updated");
				return "ForgetPassword";
			}
			

		}catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} 
		catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Reset";
	}
	
}
