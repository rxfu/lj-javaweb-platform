package com.pl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.app.web.pagetag.Page;
import com.pl.exception.UserException;
import com.pl.util.PLLog;
import com.sun.rowset.CachedRowSetImpl;

public class SqlManager {
	public CachedRowSet getCrsBySql(String sql) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		CachedRowSet crs = new CachedRowSetImpl();
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			crs.populate(rs);
		} catch (SQLException e) {
			PLLog.error(this, "[getCrsBySql]:" + sql + "执行错误！");
			e.printStackTrace();
			throw e;
		} finally {
			DBManager.close(rs);
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return crs;
	}
	/**
	 * 获取SQL的总记录数
	 * 
	 * @param sql
	 * @return 总记录数
	 * @throws SQLException
	 */
	private int getTotalCount(String sql) throws SQLException {
		String countSql = MySqlPageSQL.getCountSql(sql);
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int totalCount = 0;
		try {
			conn = DBManager.getConnection();
			pst = conn.prepareStatement(countSql);
			rs = pst.executeQuery();
			if (rs.next())
				return totalCount = rs.getInt(1);
		} catch (SQLException e) {
			PLLog.error(this, "[getTotalCount]:" + countSql + "执行错误！");
			e.printStackTrace();
			throw e;
		} finally {
			DBManager.close(rs);
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return totalCount;
	}
	public CachedRowSet getCrsByPageSql(String sql,Page page) throws SQLException {
		
		int totalCount = 0;
		try {
			totalCount = getTotalCount(sql);
			page.setTotalCount(totalCount);
			sql = MySqlPageSQL.getPageSQL(sql, page.getFirst()-1, page.getPageSize());
			return getCrsBySql(sql);
		} catch (SQLException e) {
			PLLog.error(this, "[getCrsByPageSql]:"+sql+"执行错误！");
			e.printStackTrace();
			throw e;
		}
	}
	public CachedRowSet getCrsByPageSql(String sql,Page page,int maxRow) throws SQLException, UserException {
		
		int totalCount = 0;
		try {
			totalCount = getTotalCount(sql);
			if(totalCount>maxRow){
				PLLog.error(this, "[getCrsByPageSql]:"+sql+"执行错误！查询记录超出"+maxRow+"条记录被系统拒绝");
				throw new UserException("查询记录超出"+maxRow+"条记录被系统拒绝");
			}
			page.setTotalCount(totalCount);
			sql = MySqlPageSQL.getPageSQL(sql, page.getFirst()-1, page.getPageSize());
			return getCrsBySql(sql);
		} catch (SQLException e) {
			PLLog.error(this, "[getCrsByPageSql]:"+sql+"执行错误！");
			e.printStackTrace();
			throw e;
		}
	}
}
