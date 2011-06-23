package com.pl.sys;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pl.service.PdtypeService;
import com.pl.service.ProductService;

public class SysListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent se) {
		this.initSys(se);
	}
	private void initSys(ServletContextEvent se){
		System.out.println("系统初始化开始------------------");
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());

		PdtypeService pdtypeService = (PdtypeService)wac.getBean("productService");
		SysContexts.currentAllPdtype = pdtypeService.getCurrentAllPdtype();
		ProductService productService = (ProductService)wac.getBean("productService");
		SysContexts.groupList1 = productService.listByGroup("1", 10);
		SysContexts.groupList2 = productService.listByGroup("2", 10);
		SysContexts.groupList3 = productService.listByGroup("3", 10);
		SysContexts.groupList4 = productService.listByGroup("4", 10);
		System.out.println("系统初始化结束------------------");
	}

}
