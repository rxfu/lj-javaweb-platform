package com.pl.web.w.reg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
import com.pl.exception.PlException;
import com.pl.service.RegService;
import com.pl.tdo.TsUserBean;

/**
 * 用户注册
 * @author 熊庆春
 *
 */

@Result(name="g-index", location = "/index.jsp")

public class RegAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private static final  Log log = LogFactory.getLog(RegAction.class);
	private TsUserBean tsUser;
	private RegService regService;
	
	public String preLogin(){
		return "preLogin";
	}
	public String add() {
		try {
			regService.add(tsUser);
		} catch (PlException e) {
			e.printStackTrace();
			log.error("用户注册失败："+e.getMessage());
			this.addActionError("用户注册失败："+e.getMessage());
			return PREADD;
		}
		return "g-index";
	}
	///////////////////////////////////////////////////////
	public TsUserBean getTsUser() {
		return tsUser;
	}
	public void setTsUser(TsUserBean tsUser) {
		this.tsUser = tsUser;
	}
	public RegService getRegService() {
		return regService;
	}
	public void setRegService(RegService regService) {
		this.regService = regService;
	}
	
	
}
