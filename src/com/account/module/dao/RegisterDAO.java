package com.account.module.dao;

import java.util.List;

import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.dto.ResetDTO;
import com.account.module.exceptions.RepositoryException;

public interface RegisterDAO {
	public long save(RegisterDTO dto) throws RepositoryException;

	public long fetchEmailCount(RegisterDTO dto) throws RepositoryException;

	public List<RegisterDTO> fetchDetailsforLogin(RegisterDTO dto) throws RepositoryException;

	public String updateNewPassword(RegisterDTO dto) throws RepositoryException;

	public boolean fetchPasswordCountForUpdate(ResetDTO dto) throws RepositoryException;

	public String updateNewPassword(ResetDTO resetDTO) throws RepositoryException;
	
	//public RegisterDTO getUserByEmail(String email);

}
