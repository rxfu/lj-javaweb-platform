package com.pl.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pl.db.TsMenuBean;
import com.pl.db.TsMenuDao;
import com.pl.util.PLLog;

public class MenuService {

	/**
	 * 获取用户组下所有的菜单
	 * @param groupId 用户组ID
	 * @return 用户组权限下的所有菜单列表
	 * @throws SQLException
	 */
	public ArrayList<TsMenuBean> getMenuByGroupId(String groupId) throws SQLException {
		ArrayList<TsMenuBean> tsMenuListTop = new ArrayList<TsMenuBean>();
		TsMenuDao tsMenuDao = new TsMenuDao();
		try {
			//获取菜单一级列表
			tsMenuListTop = tsMenuDao.getMenuListByParentByGroupId("root", groupId);
			//获取二级菜单的子菜单
			for (TsMenuBean tsMenuBeanTop : tsMenuListTop) {
				if("P".equals(tsMenuBeanTop.getMenuType())){
					ArrayList<TsMenuBean> tsMenuList2 = new ArrayList<TsMenuBean>();
					tsMenuList2 = tsMenuDao.getMenuListByParentByGroupId(tsMenuBeanTop.getMenuId(), groupId);
					tsMenuBeanTop.setSubTsMenuBeanList(tsMenuList2);
					//获取三级菜单
					for (TsMenuBean tsMenuBean2 : tsMenuList2) {
						if("P".equals(tsMenuBean2.getMenuType())){
							ArrayList<TsMenuBean> tsMenuList3 = new ArrayList<TsMenuBean>();
							tsMenuList3 = tsMenuDao.getMenuListByParentByGroupId(tsMenuBean2.getMenuId(), groupId);
							tsMenuBean2.setSubTsMenuBeanList(tsMenuList3);
						}
					}
				}
			}
		} catch (SQLException e) {
			PLLog.error(this, "[getMenuByGroupId]获取菜单列表失败"+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return tsMenuListTop;
	}
}
