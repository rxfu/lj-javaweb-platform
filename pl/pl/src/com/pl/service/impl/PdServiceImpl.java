package com.pl.service.impl;

import java.util.List;

import com.pl.common.base.BaseService;
import com.pl.dao.ProductDao;
import com.pl.service.PdService;
import com.pl.tdo.TpProductBean;

public class PdServiceImpl extends BaseService implements PdService {
	private ProductDao productDao;
	public List<TpProductBean> listByGroup(String groupId,int maxNum) {
		return productDao.selectByGroupId(groupId,maxNum);
	}

	
	public void setPdDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
