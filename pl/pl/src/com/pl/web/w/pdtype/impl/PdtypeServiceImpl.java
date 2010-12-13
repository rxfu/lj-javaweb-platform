package com.pl.web.w.pdtype.impl;

import java.util.ArrayList;
import java.util.List;

import com.pl.web.w.pdtype.Pdtype;
import com.pl.web.w.pdtype.PdtypeDao;
import com.pl.web.w.pdtype.PdtypeService;

public class PdtypeServiceImpl implements PdtypeService {
	PdtypeDao pdtypeDao;
	public List<Pdtype> getCurrentAllPdtype() {
		Pdtype pdtypeTemp1 = new Pdtype();
		pdtypeTemp1.setLevel("1");
		List<Pdtype> list = new ArrayList<Pdtype>();
		//获取一级类型
		list = pdtypeDao.selectAllPdtypeByLevel(pdtypeTemp1);
		for (Pdtype pdtypeTemp2 : list) {
			pdtypeTemp2.setLevel("2");
			//获取二级类型
			List<Pdtype> childrens2 = pdtypeDao.selectAllPdtypeByLevel(pdtypeTemp2);
			pdtypeTemp2.setChildrens(childrens2);
			for (Pdtype pdtypeTemp3 : pdtypeTemp2.getChildrens()) {
				pdtypeTemp3.setLevel("3");
				//获取三级类型
				List<Pdtype> childrens3 = pdtypeDao.selectAllPdtypeByLevel(pdtypeTemp2);
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
