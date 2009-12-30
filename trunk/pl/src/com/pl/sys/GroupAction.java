package com.pl.sys;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.pl.db.TsGroupBean;
import com.pl.service.GroupService;
import com.pl.util.PLLog;

public class GroupAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户组列表
	 */
	private ArrayList<TsGroupBean> groupList;
	private TsGroupBean tsGroupBean  = new TsGroupBean();

	public ArrayList<TsGroupBean> getGroupList() {
		return groupList;
	}

	public void setGroupList(ArrayList<TsGroupBean> groupList) {
		this.groupList = groupList;
	}
	
	public TsGroupBean getTsGroupBean() {
		return tsGroupBean;
	}

	public void setTsGroupBean(TsGroupBean tsGroupBean) {
		this.tsGroupBean = tsGroupBean;
	}

	/*
	 * 根据tsGroupBean.group_id 插在group
	 */
	public String searchGroup(){
		GroupService groupService = new GroupService();
		try {
			if(null==tsGroupBean.getGroupName()){
				tsGroupBean.setGroupName("");
			}
			groupList = groupService.searchGroup(tsGroupBean.getGroupName());
		} catch (SQLException e) {
			PLLog.error(this, "[searchGroup]查询用户组出错："+e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String editGroupAuth(){
		return SUCCESS;
	}

}
