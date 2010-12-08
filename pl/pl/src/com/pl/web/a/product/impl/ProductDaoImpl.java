package com.pl.web.a.product.impl;

import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.common.pager.Pager;
import com.pl.web.a.product.ProductDao;
import com.pl.web.a.product.TpProduct;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	public void add(TpProduct tpProduct) {
		super.insert(tpProduct);
	}

	@SuppressWarnings("unchecked")
	public List<TpProduct> selectPager(TpProduct tpProduct, Pager pager) {
		return super.selectPager(tpProduct, pager);
	}
	

}
