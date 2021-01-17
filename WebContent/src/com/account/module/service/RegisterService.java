package com.account.module.service;

import com.account.module.dto.RegisterDTO;

public interface RegisterService {
	public boolean validateAndSave(RegisterDTO dto);
}
