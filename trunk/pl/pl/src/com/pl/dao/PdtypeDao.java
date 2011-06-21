package com.pl.dao;

import java.util.List;

import com.pl.tdo.PdtypeBean;

public interface PdtypeDao {
	public List<PdtypeBean> selectAllPdtypeByLevel(PdtypeBean pdtype);
}
