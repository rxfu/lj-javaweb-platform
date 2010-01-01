package com.pl.model;

import java.util.ArrayList;

public class TsMenuBean {
	/** 菜单id */
	private java.lang.String menuId;
	/** 父菜单名称id */
	private java.lang.String menuParent;
	/** 菜单名字 */
	private java.lang.String menuName;
	/** 菜单的url */
	private java.lang.String menuUrl;
	/** 菜单的排列顺序 */
	private short menuOrder;
	/** 菜单的帮助*/
	private java.lang.String menuHelp;
	/** 菜单的权利*/
	private short menuAuth;
	/** 菜单的类型 P:路径 N:节点*/
	private java.lang.String menuType;
	/** 子菜单列表*/
	private ArrayList<TsMenuBean> subTsMenuBeanList = new ArrayList<TsMenuBean>();
	
	
	public ArrayList<TsMenuBean> getSubTsMenuBeanList() {
		return subTsMenuBeanList;
	}
	public void setSubTsMenuBeanList(ArrayList<TsMenuBean> subTsMenuBeanList) {
		this.subTsMenuBeanList = subTsMenuBeanList;
	}
	public java.lang.String getMenuId() {
		return menuId;
	}
	public void setMenuId(java.lang.String menuId) {
		this.menuId = menuId;
	}
	public java.lang.String getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(java.lang.String menuParent) {
		this.menuParent = menuParent;
	}
	public java.lang.String getMenuName() {
		return menuName;
	}
	public void setMenuName(java.lang.String menuName) {
		this.menuName = menuName;
	}
	public java.lang.String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(java.lang.String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public short getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(short menuOrder) {
		this.menuOrder = menuOrder;
	}
	public java.lang.String getMenuHelp() {
		return menuHelp;
	}
	public void setMenuHelp(java.lang.String menuHelp) {
		this.menuHelp = menuHelp;
	}
	public short getMenuAuth() {
		return menuAuth;
	}
	public void setMenuAuth(short menuAuth) {
		this.menuAuth = menuAuth;
	}
	public java.lang.String getMenuType() {
		return menuType;
	}
	public void setMenuType(java.lang.String menuType) {
		this.menuType = menuType;
	}

}
