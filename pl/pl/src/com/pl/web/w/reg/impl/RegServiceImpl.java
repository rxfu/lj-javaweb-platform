package com.pl.web.w.reg.impl;

import org.springframework.security.authentication.encoding.BasePasswordEncoder;

import com.pl.web.w.reg.RegDao;
import com.pl.web.w.reg.RegService;
import com.pl.web.w.reg.TsUser;


public class RegServiceImpl  implements RegService
{
	BasePasswordEncoder basePasswordEncoder;
	private RegDao regDao;
	public void add(TsUser tsUser) throws InterruptedException {
		String password = basePasswordEncoder.encodePassword(tsUser.getPassword(), tsUser.getUsername());
		tsUser.setPassword(password);
		tsUser.setGroupId("ug_personal");
		regDao.insert(tsUser);	
	}
	/////////////////////////////////////////////////////////////
	public RegDao getRegDao() {
		return regDao;
	}
	public void setRegDao(RegDao regDao) {
		this.regDao = regDao;
	}
	public BasePasswordEncoder getBasePasswordEncoder() {
		return basePasswordEncoder;
	}
	public void setBasePasswordEncoder(BasePasswordEncoder basePasswordEncoder) {
		this.basePasswordEncoder = basePasswordEncoder;
	}
	
	

}
