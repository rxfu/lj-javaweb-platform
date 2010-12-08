package com.pl.web.a.product;

import java.util.List;

import com.pl.common.pager.Pager;


/**
 * @author 熊庆春
 *
 */

public interface ProductDao
{
	public void add(TpProduct tpProduct) ;
	public List<TpProduct> selectPager(TpProduct tpProduct, Pager pager);
}
