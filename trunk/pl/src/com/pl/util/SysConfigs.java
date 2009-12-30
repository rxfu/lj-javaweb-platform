package com.pl.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.pl.sql.DBManager;

public class SysConfigs {

	/**
	 * 系统的url根目录
	 */
	public static String path = "";

	/**
	 * 系统用户组及路径权限的map,Map<用户组名, 拥有的权限map>
	 */
	public static Map<String, Map<String, String>> groupAuthMap = new HashMap<String, Map<String,String>>();

	public void initPara() throws SQLException {
		this.initGroupAuthMap();
	}
	
	private void initGroupAuthMap() throws SQLException {
		groupAuthMap.clear();
		ArrayList<String> groupIdAuth = new ArrayList<String>();
		groupIdAuth = this.getAllGroupId();
		for (String groupId : groupIdAuth) {
			groupAuthMap.put(groupId, this.getGroupAuth(groupId));
		}
	}

	/**
	 * 获取所有的用户组ID
	 * @return 用户组ID
	 * @throws SQLException 数据库查询出
	 */
	private ArrayList<String> getAllGroupId() throws SQLException {
		ArrayList<String> reList = new ArrayList<String>();
		String sql = "SELECT GROUP_ID FROM TS_GROUP_MENU";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				reList.add(rs.getString("GROUP_ID"));
			}
		} catch (SQLException e) {
			PLLog.error(this, "[getAllGroupId]错误" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return reList;
	}
	/**
	 * 获取用户组权限
	 * @param groupId 用户组ID
	 * @return 返回用户组权限的map Map<用户组权限, "">
	 * @throws SQLException 数据库查询出
	 */
	private Map<String, String> getGroupAuth(String groupId) throws SQLException {
		Map<String, String> authMap = new HashMap<String, String>();
		String sql = "SELECT A.MENU_AUTH FROM TS_MENU A,TS_GROUP_MENU B WHERE A.MENU_ID = B.MENU_ID AND B.GROUP_ID = ? ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, groupId);
			rs = pst.executeQuery();
			while (rs.next()) {
				String authArrayStr = rs.getString("MENU_AUTH");
				if(authArrayStr!=null){
					String[] authArray  = authArrayStr.split(",");
					for (String authSingleStr : authArray) {
						authMap.put(authSingleStr, "");
					}
				}

			}
		} catch (SQLException e) {
			PLLog.error(this, "[getAllGroupId]错误" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return authMap;
	}

}
