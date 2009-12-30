package com.pl.sql;

import org.apache.commons.lang.StringUtils;

public class MySqlPageSQL {
	/**
	 * @param sql 原始SQL语句
	 * @param startRow 起始行号
	 * @param rows 需要获取的行数
	 * @return 数据库特定的定位行集SQL语句
	 */
	static String getPageSQL(String sql, int startRow, int rows) {
		String pageSql = sql + " limit " + startRow + "," + rows;
		return pageSql;
	}
	// TODO 此处的sql.toLowerCase()可能会造成bug
	static String getCountSql(String sql){
		String countSql = "select count(*) from " + StringUtils.substringAfter(sql.toLowerCase(), "from");
		return countSql;
	}



}
