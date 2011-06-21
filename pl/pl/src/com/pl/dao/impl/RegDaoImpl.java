package com.pl.dao.impl;

import com.pl.common.base.BaseDao;
import com.pl.common.util.IDFactory;
import com.pl.dao.RegDao;
import com.pl.exception.PlException;
import com.pl.tdo.TsUserBean;

public class RegDaoImpl extends BaseDao implements RegDao {

	public TsUserBean insert(TsUserBean tsUser) throws PlException {
		tsUser.setUserId(IDFactory.getId());
		return (TsUserBean) super.insert("Reg.insert",tsUser);
	}

	public String isExisted(String username) {
		return (String) super.selectOne("Reg.checkByUsername", username);
	}

}
