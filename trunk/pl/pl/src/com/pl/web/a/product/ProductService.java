package com.pl.web.a.product;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.exception.PlException;


/**
 * @author 熊庆春
 *
 */

public interface ProductService
{
	public void add(TpProduct tpProduct) throws PlException;
	public void edit(TpProduct tpProduct) throws SQLException;
	public List<TpProduct> list(TpProduct tpProduct,Pager pager);
	public TpProduct selectOneById(String productId);
}
