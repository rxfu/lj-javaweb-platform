package com.pl.web.sys.user.impl;

import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.web.sys.user.UserBean;
import com.pl.web.sys.user.UserDao;
import com.pl.web.sys.user.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao;
	
	public void add(UserBean userBean) {
		UserBean userBean1 = new UserBean();
		userBean1.setId("1");
		userBean1.setName("xiong1");
		userBean1.setPassword("abc");
		userDao.insert(userBean1);
		
		
		UserBean userBean2 = new UserBean();
		userBean2.setId("2");
		userBean2.setName("xiong1");
		userDao.insert(userBean2);
		
//		this.userDao.add(userBean);
	}

	public List<UserBean> list(UserBean userBean,Pager pager) {
		return this.userDao.selectPager(userBean, pager);
	}
	////////////GetSet//////////

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
