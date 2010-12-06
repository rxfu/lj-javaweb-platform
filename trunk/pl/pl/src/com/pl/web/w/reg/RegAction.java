package com.pl.web.w.reg;

import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;

/**
 * 用户注册
 * @author 熊庆春
 *
 */

@Result(name="g-index", location = "/index.jsp")

public class RegAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private TsUser tsUser;
	private RegService regService;
	
	public String add() {
		try {
			regService.add(tsUser);
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("用户注册失败！");
		}
		return "g-index";
	}
	///////////////////////////////////////////////////////
	public TsUser getTsUser() {
		return tsUser;
	}
	public void setTsUser(TsUser tsUser) {
		this.tsUser = tsUser;
	}
	public RegService getRegService() {
		return regService;
	}
	public void setRegService(RegService regService) {
		this.regService = regService;
	}
	
	
}
