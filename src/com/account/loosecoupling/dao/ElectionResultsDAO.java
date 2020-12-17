package com.account.loosecoupling.dao;

import java.util.List;

import com.account.loosecoupling.dto.ElectionResultsDTO;

public interface ElectionResultsDAO {

	public String validateAndSave(ElectionResultsDTO dto);
	public String deleteById(long resultId);
	public void updateWardNoById(int wardNo, long resultId);
	public ElectionResultsDTO getByPartyName(String partyName);
	public List<ElectionResultsDTO> getList();
}
