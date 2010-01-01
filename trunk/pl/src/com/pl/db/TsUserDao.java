package com.pl.db;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import com.app.web.pagetag.Page;
import com.pl.model.TsUserBean;
import com.pl.sql.SqlManager;
import com.pl.util.PLLog;
import com.pl.util.StringTool;
import com.sun.rowset.CachedRowSetImpl;

public class TsUserDao {

	/** 获取用户列表。当某个值为空是，不作为查询条件
	 * 获取全部用户列表
	 * @return 全部用户的列表
	 * @throws SQLException
	 */
	public ArrayList<TsUserBean> getUserList(String userId,String userName ,String groupId,Page page) throws SQLException {
		StringBuffer sql = new StringBuffer(" SELECT USER_ID,USER_NAME,GROUP_ID,REMARK FROM TS_USER WHERE 1=1 ");
		
		if(!StringTool.isEmpty(userId)){
			sql.append(" AND USER_ID LIKE '"+userId+"' ");
		}
		if(!StringTool.isEmpty(userName)){
			sql.append(" AND USER_NAME LIKE '"+userName+"' ");
		}
		if(!StringTool.isEmpty(groupId)){
			sql.append(" AND GROUP_ID = '"+groupId+"' ");
		}
		sql.append(" ORDER BY GROUP_ID,USER_NAME ");
		ArrayList<TsUserBean> reList = new ArrayList<TsUserBean>();
		try {
			CachedRowSet crs = new CachedRowSetImpl();
			SqlManager dbManager = new SqlManager(); 
			crs = dbManager.getCrsByPageSql(sql.toString(), page);
			while (crs.next()) {
				TsUserBean tsUserBean = new TsUserBean();
				tsUserBean.setUserId(crs.getString("USER_ID"));
				tsUserBean.setUserName(crs.getString("USER_NAME"));
				tsUserBean.setGroupId(crs.getString("GROUP_ID"));
				tsUserBean.setRemark(crs.getString("REMARK"));
				reList.add(tsUserBean);
			}
		} catch (SQLException e) {
			PLLog.error(this, "[getAllUserList]SQL错误"+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return reList;
	}
	/**
	 * 查询系统中是否存在某userid
	 * @param userId
	 * @return 如果存在返回true，否则false
	 * @throws SQLException
	 */
	public boolean haveUserId(String userId) throws SQLException{
		String sql = "SELECT USER_ID FROM TS_USER WHERE USER_ID = '"+userId+"' ";
		SqlManager sqlManager = new SqlManager();
		try {
			CachedRowSet crs = sqlManager.getCrsBySql(sql);
			if(crs.next()){
				return true;
			}
		} catch (SQLException e) {
			PLLog.error(this, "[haveUserId]SQL错误"+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return false;
	}
	/**
	 * 检查userId及password是否都在系统中存在
	 * @param userId
	 * @param password
	 * @return 如果存在返回true，否则返回false
	 * @throws SQLException
	 */
	public boolean checkPassword(String userId,String password) throws SQLException{
		String sql = "SELECT USER_ID FROM TS_USER WHERE USER_ID = '"+userId+"' AND PASSWORD = '"+password+"'";
		SqlManager sqlManager = new SqlManager();
		try {
			CachedRowSet crs = sqlManager.getCrsBySql(sql);
			if(crs.next()){
				return true;
			}
		} catch (SQLException e) {
			PLLog.error(this, "[checkPassword]SQL错误"+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return false;
	}
}
