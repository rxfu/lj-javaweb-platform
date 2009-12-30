package com.pl.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.app.web.pagetag.Page;
import com.pl.db.TsUserBean;
import com.pl.db.TsUserDao;
import com.pl.util.MD5;

/**
 * 用户相关service
 * 
 * @author space_key
 * 
 */
public class UserService {

	/**
	 * 查找用户
	 * 
	 * @param userId
	 * @param userName
	 * @param groupId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<TsUserBean> searchGroup(String userId, String userName,
			String groupId, Page page) throws SQLException {
		ArrayList<TsUserBean> arrayList = new ArrayList<TsUserBean>();
		TsUserDao tsUserDao = new TsUserDao();
		arrayList = tsUserDao.getUserList(userId, userName, groupId, page);
		return arrayList;
	}
	/**
	 * 用户登录方法，如检查没有该用户则抛出异常"改用户不存在！"，如检查密码错误则报错异常"输入密码错误！",检查用户名密码通过后执行登录注册操作。
	 * @param userId
	 * @param password
	 * @return 返回"登录成功"则登录成功
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean login(String userId,String password) throws SQLException, Exception {
		TsUserDao tsUserDao = new TsUserDao();
		MD5 md5 = new MD5();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(!tsUserDao.haveUserId(userId)){
			throw new Exception("该用户不存在！");
		}
		//加密密码
		password = md5.calcMD5(password);
		if(tsUserDao.checkPassword(userId, password)){
			throw new Exception("输入密码错误！");
		}
//		TODO 登录注册未写
		

		return true;
	}
}
