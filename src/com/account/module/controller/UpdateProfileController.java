package com.account.module.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.dto.UpdateDTO;
import com.account.module.exceptions.ControllerException;
import com.account.module.exceptions.ServiceException;
import com.account.module.service.RegisterService;

@Controller
@RequestMapping("/")
public class UpdateProfileController {
	@Autowired
	private RegisterService service;
	private List<RegisterDTO> list;
	static Logger logger = Logger.getLogger(UpdateProfileController.class);

	public UpdateProfileController() {
		logger.info(this.getClass().getSimpleName() + " created");
	}
		
	@RequestMapping(value = "/welcome/{email:.+}")
	public String onFetchingNames( @PathVariable String email,RegisterDTO dto, Model model) throws ControllerException {
		logger.info("invoked onUpdate "+email );

		try {
			List<RegisterDTO> list=service.loginDetails(email);
			for (RegisterDTO registerDTO : list) {
					model.addAttribute("details",registerDTO);				
			}		
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UpdateProfile";
	}
	
	@RequestMapping(value = "/spring-common-module/update", method = RequestMethod.POST)
	public String onUpdatingNames(RegisterDTO dto, UpdateDTO udto, Model model) {
		try {
			String updateDetails = service.updateDetails(dto, udto);
			logger.debug(updateDetails + ".......values.....");
			if (updateDetails.equals("UPDATED")) {
				model.addAttribute("nameupdate", "Values updated");
				logger.debug("values are updating now");
				return "Home";
			}
			if (updateDetails.equals("NOT UPDATED")) {
				model.addAttribute("nameupdate", "values are not updated");
				logger.debug("values are not updating now");
				return "UpdateProfile";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UpdateProfile";
	}
}
