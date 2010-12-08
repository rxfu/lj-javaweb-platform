package com.pl.web.a.product.impl;

import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.web.a.product.ProductDao;
import com.pl.web.a.product.ProductService;
import com.pl.web.a.product.TpProduct;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	public void add(TpProduct tpProduct) {
		productDao.add(tpProduct);
	}
	public List<TpProduct> list(TpProduct tpProduct,Pager pager){
		return productDao.selectPager(tpProduct, pager);
	}
	////////////////////////////////////////////////

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	

}
