package com.pl.web.sys.user;

import java.util.List;

import com.pl.common.pager.Pager;

public interface UserService
{
	public List<UserBean> list(UserBean userBean,Pager pager);
	public void add(UserBean userBean);
}
