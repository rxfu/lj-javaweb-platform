package com.pl.test;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pl.web.w.pdtype.Pdtype;
import com.pl.web.w.pdtype.PdtypeDao;


public class Test extends TestCase {
	public void testList(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
		PdtypeDao pdtypeDao = (PdtypeDao) context.getBean("pdtypeDao");
		Pdtype pdtype = new Pdtype();
		pdtype.setLevel("1");
		pdtype.setPdtypeName1("手机数码");
		List<Pdtype> list = pdtypeDao.selectAllPdtypeByLevel(pdtype);
		for (Pdtype pdtype2 : list) {
			System.out.println(pdtype2.getPdtypeName1());
		}
//		UserService userService = (UserService) context.getBean("userService");
//		UserBean userBean = new UserBean();
//		userService.add(userBean);
	}
}
