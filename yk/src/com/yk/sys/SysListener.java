package com.yk.sys;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysListener implements ServletContextListener {

	private static final Log log = LogFactory.getLog(SysListener.class);
	
	public void contextDestroyed(ServletContextEvent arg0) {

	}
	public void contextInitialized(ServletContextEvent se) {
		this.initSys(se);
	}
	private void initSys(ServletContextEvent se){
		log.info("ϵͳ��ʼ����ʼ------------------");
		//ͨ���˴���ȡspring����
//		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());
		log.info("ϵͳ��ʼ������------------------");
	}

}
