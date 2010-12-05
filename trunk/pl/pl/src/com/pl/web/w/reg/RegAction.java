package com.pl.web.w.reg;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.pl.common.base.BaseAction;

/**
 * 用户注册
 * @author 熊庆春
 *
 */
@Results({
	 @Result(name="g-index", location = "/index.jsp")
})
public class RegAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private TsUser tsUser;
	
	public String add() {
		return "g-index";
	}
	///////////////////////////////////////////////////////
	public TsUser getTsUser() {
		return tsUser;
	}
	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}
	
	
}
