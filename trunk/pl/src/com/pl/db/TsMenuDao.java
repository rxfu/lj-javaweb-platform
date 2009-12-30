package com.pl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pl.sql.DBManager;
import com.pl.util.PLLog;
/**
 * 菜单表DAO
 * @author space_key
 *
 */
public class TsMenuDao {

	/**
	 * 根据父菜单及用户组获取菜单列表
	 * @param parentId 父菜单ID
	 * @param groupId 用户组ID
	 * @return 返回父菜单下的一层菜单
	 * @throws SQLException 
	 */
	public ArrayList<TsMenuBean> getMenuListByParentByGroupId(String parentId,String groupId)
			throws SQLException {
		String sql = "SELECT A.MENU_ID,MENU_PARENT,MENU_NAME,MENU_URL,MENU_ORDER,MENU_HELP,MENU_TYPE " +
				" FROM TS_MENU A,TS_GROUP_MENU B WHERE MENU_PARENT = ? AND GROUP_ID = ? AND A.MENU_ID = B.MENU_ID " +
				" ORDER BY MENU_ORDER";
		ArrayList<TsMenuBean> reList = new ArrayList<TsMenuBean>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, parentId);
			pst.setString(2, groupId);
			rs = pst.executeQuery();
			while (rs.next()) {
				TsMenuBean tsMenuBean = new TsMenuBean();
				tsMenuBean.setMenuId(rs.getString("MENU_ID"));
				tsMenuBean.setMenuParent(rs.getString("MENU_PARENT"));
				tsMenuBean.setMenuName(rs.getString("MENU_NAME"));
				tsMenuBean.setMenuUrl(rs.getString("MENU_URL"));
				tsMenuBean.setMenuOrder(rs.getShort("MENU_ORDER"));
				tsMenuBean.setMenuHelp(rs.getString("MENU_HELP"));
				tsMenuBean.setMenuType(rs.getString("MENU_TYPE"));
				reList.add(tsMenuBean);
			}
		} catch (SQLException e) {
			PLLog.error(this, "[getAllUserList]SQL错误" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			DBManager.close(conn, pst, rs);
		}
		return reList;

	}
}
