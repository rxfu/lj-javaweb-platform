package com.pl.web.sys.user;

import java.util.List;

import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;

/**
 * 用户管理
 * @author 熊庆春
 *
 */
public class UserAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private UserBean userBean;
	private UserService userService;
	private Pager pager;

	
	
	public String preLogin(){
		return "preLogin";
	}
	@Override
	public String add()
	{
		System.out.println("----------------------user+add-----------------------------------------");
		System.out.println(userBean.getName());
		
		return PREADD;
	}
	
	@Override
	public String list() {
		if(null == pager){
			pager = new Pager();
		}
		List<UserBean>reList = userService.list(userBean,pager);
		setRequestVal("reList",reList);
		return LIST;
	}

	/////////////////////////////////////////////////////////////////////
	public UserBean getUserBean()
	{
		return userBean;
	}
	public void setUserBean(UserBean userBean)
	{
		this.userBean = userBean;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
}
