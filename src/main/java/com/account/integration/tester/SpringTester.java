package com.account.integration;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.account.integration.dao.CoronaVaccineDAO;
import com.account.integration.dto.CoronaVaccineDTO;
import com.account.integration.service.CoronaVaccineService;

public class SpringTester {

	public static void main(String[] args) {
		/*
		 * DataSource dataSource=new DriverManagerDataSource();
		 * DriverManagerDataSource dataSource2=(DriverManagerDataSource)
		 * dataSource; dataSource2.setDriverClassName("");
		 * dataSource2.setUrl(""); dataSource2.setUsername("");
		 * dataSource2.setPassword("");
		 * 
		 */
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");) {
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			// CoronaVaccineDAO dao = container.getBean(CoronaVaccineDAO.class);
			
			// server side validations by service class and writing business
			// logic
			CoronaVaccineService service = container.getBean(CoronaVaccineService.class);
			CoronaVaccineDTO dto = new CoronaVaccineDTO();
			dto.setName("covaxin");
			dto.setDevelopedBy("Bharatbio");
			dto.setCountry("India");
			dto.setReadyToUse(true);
			dto.setVaccineId(7);

			// System.out.println(dto.toString());
			// dao.save(dto);
			// dao.readDataById(4);
			// dao.deleteById(4);
			// dao.updateNameById("covaxin", 1);
			String value=service.validateandSave(null);
			System.out.println(value);
			if("FAILED".equals(value))
			{
				System.out.println("data was not saved");
			}
		}
	}

}
