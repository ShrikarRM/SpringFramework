package com.account.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.account.dto.PatientDTO;
import com.account.service.PatientService;

@Controller // or @Component can be used
@RequestMapping("/")
public class CoronaController {
	@Autowired
	private PatientService patientService;

	public CoronaController() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public String onSave(PatientDTO dto, Model model) {
		System.out.println("invoked onSave " + dto);

		boolean saved = patientService.validateAndSave(dto);
		System.out.println("dto saved status " + saved);
		if (saved) {
			model.addAttribute("dto", dto);
			System.out.println("saved dto navigating to result page");
			return "result";
		}
		System.out.println("not saved dto navigating to index page");
		return "index";
	}
}
