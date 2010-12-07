package com.pl.web.w.reg;


public interface RegService
{
	public void add(TsUser tsUser) throws InterruptedException;
	public String isExisted(String username);
}
