package com.account.module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.RequestScope;

import com.account.module.constants.AppConstant;
import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.ControllerException;
import com.account.module.exceptions.ServiceException;
import com.account.module.service.RegisterService;

@Controller
@RequestMapping("/")
@SessionAttributes("name")
public class RegistrationController {
	@Autowired
	private RegisterService service;

	public RegistrationController() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String onSave(RegisterDTO dto, Model model) throws ControllerException {
		System.out.println("invoked onSave " + dto);
		try {
			String saved = service.validateAndSave(dto);
			if (saved.equals("DUPLICATE")) {
				
				//model.addAttribute("dto", dto);
				//model.addAttribute("message", saved);
				model.addAttribute("save_detail","Email alreay exists in database");
				System.out.println("not saving the details");
				return AppConstant.LANDING_PAGE;
			} if (saved.equals("SAVED")) {
				model.addAttribute("save", "Saved successfully & Registration mail sent");
				System.out.println("saving the details");
				
				/*boolean sent=service.sendMail(dto);
					if (sent) {
						model.addAttribute("success", "mail sent successfully");
						System.out.println("invoked onSendMail");
					} else {
						model.addAttribute("success", "mail not sent");
						System.out.println("invoked onSendMail");
					}*/
					return AppConstant.LANDING_PAGE;
				}
			 else{
				model.addAttribute("save_detail", "Data not Saved ");
				System.out.println("Data is not valid , not saved to DB");
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
		System.out.println("invoked onLogin " + rdto+loginDTO);

		try {
			List<RegisterDTO> dto = service.validateAndLogin(rdto);
			System.out.println(dto);
			System.out.println(loginDTO);
			for (RegisterDTO registerDTO : dto) {
				if(registerDTO.getPassword().equals(loginDTO.getPassword())){
					System.out.println("Passwords matching, Login suceesful");
					model.addAttribute("login", "Login success");
					model.addAttribute("name","Hi "+registerDTO.getFirstName());
				}else{
					model.addAttribute("login", "Login failed ");
					System.out.println("Email/Password are incorrect, Login failed");
				}
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";
	}
}
