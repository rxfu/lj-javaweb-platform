package com.pl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pl.util.PLLog;

/**
 * 数据库链接管理类
 * 
 * @author space_key
 */
public class DBManager {
	/**
	 * 获取数据库链接
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException {
		try {
			return DBDriverManager.getConnection();
		} catch (SQLException e) {
			PLLog.error(new DBManager(), "[getConnection]SQL错误，无法获取数据库链接："
					+ e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			PLLog.error(new DBManager(),
					"[getConnection]错误,无法找到驱动程序，无法获取数据库链接：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭数据库链接
	 * 
	 * @param conn
	 *            数据库链接
	 * @throws SQLException
	 */
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			PLLog.error(new DBManager(), "[close]SQL错误，无法关闭数据库链接："
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 关闭 预编译的 SQL 语句的对象
	 * 
	 * @param conn
	 *            预编译的 SQL 语句的对象
	 * @throws SQLException
	 */
	public static void close(PreparedStatement pst) {
		try {
			pst.close();
		} catch (SQLException e) {
			PLLog.error(new DBManager(), "[close]SQL错误，无法PreparedStatement："
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 关闭结果集
	 * 
	 * @param conn
	 *            结果集
	 * @throws SQLException
	 */
	public static void close(ResultSet rs) {
		try {
				rs.close();
		} catch (SQLException e) {
			PLLog.error(new DBManager(), "[close]SQL错误，无法关闭ResultSet："
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 关闭Connection,PreparedStatement,ResultSet
	 * 
	 * @param conn
	 *            结果集,预编译的 SQL 语句的对象,数据库链接
	 * @throws SQLException
	 * @throws SQLException
	 */
	public static void close(Connection conn, PreparedStatement pst,
			ResultSet rs) {
		close(rs);
		close(pst);
		close(conn);
	}
}
