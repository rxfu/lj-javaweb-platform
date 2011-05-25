package com.pl.web.a.product.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pl.common.base.BaseService;
import com.pl.common.pager.Pager;
import com.pl.common.util.FileUploadUtil;
import com.pl.web.a.product.ProductDao;
import com.pl.web.a.product.ProductService;
import com.pl.web.a.product.TpProduct;

public class ProductServiceImpl extends BaseService implements ProductService {

	private ProductDao productDao;

	public void add(TpProduct tpProduct) throws Exception {
		if(!StringUtils.isEmpty(tpProduct.getImagfileFileName())){
			String fileName = new FileUploadUtil().saveFile(tpProduct.getImagfile(),tpProduct.getImagfileFileName());
			tpProduct.setImagfileFileName(fileName);
		}
		productDao.insert(tpProduct);
	}

	public List<TpProduct> list(TpProduct tpProduct, Pager pager) {
		return productDao.selectPager(tpProduct, pager);
	}

	public void edit(TpProduct tpProduct) throws Exception {
		if(!StringUtils.isEmpty(tpProduct.getImagfileFileName())){
			String fileName = new FileUploadUtil().saveFile(tpProduct.getImagfile(),tpProduct.getImagfileFileName());
			tpProduct.setImagfileFileName(fileName);
		}
		productDao.update(tpProduct);
	}

	public TpProduct selectOneById(String productId) {
		return productDao.selectOneById(productId);
	}
	public void deleteOne(String productId) throws SQLException {
		productDao.deleteById(productId);
	}
	// //////////////////////////////////////////////




	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}