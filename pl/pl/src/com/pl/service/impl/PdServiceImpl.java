package com.pl.service.impl;

import java.util.List;

import com.pl.common.base.BaseService;
import com.pl.dao.PdDao;
import com.pl.dao.ProductDao;
import com.pl.service.PdService;
import com.pl.tdo.TpProductBean;

public class PdServiceImpl extends BaseService implements PdService {
	private PdDao pdDao;
	private ProductDao productDao;
	public List<TpProductBean> listByGroup(String groupId,int maxNum) {
		return pdDao.selectByGroupId(groupId,maxNum);
	}
	public TpProductBean searchById(String productId) {
		return productDao.selectOneById(productId);
	}
	
	public void setPdDao(PdDao pdDao) {
		this.pdDao = pdDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
