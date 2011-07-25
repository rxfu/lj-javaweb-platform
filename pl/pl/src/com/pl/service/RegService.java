package com.pl.service;

import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.exception.PlException;
import com.pl.tdo.TsUserBean;


public interface RegService
{
	public void add(TsUserBean tsUser) throws PlException;
	public String isExisted(String username);
	public List<TsUserBean> list(TsUserBean tsUser, Pager pager);
}
