package com.pl.web.w.reg;

import com.pl.exception.PlException;


public interface RegDao {
	public TsUser insert(TsUser tsUser) throws PlException;

	public String isExisted(String username);
}
