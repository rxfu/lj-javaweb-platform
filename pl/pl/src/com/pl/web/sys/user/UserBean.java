package com.pl.web.sys.user;
/**
 * 用户Bean
 * @author 熊庆春
 *
 */
public class UserBean
{
	/**
	 * 用户ID
	 */
	private String id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 密码验证
	 */
	private String passwordAg;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPasswordAg()
	{
		return passwordAg;
	}
	public void setPasswordAg(String passwordAg)
	{
		this.passwordAg = passwordAg;
	}
}
