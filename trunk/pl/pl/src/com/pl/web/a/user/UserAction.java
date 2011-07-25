package com.pl.web.a.user;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;
import com.pl.tdo.TpProductBean;
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
	private UserDetailsService userService;
	private Pager pager;
	private TsUserBean tsUser;

	@Override
	public String list() {
		// TODO Auto-generated method stub
		if (null == pager) {
			pager = new Pager();
		}
		if (!isFirst()) {
			List<TsUserBean> reList = userService.list(tsUser, pager);
			setRequestVal("reList", reList);
		}
		return super.list();
		return super.list();
	}

}
