package com.pl.sys;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pl.web.w.pdtype.PdtypeService;

public class SysListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent se) {
		System.out.println("系统初始化开始------------------");
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());

		PdtypeService pdtypeService = (PdtypeService)wac.getBean("pdtypeService");
		SysContexts.currentAllPdtype = pdtypeService.getCurrentAllPdtype();
		System.out.println("系统初始化结束------------------");
	}

}
