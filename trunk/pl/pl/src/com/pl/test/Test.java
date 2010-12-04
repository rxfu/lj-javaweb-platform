package com.pl.test;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pl.web.sys.user.UserBean;
import com.pl.web.sys.user.UserService;


public class Test extends TestCase {
	public void testList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		UserBean userBean = new UserBean();
		userService.add(userBean);
	}
}
