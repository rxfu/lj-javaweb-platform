package com.pl.web.sys.user.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.common.pager.Pager;
import com.pl.web.sys.user.UserBean;
import com.pl.web.sys.user.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	public UserBean insert(UserBean userBean) {
		return (UserBean)super.insert(userBean);
	}


	@SuppressWarnings("unchecked")
	public List<UserBean> selectPager(UserBean userBean, Pager pager) {
		return super.selectPager(userBean, pager);
	}
}
