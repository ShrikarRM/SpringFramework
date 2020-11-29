package com.account.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.part.Festival;
import com.account.part.Season;

public class FestivalTester {

	public static void main(String[] args) {
		String xmFile = "resources/Festival.xml";
		ApplicationContext spring = new ClassPathXmlApplicationContext(xmFile);
		//Festival refOfFestival = spring.getBean(Festival.class);

		//refOfFestival.celebration("xworkz");
		
		//Season refOfSeason=spring.getBean("summerSeason",Season.class);
		Season ref=spring.getBean("season",Season.class);
		ref.display();

		
		Season refOfSeason2=spring.getBean("winterSeason",Season.class);
		//refOfSeason2.display();
	}

}
