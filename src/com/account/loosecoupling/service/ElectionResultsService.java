package com.account.loosecoupling.service;

import com.account.loosecoupling.dto.ElectionResultsDTO;

public interface ElectionResultsService {

	public String validateAndSave(ElectionResultsDTO dto);
	public String deleteById(long resultId);

}
