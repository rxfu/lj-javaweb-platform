package com.pl.web.sys.security.user;

import java.util.List;


public interface SecurityUserDao {
	public SecurityUserBean selectByUsername(String username);
	public List<String> selectAuthoritiesByUserId(String id);
}
