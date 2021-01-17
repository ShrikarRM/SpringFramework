package com.account.module.dao;

import java.util.List;

import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.RepositoryException;

public interface RegisterDAO {
	public long save(RegisterDTO dto) throws RepositoryException;

	public long fetchEmailCount(String email) throws RepositoryException;

	public List<RegisterDTO> fetchDetailsforLogin(RegisterDTO dto ) throws RepositoryException;
}
