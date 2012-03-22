package com.pl.dao;

import java.util.List;

import com.pl.tdo.PdtypeBean;

public interface PdtypeDao {
	/**
	 * 根据商品类型获取商品列表
	 * @param pdtype
	 * @return
	 */
	public List<PdtypeBean> selectAllPdtypeByLevel(PdtypeBean pdtype);
}
