package com.pl.dao;

import java.util.List;

import com.pl.tdo.SecurityUserBean;


public interface SecurityUserDao {
	public SecurityUserBean selectByUsername(String username);
	public List<String> selectAuthoritiesByUserId(String id);
}
