package com.pl;

import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

import com.pl.util.PLLog;
import com.pl.util.SysConfigs;

/**
 * 系统启动Servlet
 * Servlet implementation class PLServlet
 */
public class PLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PLServlet() {
        super();
    }

	/**
	 * 系统初始化方法
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		//系统url根目录
		SysConfigs.path = servletConfig.getServletContext().getContextPath();
		//系统的绝对路径
		String realPath =  servletConfig.getServletContext().getRealPath("/");
		PropertyConfigurator.configure(realPath+ servletConfig.getInitParameter("log4jconfigfile"));
		
		//初始化参数
		try {
			new SysConfigs().initPara();
		} catch (SQLException e) {
			e.printStackTrace();
			PLLog.info(this, "<-----------------------初始化参数失败！--------------------->"+e.getMessage());
		}
		PLLog.info(this, "<-----------------------初始化log4j日志成功！--------------------->");
		
		
		
	}
}
