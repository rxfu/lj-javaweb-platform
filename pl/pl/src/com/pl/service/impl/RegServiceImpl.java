package com.pl.service.impl;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pl.common.base.BaseService;
import com.pl.common.pager.Pager;
import com.pl.dao.RegDao;
import com.pl.exception.PlException;
import com.pl.service.RegService;
import com.pl.tdo.TsUserBean;

public class RegServiceImpl extends BaseService implements RegService
{
	BasePasswordEncoder basePasswordEncoder;
	private RegDao regDao;
	public void add(TsUserBean tsUser) throws PlException {
		String password = basePasswordEncoder.encodePassword(tsUser.getPassword(), tsUser.getUsername());
		tsUser.setPassword(password);
		tsUser.setGroupId("ug_personal");
		if("existed".equals(isExisted(tsUser.getUsername()))){
			throw new PlException("用户名已经存在！");
		}
		regDao.insert(tsUser);
		//注册后自动登录
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(tsUser.getUsername(),tsUser.getPassword());  
		SecurityContext context = SecurityContextHolder.getContext();  
		context.setAuthentication(authenticationToken); 

	}
	public String isExisted(String username) {
		if(StringUtils.isEmpty(regDao.isExisted(username))){
			return "notExisted";
		}else{
			return "existed";
		}
	}
	
	public List<TsUserBean> list(TsUserBean tsUser, Pager pager) {
		return regDao.selectPager(tsUser, pager);
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
