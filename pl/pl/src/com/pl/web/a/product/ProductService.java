package com.pl.web.a.product;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;


/**
 * @author 熊庆春
 *
 */

public interface ProductService
{
	public void add(TpProduct tpProduct) throws Exception;
	public void edit(TpProduct tpProduct) throws Exception;
	public List<TpProduct> list(TpProduct tpProduct,Pager pager);
	public TpProduct selectOneById(String productId);
	public void deleteOne(String productId) throws SQLException;
}
