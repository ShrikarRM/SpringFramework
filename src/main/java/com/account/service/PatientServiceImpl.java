package com.account.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.PatientDAO;
import com.account.dto.PatientDTO;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDAO dao;

	public PatientServiceImpl() {
		System.out.println("service method invoked");
	}

	public boolean validateAndSave(PatientDTO patientDTO) {

		System.out.println("invoked validateAndSave in ServiceImpl");
		boolean valid = false;

		if (Objects.nonNull(patientDTO)) { // instead of writing two condn for
											// null & empty check
			String name = patientDTO.getName();
			int age = patientDTO.getAge();
			long mobile = patientDTO.getMobile();
			String email = patientDTO.getEmail();
			String address = patientDTO.getAddress();
			String state = patientDTO.getState();
			String result = patientDTO.getResult();

			if (name != null && !name.isEmpty() && name.length() >= 3) {
				System.out.println("name is valid");
				valid = true;
			} else {
				System.out.println("name is invalid");
				valid = false;
			}
			if (valid) {

			}

			if (valid) {
				if (age > 0) {
					System.out.println("entered a valid age");
					valid = true;

				} else {
					System.out.println("you have entered an invalid age");
					valid = false;
				}
			}
		}

		if (valid) {
			dao.save(patientDTO);
			System.out.println("data is valid, it can be saved into DB");
		} else {
			System.out.println("data is invalid, it can't be saved into DB");
		}
		return valid;
	}

}
