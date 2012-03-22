package com.pl.dao.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.dao.PdtypeDao;
import com.pl.tdo.PdtypeBean;

public class PdtypeDaoImpl extends BaseDao implements PdtypeDao {

	@SuppressWarnings("unchecked")
	public List<PdtypeBean> selectAllPdtypeByLevel(PdtypeBean pdtype) {
		return (List<PdtypeBean>) super.selectList("Pdtype.selectAllPdtypeByLevel", pdtype);
	}

}
