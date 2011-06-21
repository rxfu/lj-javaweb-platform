package com.pl.dao;

import com.pl.exception.PlException;
import com.pl.tdo.TsUserBean;


public interface RegDao {
	public TsUserBean insert(TsUserBean tsUser) throws PlException;

	public String isExisted(String username);
}
