package com;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pl.db.TsMenuBean;
import com.pl.service.MenuService;

public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		MenuService menuService = new MenuService();
		ArrayList<TsMenuBean> arrayList = new ArrayList<TsMenuBean>();
		arrayList = menuService.getMenuByGroupId("admin");
		for (TsMenuBean tsMenuBean : arrayList) {
			System.out.println(tsMenuBean.getMenuName());
		}

	}

}
