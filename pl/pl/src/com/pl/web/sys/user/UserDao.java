package com.pl.web.sys.user;

import java.util.List;

import com.pl.common.pager.Pager;

public interface UserDao {
	public List<UserBean> selectPager(UserBean userBean, Pager pager);
	public UserBean insert(UserBean userBean);
}
