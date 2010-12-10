package com.pl.web.a.product.impl;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.common.pager.Pager;
import com.pl.common.util.IDFactory;
import com.pl.exception.PlException;
import com.pl.web.a.product.ProductDao;
import com.pl.web.a.product.TpProduct;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	public void add(TpProduct tpProduct) throws PlException {
		tpProduct.setProductId(IDFactory.getId());
		super.insert(tpProduct);
	}

	@SuppressWarnings("unchecked")
	public List<TpProduct> selectPager(TpProduct tpProduct, Pager pager) {
		return super.selectPager(tpProduct, pager);
	}

	public TpProduct insert(TpProduct tpProduct) {
		return (TpProduct) super.insert(tpProduct);
	}

	public int update(TpProduct tpProduct) throws SQLException {
		return super.update(tpProduct);
	}

	public TpProduct selectOneById(String productId) {
		return (TpProduct) super.selectOneById(productId);
	}
	

}
