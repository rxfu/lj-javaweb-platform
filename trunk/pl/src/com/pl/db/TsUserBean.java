package com.pl.db;

/**
 * 用户表
 */
public class TsUserBean {
	/** 用户id */
	private java.lang.String userId;
	/** 用户名 */
	private java.lang.String userName;
	/** 密码 */
	private java.lang.String password;
	/** 用户组 */
	private java.lang.String groupId;
	/** 备注 */
	private java.lang.String remark;

	public java.lang.String getUserId() {
		return userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getGroupId() {
		return groupId;
	}

	public void setGroupId(java.lang.String groupId) {
		this.groupId = groupId;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

}