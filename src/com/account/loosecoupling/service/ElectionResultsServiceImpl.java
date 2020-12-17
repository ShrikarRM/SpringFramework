package com.account.loosecoupling.service;

import com.account.loosecoupling.dao.ElectionResultsDAO;
import com.account.loosecoupling.dto.ElectionResultsDTO;

import lombok.Setter;
@Setter
public class ElectionResultsServiceImpl implements ElectionResultsService {
	private ElectionResultsDAO dao;

	public ElectionResultsServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}
	
	
	public ElectionResultsServiceImpl(ElectionResultsDAO dao) {
		super();
		this.dao = dao;
	}


	@Override
	public String validateAndSave(ElectionResultsDTO dto) {
		System.out.println("Invoked validate and save " + dto);
		String message = "NA";
		boolean valid = false;
		if (dto != null) {
			System.out.println("It is an object");
			long resultID = dto.getResultId();
			String candidateName = dto.getCandidateName();
			String partyName = dto.getPartyName();
			int wardNo = dto.getWardNo();
			int wonBy = dto.getWonBy();

			if (candidateName != null && !candidateName.isEmpty()) {
				System.out.println("it is a valid candidate name");
				valid = true;
			} else {
				System.out.println("it is not a valid candidate name");
			}

			if (valid) {
				if (partyName != null && !partyName.isEmpty() && 
						partyName.length()>=3 && 15>=partyName.length()) {
					System.out.println("it is a valid party name");
					valid = true;
				} else {
					System.out.println("it is not a valid party name");
				}
			}
			/*if (valid) {
				if (resultID > 0) {
					System.out.println("it is valid id");
					valid = true;
				} else {
					System.out.println("it is not a valid id");
					valid = false;
				}
			}*/

			if (valid) {
				if (500 >= wardNo && wardNo > 0) {
					System.out.println("it is valid num");
					valid = true;
				} else {
					System.out.println("it is not a valid num");
					valid = false;
				}
			}

			if (valid) {
				if (wonBy > 0) {
					System.out.println("Victorious");
					valid = true;
				} else {
					System.out.println("Looser");
					valid = false;
				}
			}
			if (valid) {

				System.out.println("saving dto");
				dao.validateAndSave(dto);
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



	@Override
	public String deleteById(long resultId) {
	dao.deleteById(resultId);
	System.out.println("deleted details");
		return null;
	}

}
