package com.account.module.dao;

import com.account.module.dto.RegisterDTO;

public interface RegisterDAO {
	public long save(RegisterDTO dto);
}
