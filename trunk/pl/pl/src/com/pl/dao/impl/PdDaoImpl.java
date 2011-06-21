package com.pl.dao.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.dao.PdDao;
import com.pl.tdo.TpProductBean;

public class PdDaoImpl extends BaseDao implements PdDao {
	@SuppressWarnings("unchecked")
	public List<TpProductBean> selectByGroupId(String groupId,int maxNum) {
		return (List<TpProductBean>) super.selectList("Pd.selectByGroup", groupId,0,maxNum);
	}

}
