package com.account.integration.DAO;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.account.integration.DTO.CoronaVaccineDTO;

public class SpringTester {

	public static void main(String[] args) {
		/*DataSource dataSource=new DriverManagerDataSource();
		DriverManagerDataSource dataSource2=(DriverManagerDataSource) dataSource;
		dataSource2.setDriverClassName("");
		dataSource2.setUrl("");
		dataSource2.setUsername("");
		dataSource2.setPassword("");
		
		*/
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");) {
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			CoronaVaccineDAO dao = container.getBean(CoronaVaccineDAO.class);
			
			CoronaVaccineDTO dto = new CoronaVaccineDTO();
			dto.setName("covaccine");
			dto.setDevelopedBy("Bharatbio");
			dto.setCountry("India");
			dto.setReadyToUse(true);
			dto.setVaccineId(1);
			
			//dao.save(dto);
			System.out.println(dto.toString());
			dao.read(4);
			//dao.delete(1);
			//dao.update("coronill", 1);
		}
	}

}
