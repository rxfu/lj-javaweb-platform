package com.pl.web.w.pdtype.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.web.w.pdtype.Pdtype;
import com.pl.web.w.pdtype.PdtypeDao;

public class PdtypeDaoImpl extends BaseDao implements PdtypeDao {

	@SuppressWarnings("unchecked")
	public List<Pdtype> selectAllPdtypeByLevel(Pdtype pdtype) {
		return (List<Pdtype>) super.selectList("Pdtype.selectAllPdtypeByLevel", pdtype);
	}

}
