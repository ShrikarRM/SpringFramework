package com.account.integration;

import com.account.integration.DAO.CoronaVaccineDAO;
import com.account.integration.DTO.CoronaVaccineDTO;

public class Tester {

	public static void main(String[] args) {
		CoronaVaccineDTO dto = new CoronaVaccineDTO();
		dto.setName("covaxin");
		dto.setDevelopedBy("BharatBioTech");
		dto.setCountry("India");
		dto.setReadyToUse(true);
		dto.setVaccineId(1);

		CoronaVaccineDAO dao = new CoronaVaccineDAO();
		dao.save(dto);
	}

}
