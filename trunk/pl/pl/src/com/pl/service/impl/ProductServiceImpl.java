package com.pl.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.pl.common.base.BaseService;
import com.pl.common.pager.Pager;
import com.pl.common.util.FileUploadUtil;
import com.pl.dao.ProductDao;
import com.pl.service.ProductService;
import com.pl.tdo.TpProductBean;

public class ProductServiceImpl extends BaseService implements ProductService {

	private ProductDao productDao;

	public void add(TpProductBean tpProduct) throws Exception {
		if(!StringUtils.isEmpty(tpProduct.getImagfileFileName())){
			String fileName = new FileUploadUtil().saveFile(tpProduct.getImagfile(),tpProduct.getImagfileFileName());
			tpProduct.setImagfileFileName(fileName);
		}
		productDao.insert(tpProduct);
	}

	public List<TpProductBean> list(TpProductBean tpProduct, Pager pager) {
		return productDao.selectPager(tpProduct, pager);
	}

	public void edit(TpProductBean tpProduct) throws Exception {
		if(!StringUtils.isEmpty(tpProduct.getImagfileFileName())){
			String fileName = new FileUploadUtil().saveFile(tpProduct.getImagfile(),tpProduct.getImagfileFileName());
			tpProduct.setImagfileFileName(fileName);
		}
		productDao.update(tpProduct);
	}

	public TpProductBean selectOneById(String productId) {
		return productDao.selectOneById(productId);
	}
	public void deleteOne(String productId) throws SQLException {
		productDao.deleteById(productId);
	}
	public TpProductBean searchById(String productId) {
		return productDao.selectOneById(productId);
	}
	// //////////////////////////////////////////////




	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
