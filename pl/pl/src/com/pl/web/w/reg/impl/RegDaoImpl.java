package com.pl.web.w.reg.impl;

import com.pl.common.base.BaseDao;
import com.pl.common.util.IDFactory;
import com.pl.web.w.reg.RegDao;
import com.pl.web.w.reg.TsUser;

public class RegDaoImpl extends BaseDao implements RegDao {

	public TsUser insert(TsUser tsUser) throws InterruptedException {
		tsUser.setUserId(IDFactory.getId());
		return (TsUser) super.insert(tsUser);
	}

}
