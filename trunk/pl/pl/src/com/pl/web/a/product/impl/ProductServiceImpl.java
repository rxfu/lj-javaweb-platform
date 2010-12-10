package com.pl.web.a.product.impl;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.base.BaseService;
import com.pl.common.pager.Pager;
import com.pl.exception.PlException;
import com.pl.web.a.product.ProductDao;
import com.pl.web.a.product.ProductService;
import com.pl.web.a.product.TpProduct;

public class ProductServiceImpl extends BaseService implements ProductService {

	private ProductDao productDao;

	public void add(TpProduct tpProduct) throws PlException {
		productDao.add(tpProduct);
	}

	public List<TpProduct> list(TpProduct tpProduct, Pager pager) {
		return productDao.selectPager(tpProduct, pager);
	}

	public void edit(TpProduct tpProduct) throws SQLException {
		productDao.update(tpProduct);
	}

	public TpProduct selectOneById(String productId) {
		return productDao.selectOneById(productId);
	}
	// //////////////////////////////////////////////


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
