package com.pl.sys;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pl.service.PdService;
import com.pl.service.PdtypeService;

public class SysListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent se) {
		this.initSys(se);
	}
	private void initSys(ServletContextEvent se){
		System.out.println("系统初始化开始------------------");
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());

		PdtypeService pdtypeService = (PdtypeService)wac.getBean("pdtypeService");
		SysContexts.currentAllPdtype = pdtypeService.getCurrentAllPdtype();
		PdService pdService = (PdService)wac.getBean("pdService");
		SysContexts.groupList1 = pdService.listByGroup("1", 10);
		SysContexts.groupList2 = pdService.listByGroup("2", 10);
		SysContexts.groupList3 = pdService.listByGroup("3", 10);
		SysContexts.groupList4 = pdService.listByGroup("4", 10);
		System.out.println("系统初始化结束------------------");
	}

}
