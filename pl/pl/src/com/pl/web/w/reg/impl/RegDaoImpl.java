package com.pl.web.w.reg.impl;

import com.pl.common.base.BaseDao;
import com.pl.common.util.IDFactory;
import com.pl.exception.PlException;
import com.pl.web.w.reg.RegDao;
import com.pl.web.w.reg.TsUser;

public class RegDaoImpl extends BaseDao implements RegDao {

	public TsUser insert(TsUser tsUser) throws PlException {
		tsUser.setUserId(IDFactory.getId());
		return (TsUser) super.insert("Reg.insert",tsUser);
	}

	public String isExisted(String username) {
		return (String) super.selectOne("Reg.checkByUsername", username);
	}

}
