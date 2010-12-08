package com.pl.web.w.reg;

import com.pl.exception.PlException;


public interface RegService
{
	public void add(TsUser tsUser) throws PlException;
	public String isExisted(String username);
}
