package com.pl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pl.sql.DBManager;
import com.pl.util.PLLog;
/**
 * 对用户组的dao
 * @author space_key
 *
 */
public class TsGroupDao {

	/**
	 * 插入ts_group
	 * @param tsGroupBean
	 * @return 插入记录数
	 * @throws SQLException
	 */
	public int insertTsGroup(TsGroupBean tsGroupBean) throws SQLException{
		int reInt = 0;
		String sql = "INSERT INTO TS_GROUP (?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, tsGroupBean.getGroupId());
			pst.setString(2, tsGroupBean.getGroupName());
			reInt = pst.executeUpdate();
		} catch (SQLException e) {
			PLLog.error(this, "[TS_GROUP]错误：插入表groupId:"+tsGroupBean.getGroupId()
					+"|groupName:"+tsGroupBean.getGroupName()+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return reInt;
	}
	/**
	 * 更新ts_group by group_ID
	 * @param tsGroupBean
	 * @return 更新记录数
	 * @throws SQLException
	 */
	public int updateTsGroupbyID(TsGroupBean tsGroupBean) throws SQLException{
		int reInt = 0;
		String sql = "UPDATE TS_GROUP SET GROUP_NAME = ? WHERE GROUP_ID = ?";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, tsGroupBean.getGroupId());
			pst.setString(2, tsGroupBean.getGroupName());
			reInt = pst.executeUpdate();
		} catch (SQLException e) {
			PLLog.error(this, "[TS_GROUP]错误：更新表groupId:"+tsGroupBean.getGroupId()
					+"|groupName:"+tsGroupBean.getGroupName()+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return reInt;
	}
	/**
	 * 删除ts_group by group_ID
	 * @param groupId
	 * @return 删除记录数
	 * @throws SQLException
	 */
	public int deleteTsGroupbyID(String groupId) throws SQLException{
		int reInt = 0;
		String sql = "DELETE FROM TS_GROUP SET WHERE GROUP_ID = ?";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, groupId);
			reInt = pst.executeUpdate();
		} catch (SQLException e) {
			PLLog.error(this, "[TS_GROUP]错误：删除表groupId:"+groupId+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return reInt;
	}
	/**
	 * 查询ts_group by group_ID
	 * @param groupId
	 * @return 删除记录数
	 * @throws SQLException
	 */
	public TsGroupBean selectTsGroupbyID(String groupId) throws SQLException{
		TsGroupBean tsGroupBean = new TsGroupBean();
		String sql = "SELECT GROUP_ID,GROUP_NAME FROM TS_GROUP WHERE GROUP_ID = ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, groupId);
			rs = pst.executeQuery();
			if(rs.next()){
				tsGroupBean.setGroupId(rs.getString("GROUP_ID"));
				tsGroupBean.setGroupName(rs.getString("GROUP_NAME"));
			}else {
				return null;
			}
		} catch (SQLException e) {
			PLLog.error(this, "[TS_GROUP]错误：查表groupId:"+groupId+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return tsGroupBean;
	}
	public static void main(String[] args) {
		try {
			TsGroupBean groupBean = new TsGroupBean();
			groupBean = new TsGroupDao().selectTsGroupbyID("admin");
			System.out.println(groupBean.getGroupName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询ts_group by group_name
	 * @param groupName
	 * @return 删除记录数
	 * @throws SQLException
	 */
	public ArrayList<TsGroupBean> selectTsGroupbyName(String groupName) throws SQLException{
		ArrayList<TsGroupBean> arrayList = new ArrayList<TsGroupBean>();
		String sql = "SELECT GROUP_ID,GROUP_NAME FROM TS_GROUP WHERE GROUP_ID LIKE '%"+groupName+"%' ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				TsGroupBean tsGroupBean = new TsGroupBean();
				tsGroupBean.setGroupId(rs.getString("GROUP_ID"));
				tsGroupBean.setGroupName(rs.getString("GROUP_NAME"));
				arrayList.add(tsGroupBean);
			}
		} catch (SQLException e) {
			PLLog.error(this, "[TS_GROUP]错误：查表groupName:"+groupName+e.getMessage());
			e.printStackTrace();
			throw e;
		}finally{
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return arrayList;
	}
}
