package com.account.service;

import com.account.dto.PatientDTO;

public interface PatientService {

	public boolean validateAndSave(PatientDTO patientDTO);
}
