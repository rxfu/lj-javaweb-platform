package com.pl.web.a.user;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;
import com.pl.service.RegService;
import com.pl.tdo.TsUserBean;

/**
 * 用户管理
 * 
 * @author 符荣鑫
 *
 */
@Result(name= "input", location = "user-preSave.jsp")
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private RegService regService;
	private Pager pager;
	private TsUserBean tsUser;

	@Override
	public String list() {
		// TODO Auto-generated method stub
		if (null == pager) {
			pager = new Pager();
		}
		if (!isFirst()) {
			List<TsUserBean> reList = regService.list(tsUser, pager);
			setRequestVal("reList", reList);
		}
		return super.list();
	}
	
	public RegService getRegService() {
		return regService;
	}

	public void setRegService(RegService regService) {
		this.regService = regService;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public TsUserBean getTsUser() {
		return tsUser;
	}

	public void setTsUser(TsUserBean tsUser) {
		this.tsUser = tsUser;
	}

}
