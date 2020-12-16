package com.account.integration.service;

import com.account.integration.dao.CoronaVaccineDAO;
import com.account.integration.dto.CoronaVaccineDTO;

public class CoronaVaccineService {

	private CoronaVaccineDAO dao;

	public CoronaVaccineService(CoronaVaccineDAO dao) {
		System.out.println(this.getClass().getSimpleName() + " created");
		this.dao = dao;
	}

	public String validateandSave(CoronaVaccineDTO dto) {
		System.out.println("invoked validate and save " + dto);
		String message = "NA";
		boolean invalid = false;

		if (dto != null) {
			System.out.println("It is an object");
			String name = dto.getName();
			long id = dto.getVaccineId();
			String devby = dto.getDevelopedBy();
			String country=dto.getCountry();
			boolean toUse=dto.isReadyToUse();
			
			// server side validation for name
			if (!name.isEmpty() && name != null) {
				System.out.println("it is a valid name");
				invalid = true;
			} else {
				System.out.println("it is not a valid name");
				invalid = false;
			}
			
			//vaccineId validation
			if (id > 0) {
				System.out.println("it is valid id");
				invalid = true;
			} else {
				System.out.println("it is not a valid id");
				invalid = false;
			}
			
			//retoUse var validation
			if(toUse !=false){
				System.out.println("it is ready for usage");
				invalid=true;
			}else{
				System.out.println("it is not ready for usage");
				invalid=false;
			}
			
			//developdby org validation
			if (!devby.isEmpty() && devby != null) {
				System.out.println("you have entered the oganization name "+dto.getDevelopedBy());
				invalid = true;
			} else {
				System.out.println("Please mention oganization name");
				invalid = false;
			}
			
			//country validation
			if (!country.isEmpty() && country != null) {
				System.out.println("you have entered the country name "+dto.getName());
				invalid = true;
			} else {
				System.out.println("Please mention oganization name");
				invalid = false;
			}
					
			//
			if (invalid) {

				System.out.println("saving dto");
				dao.save(dto);
				message = "SAVED";
			} else {
				System.out.println("saving dto failed");
				message = "FAILED";
			}
			
			
		} else {
			System.out.println("dto is null,cannot save");
			message = "FAILED";
		}

		return message;
	}

}
