package com.pl.dao;

import java.util.List;

import com.pl.tdo.SecurityUserBean;


public interface SecurityUserDao {
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public SecurityUserBean selectByUsername(String username);
	/**
	 * 根据用户ID查询用户权限
	 * @param id
	 * @return
	 */
	public List<String> selectAuthoritiesByUserId(String id);
}
