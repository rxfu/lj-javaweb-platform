package com.pl.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pl.db.TsGroupBean;
import com.pl.db.TsGroupDao;
import com.pl.util.PLLog;

/**
 * 用户组相关service
 * @author space_key
 *
 */
public class GroupService {

	/**
	 * 通过用户组名查找用户组
	 * @param groupName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<TsGroupBean> searchGroup(String groupName) throws SQLException{
		ArrayList<TsGroupBean> arrayList = new ArrayList<TsGroupBean>();
		TsGroupDao groupDao = new TsGroupDao();
		try {
			arrayList = groupDao.selectTsGroupbyName(groupName);
		} catch (SQLException e) {
			PLLog.error(this, "[searchGroup]查询用户组出错："+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return arrayList;
	}
}
