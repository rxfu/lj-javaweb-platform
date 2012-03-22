package com.pl.dao.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.dao.SecurityUserDao;
import com.pl.tdo.SecurityUserBean;

public class SecurityUserDaoImpl extends BaseDao implements SecurityUserDao {
	
	public SecurityUserBean selectByUsername(String username){
		return (SecurityUserBean)super.selectOne("securityUser.selectByUsername",username);
	}

	@SuppressWarnings("unchecked")
	public List<String> selectAuthoritiesByUserId(String id){
		return (List<String>) super.selectList("securityUser.selectAuthoritiesByUserId",id);
	}

}
