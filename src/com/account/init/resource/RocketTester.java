package com.account.init.resource;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.xml.internal.ws.api.server.Container;

public class RocketTester {

	public static void main(String[] args) {

		ApplicationContext container = new ClassPathXmlApplicationContext("resources/rocket-config.xml");
		Rocket dto = container.getBean(Rocket.class);
		System.out.println(dto.getCountry());
		RocketDAO dao = container.getBean(RocketDAO.class);
		try {
			dao.save(dto);
			//dao.update(dto);
			//dao.select(dto);
			//dao.delete(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
