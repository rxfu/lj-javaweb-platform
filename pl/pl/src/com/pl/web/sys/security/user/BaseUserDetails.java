package com.pl.web.sys.security.user;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseUserDetails implements UserDetails {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	protected String userId;
	/**
	 * 用户名
	 */
	protected String username;
	/**
	 * 密码
	 */
	protected String password;
	/**
	 * 帐号是否过期
	 */
	protected boolean accountNonExpired;
	/**
	 * 帐号是否被锁
	 */
	protected boolean accountNonLocked;
	/**
	 * 密码是否过期
	 */
	protected boolean credentialsNonExpired;
	/**
	 * 是否可用
	 */
	protected boolean enabled;
	/**
	 * 用户权限集合
	 */
	protected List<GrantedAuthority> authorities;
	
	public BaseUserDetails(String userId, String username, String password,
			List<GrantedAuthority> authorities) {
		this(userId,username,password,true,true,true,true,authorities);
	}
	public BaseUserDetails(String userId, String username, String password,
			boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled,
			List<GrantedAuthority> authorities) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.authorities = authorities;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	

}
