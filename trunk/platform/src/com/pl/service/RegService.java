package com.pl.service;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.exception.PlException;
import com.pl.tdo.TsUserBean;


public interface RegService
{
	public void add(TsUserBean tsUser) throws PlException;
	public String isExisted(String username);
	public List<TsUserBean> list(TsUserBean tsUser, Pager pager);
	public void edit(TsUserBean tsUser) throws Exception;
	public void deleteOne(String userId) throws SQLException;
}
