package com.pl.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.common.pager.Pager;
import com.pl.common.util.IDFactory;
import com.pl.dao.ProductDao;
import com.pl.exception.PlException;
import com.pl.tdo.TpProductBean;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	public TpProductBean insert(TpProductBean tpProduct) throws PlException {
		tpProduct.setProductId(IDFactory.getId());
		return (TpProductBean) super.insert("Product.insert",tpProduct);
	}

	@SuppressWarnings("unchecked")
	public List<TpProductBean> selectPager(TpProductBean tpProduct, Pager pager) {
		return (List<TpProductBean>) super.selectPager("Product.selectPager",tpProduct, pager);
	}

	public int update(TpProductBean tpProduct) throws SQLException {
		tpProduct.setImagfile(null);
		return super.update("Product.update",tpProduct);
	}

	public TpProductBean selectOneById(String productId) {
		return (TpProductBean) super.selectOne("Product.selectOneById",productId);
	}

	public void deleteById(String productId) throws SQLException {
		super.deleteById("Product.deleteById",productId);
	}
	@SuppressWarnings("unchecked")
	public List<TpProductBean> selectByGroupId(String groupId,int maxNum) {
		return (List<TpProductBean>) super.selectList("Product.selectByGroup", groupId,0,maxNum);
	}
	@SuppressWarnings("unchecked")
	public List<TpProductBean> selectInGroupId(String groupId) {
		return (List<TpProductBean>) super.selectList("Product.selectInGroupId", groupId);
	}
	
	

}
