package com.pl.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pl.dao.PdtypeDao;
import com.pl.service.PdtypeService;
import com.pl.tdo.PdtypeBean;

public class PdtypeServiceImpl implements PdtypeService {
	PdtypeDao pdtypeDao;
	public List<PdtypeBean> getCurrentAllPdtype() {
		PdtypeBean pdtypeTemp1 = new PdtypeBean();
		pdtypeTemp1.setLevel("1");
		List<PdtypeBean> list = new ArrayList<PdtypeBean>();
		//获取一级类型
		list = pdtypeDao.selectAllPdtypeByLevel(pdtypeTemp1);
		for (PdtypeBean pdtypeTemp2 : list) {
			pdtypeTemp2.setLevel("2");
			//获取二级类型
			List<PdtypeBean> childrens2 = pdtypeDao.selectAllPdtypeByLevel(pdtypeTemp2);
			pdtypeTemp2.setChildrens(childrens2);
			for (PdtypeBean pdtypeTemp3 : pdtypeTemp2.getChildrens()) {
				pdtypeTemp3.setLevel("3");
				//获取三级类型
				List<PdtypeBean> childrens3 = pdtypeDao.selectAllPdtypeByLevel(pdtypeTemp2);
				pdtypeTemp3.setChildrens(childrens3);
			}
		}
		return list;

	}
	/////////////////////////
	public void setPdtypeDao(PdtypeDao pdtypeDao) {
		this.pdtypeDao = pdtypeDao;
	}

}
