package com.pl.web.w.reg.impl;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;

import com.pl.common.base.BaseService;
import com.pl.exception.PlException;
import com.pl.web.w.reg.RegDao;
import com.pl.web.w.reg.RegService;
import com.pl.web.w.reg.TsUser;

public class RegServiceImpl extends BaseService implements RegService
{
	BasePasswordEncoder basePasswordEncoder;
	private RegDao regDao;
	public void add(TsUser tsUser) throws PlException {
		String password = basePasswordEncoder.encodePassword(tsUser.getPassword(), tsUser.getUsername());
		tsUser.setPassword(password);
		tsUser.setGroupId("ug_personal");
		if("existed".equals(isExisted(tsUser.getUsername()))){
			throw new PlException("用户名已经存在！");
		}
		regDao.insert(tsUser);
	}
	public String isExisted(String username) {
		if(StringUtils.isEmpty(regDao.isExisted(username))){
			return "notExisted";
		}else{
			return "existed";
		}
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
