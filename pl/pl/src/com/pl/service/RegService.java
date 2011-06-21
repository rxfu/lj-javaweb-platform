package com.pl.service;

import com.pl.exception.PlException;
import com.pl.tdo.TsUserBean;


public interface RegService
{
	public void add(TsUserBean tsUser) throws PlException;
	public String isExisted(String username);
}
