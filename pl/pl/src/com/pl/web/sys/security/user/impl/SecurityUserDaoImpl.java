package com.pl.web.sys.security.user.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.web.sys.security.user.SecurityUserBean;
import com.pl.web.sys.security.user.SecurityUserDao;

public class SecurityUserDaoImpl extends BaseDao implements SecurityUserDao {
	
	public SecurityUserBean selectByUsername(String username){
		return (SecurityUserBean)super.selectOne("securityUser.selectByUsername",username);
	}

	@SuppressWarnings("unchecked")
	public List<String> selectAuthoritiesByUserId(String id){
		return (List<String>) super.selectList("securityUser.selectAuthoritiesByUserId",id);
	}

}
