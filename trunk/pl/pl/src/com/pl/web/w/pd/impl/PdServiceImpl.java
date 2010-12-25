package com.pl.web.w.pd.impl;

import java.util.List;

import com.pl.common.base.BaseService;
import com.pl.web.a.product.ProductDao;
import com.pl.web.a.product.TpProduct;
import com.pl.web.w.pd.PdDao;
import com.pl.web.w.pd.PdService;

public class PdServiceImpl extends BaseService implements PdService {
	private PdDao pdDao;
	private ProductDao productDao;
	public List<TpProduct> listByGroup(String groupId,int maxNum) {
		return pdDao.selectByGroupId(groupId,maxNum);
	}
	public TpProduct searchById(String productId) {
		return productDao.selectOneById(productId);
	}
	
	public void setPdDao(PdDao pdDao) {
		this.pdDao = pdDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
