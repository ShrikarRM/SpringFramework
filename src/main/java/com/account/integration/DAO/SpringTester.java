package com.account.integration.DAO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.integration.DTO.CoronaVaccineDTO;

public class SpringTester {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");) {
			CoronaVaccineDAO dao = container.getBean(CoronaVaccineDAO.class);
			
			CoronaVaccineDTO dto = new CoronaVaccineDTO();
			dto.setName("pfizer");
			dto.setDevelopedBy("pfizer");
			dto.setCountry("USA");
			dto.setReadyToUse(true);
			//dto.setVaccineId(3);
			dao.save(dto);

		}
	}

}
