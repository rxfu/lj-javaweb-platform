package com.pl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pl.dao.SecurityUserDao;
import com.pl.service.BaseUserDetails;
import com.pl.tdo.SecurityUserBean;

public class UserDetailsServiceImpl implements UserDetailsService {
	private SecurityUserDao securityUserDao;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		SecurityUserBean securityUserBean = securityUserDao.selectByUsername(username);
		if(securityUserBean == null){
			throw new UsernameNotFoundException("用户 : "+username+"不存在！");
		}
		
		String userId = securityUserBean.getUserId();
		String password = securityUserBean.getPassword();
		List<String> authoritiesTemp = securityUserDao.selectAuthoritiesByUserId(userId);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String auth : authoritiesTemp) {
			authorities.add(new GrantedAuthorityImpl(auth));
		}
		BaseUserDetails baseUserDetails = new BaseUserDetails(userId, username, password, authorities);
		return baseUserDetails;
	}

	public SecurityUserDao getSecurityUserDao() {
		return securityUserDao;
	}

	public void setSecurityUserDao(SecurityUserDao securityUserDao) {
		this.securityUserDao = securityUserDao;
	}


}
