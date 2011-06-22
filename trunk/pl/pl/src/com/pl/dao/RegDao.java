package com.pl.dao;

import com.pl.exception.PlException;
import com.pl.tdo.TsUserBean;


public interface RegDao {
	/**
	 * 增加用户
	 * @param tsUser
	 * @return
	 * @throws PlException
	 */
	public TsUserBean insert(TsUserBean tsUser) throws PlException;

	/**
	 * 判断用户是否存在
	 * @param username
	 * @return
	 */
	public String isExisted(String username);
}
