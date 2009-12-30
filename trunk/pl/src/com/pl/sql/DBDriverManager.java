package com.pl.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用DriverManager获取数据库链接
 * 
 * @author space_key
 * 
 */
final class DBDriverManager {

	protected static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/pl", "root", "123456");
		return conn;
	}
}
