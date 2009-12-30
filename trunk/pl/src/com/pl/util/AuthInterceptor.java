package com.pl.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 权限拦截器.
 * 
 * @author xiong
 * 
 */
public class AuthInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		/**
		 * 将要访问的url
		 */
		String url = ServletActionContext.getRequest().getRequestURI();

		
		// 判断此url是否在限制范围内
		if (1 == 1) {
			/**
			 * 拥有权限map
			 */
			Map<String, String> authMap = new HashMap<String, String>();
			String  userGroup= (String)invocation.getInvocationContext().getSession().get("userGroup");
			authMap = SysConfigs.groupAuthMap.get(userGroup);
			authMap = new HashMap<String, String>();
			//无任何权限
			if (authMap == null) {
				return "gotoLogin";
			}
			
			
			authMap.put("/pl/sys/searchuser.action", "");
			authMap.put("/pl/sys/login.action", "");
			authMap.put("/pl/sys/topframe.action", "");
			authMap.put("/pl/sys/leftframe.action", "");
			authMap.put("/pl/sys/mainframe.action", "");
			
	
			//获取权限
			String temp = authMap.get(url);
			System.out.println("------------" + url + "----------" + temp
					+ "---------");
			//判断权限
			if (!authMap.containsKey(url)) {
				PLLog.error(this, "<-----------------------无权访问:"+url+"--------------------->");
				return "gotoLogin";
			}
		}
		return invocation.invoke();

	}
}
