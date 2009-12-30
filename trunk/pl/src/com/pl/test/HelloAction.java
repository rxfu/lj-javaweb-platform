package com.pl.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.opensymphony.xwork2.ActionSupport;
import com.pl.sql.DBManager;
import com.sun.rowset.CachedRowSetImpl;

public class HelloAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static CachedRowSet test() throws SQLException {
		String sql = "SELECT USER_ID,USER_NAME,GROUP_ID,REMARK FROM TS_USER";
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
			e.printStackTrace();
			throw e;
		}finally{
			DBManager.close(pst);
			DBManager.close(conn);
		}
		return crs;
	}

	public static void main(String[] args) {

	}
}
