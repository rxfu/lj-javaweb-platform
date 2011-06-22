package com.pl.service;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.tdo.TpProductBean;


/**
 * @author 熊庆春
 *
 */

public interface ProductService
{
	public void add(TpProductBean tpProduct) throws Exception;
	public void edit(TpProductBean tpProduct) throws Exception;
	public List<TpProductBean> list(TpProductBean tpProduct,Pager pager);
	public TpProductBean selectOneById(String productId);
	public void deleteOne(String productId) throws SQLException;
	public TpProductBean searchById(String productId);
}
