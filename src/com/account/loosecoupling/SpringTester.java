package com.account.loosecoupling;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.account.loosecoupling.dto.ElectionResultsDTO;
import com.account.loosecoupling.service.ElectionResultsServiceImpl;

public class SpringTester {

	public static void main(String[] args) {
		/*
		 * DataSource dataSource=new DriverManagerDataSource();
		 * DriverManagerDataSource dataSource2=(DriverManagerDataSource)
		 * dataSource; dataSource2.setDriverClassName("");
		 * dataSource2.setUrl("");
		 *  dataSource2.setUsername("");
		 * dataSource2.setPassword("");
		 * 
		 */
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/spring.xml");) {
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			
			// server side validations by service class and writing business logic
			// logic
			ElectionResultsServiceImpl service = container.getBean(ElectionResultsServiceImpl.class);
			ElectionResultsDTO dto=new ElectionResultsDTO();
			dto.setResultId(1);
			dto.setCandidateName("MTR");
			dto.setPartyName("KSR");
			dto.setWardNo(150);
			dto.setWonBy(25600);
			 
			String value=service.validateAndSave(dto);
			//String value =service.deleteById(4);
			System.out.println(value);
			if("FAILED".equals(value))
			{
				System.out.println("data was not saved");
			}
		}
	}

}
