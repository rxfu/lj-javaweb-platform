package com.pl.test;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pl.dao.PdtypeDao;
import com.pl.tdo.PdtypeBean;


public class Test extends TestCase {
	public void testList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
		PdtypeDao pdtypeDao = (PdtypeDao) context.getBean("pdtypeDao");
		PdtypeBean pdtype = new PdtypeBean();
		pdtype.setLevel("1");
		pdtype.setPdtypeName1("手机数码");
		List<PdtypeBean> list = pdtypeDao.selectAllPdtypeByLevel(pdtype);
		for (PdtypeBean pdtype2 : list) {
			System.out.println(pdtype2.getPdtypeName1());
		}
//		UserService userService = (UserService) context.getBean("userService");
//		UserBean userBean = new UserBean();
//		userService.add(userBean);
	}
}
