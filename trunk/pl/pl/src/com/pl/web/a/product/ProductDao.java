package com.pl.web.a.product;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.exception.PlException;


/**
 * @author 熊庆春
 *
 */

public interface ProductDao
{
	public List<TpProduct> selectPager(TpProduct tpProduct, Pager pager);
	public TpProduct insert(TpProduct tpProduct) throws PlException ;
	public int update(TpProduct tpProduct) throws SQLException;
	public TpProduct selectOneById(String productId);
	public void deleteById(String productId) throws SQLException;
}
