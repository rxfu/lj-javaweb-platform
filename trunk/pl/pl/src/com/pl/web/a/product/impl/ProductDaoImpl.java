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
	public TpProduct insert(TpProduct tpProduct) throws PlException {
		tpProduct.setProductId(IDFactory.getId());
		return (TpProduct) super.insert("Product.insert",tpProduct);
	}

	@SuppressWarnings("unchecked")
	public List<TpProduct> selectPager(TpProduct tpProduct, Pager pager) {
		return (List<TpProduct>) super.selectPager("Product.selectPager",tpProduct, pager);
	}

	public int update(TpProduct tpProduct) throws SQLException {
		tpProduct.setImagfile(null);
		return super.update("Product.update",tpProduct);
	}

	public TpProduct selectOneById(String productId) {
		return (TpProduct) super.selectOne("Product.selectOneById",productId);
	}

	public void deleteById(String productId) throws SQLException {
		super.deleteById("Product.deleteById",productId);
	}

	
	

}
