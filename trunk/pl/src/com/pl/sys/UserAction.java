package com.pl.sys;

import java.sql.SQLException;
import java.util.ArrayList;

import com.app.web.pagetag.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.pl.model.TsUserBean;
import com.pl.service.UserService;
import com.pl.util.PLLog;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 用户列表
	 */
	ArrayList<TsUserBean> userList;
	/**
	 * 查询用户表头内容
	 */
	TsUserBean tsUserBean;
	/**
	 * 分页对象
	 */
	Page page = new Page(2);
	

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public ArrayList<TsUserBean> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<TsUserBean> userList) {
		this.userList = userList;
	}

	public TsUserBean getTsUserBean() {
		return tsUserBean;
	}

	public void setTsUserBean(TsUserBean tsUserBean) {
		this.tsUserBean = tsUserBean;
	}

	/**
	 * 查询用户信息
	 * @return
	 */
	public String searchUser(){
		if(null!=tsUserBean){
			UserService userService = new UserService();
			try {
				userList = userService.searchGroup(tsUserBean.getUserId(), tsUserBean.getUserName(), tsUserBean.getGroupId(),page);
			} catch (SQLException e) {
				PLLog.error(this, "[searchUser]查询用户出错："+e.getMessage());
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
}
