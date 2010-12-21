package com.pl.web.w.pd.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.web.a.product.TpProduct;
import com.pl.web.w.pd.PdDao;

public class PdDaoImpl extends BaseDao implements PdDao {
	@SuppressWarnings("unchecked")
	public List<TpProduct> selectByGroupId(String groupId,int maxNum) {
		return (List<TpProduct>) super.selectList("Pd.selectByGroup", groupId,0,maxNum);
	}

}
