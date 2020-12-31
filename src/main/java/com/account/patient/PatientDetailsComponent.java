package com.account.patient;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.account.dto.PatientDTO;

@Component
@RequestMapping("/")
public class PatientDetailsComponent {
	private List<PatientDTO> patientDTO=new ArrayList<PatientDTO>();
	public PatientDetailsComponent() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
	
	@RequestMapping(value="details.do",method=RequestMethod.POST)
	public String enterDetails(@ModelAttribute PatientDTO dto, @RequestParam String submit, Model model, 
			HttpServletRequest request){
		System.out.println("invoked add Patient info");
		if ("submit".equals(submit)) {
			System.out.println(dto);
			this.patientDTO.add(dto);
			System.out.println("dto added into patientDTO, size is " + this.patientDTO.size());
			model.addAttribute("message", "Patient details were added successfully");
			model.addAttribute("dto", dto);
		}
		
		return "data";
	}
}
