package com.account.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.account.dto.PatientDTO;

public class ResultComponent {
	private List<PatientDTO> patientDTO = new ArrayList<PatientDTO>();

	public ResultComponent() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	@RequestMapping(value = "/result.do", method = RequestMethod.POST)
	public String showProduct(Model model) {
		System.out.println("Displaying all the products");

		model.addAttribute("list", this.patientDTO);
		return "result";
	}

}
