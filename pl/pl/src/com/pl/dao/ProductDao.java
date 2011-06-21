package com.pl.dao;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.exception.PlException;
import com.pl.tdo.TpProductBean;


/**
 * @author 熊庆春
 *
 */

public interface ProductDao
{
	public List<TpProductBean> selectPager(TpProductBean tpProduct, Pager pager);
	public TpProductBean insert(TpProductBean tpProduct) throws PlException ;
	public int update(TpProductBean tpProduct) throws SQLException;
	public TpProductBean selectOneById(String productId);
	public void deleteById(String productId) throws SQLException;
}
