package com.account.module.dao;

import java.util.List;

import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.dto.ResetDTO;
import com.account.module.dto.UpdateDTO;
import com.account.module.exceptions.RepositoryException;

public interface RegisterDAO {
	public long save(RegisterDTO dto) throws RepositoryException;

	public long fetchEmailCount(RegisterDTO dto) throws RepositoryException;

	public List<RegisterDTO> fetchDetailsforLogin(String email) throws RepositoryException;

	public String updateNewPassword(RegisterDTO dto) throws RepositoryException;

	public boolean fetchPasswordCountForUpdate(ResetDTO dto) throws RepositoryException;

	public String updateNewPassword(ResetDTO resetDTO) throws RepositoryException;

	// public RegisterDTO getUserByEmail(String email);
	public int updateLoginFailedCount(String email,long count) throws RepositoryException;

	public boolean updateLoginaccountStatus(String email,boolean status) throws RepositoryException;
	public void updateNames(UpdateDTO dto) throws RepositoryException;
	//public int updateCountOnCorrectLogin(String email,boolean status) throws RepositoryException;

	//public boolean updateAccountStatusToLocked(LoginDTO loginDTO) throws RepositoryException;

}
