package com.pl.sys;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pl.db.TsMenuBean;
import com.pl.service.MenuService;
import com.pl.service.UserService;
import com.pl.util.PLLog;
public class SysAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<TsMenuBean> menuList;
	/**
	 * 用户登录
	 * @return 
	 */
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		UserService userService = new UserService();
		try {
			if (userService.login(userId, password)) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("groupId","admin");
				return SUCCESS;
			}
		} catch (SQLException e) {
			addActionError("登录失败："+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("登录失败："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR ;
	}
	/**
	 * 获取页面顶部数据
	 * @return
	 */
	public String topframe(){
		return SUCCESS;
	}
	/**
	 * 获取登录用户菜单
	 * @return 菜单列表
	 */
	public String leftframe(){
	HttpSession session = ServletActionContext.getRequest().getSession();
	//获取用户组ID
	String groupId = (String) session.getAttribute("groupId");
	MenuService menuService = new MenuService();
	try {
		menuList = menuService.getMenuByGroupId(groupId);
	} catch (SQLException e) {
		e.printStackTrace();
		addActionError("获取菜单失败"+e.getMessage());
		PLLog.error(this, "[leftframe]获取菜单失败"+e.getMessage());
	}
		return SUCCESS;
	}
	/**
	 * 获取主页面信息
	 * @return
	 */
	public String mainframe() {
		
		return SUCCESS;
	}
	public ArrayList<TsMenuBean> getMenuList() {
		return menuList;
	}
	public void setMenuList(ArrayList<TsMenuBean> menuList) {
		this.menuList = menuList;
	}
	

}
