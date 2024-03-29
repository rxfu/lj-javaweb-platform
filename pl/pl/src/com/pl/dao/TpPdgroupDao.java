package com.pl.dao;

import java.sql.SQLException;
import java.util.List;

import com.pl.exception.PlException;
import com.pl.tdo.TpPdgroupBean;

/**
 * 产品组别关系DAO
 * @author 熊庆春
 *
 */
public interface TpPdgroupDao {
	/**
	 * 增加产品组别关系
	 * @param tpPdgroupBean
	 * @return
	 * @throws PlException
	 */
	public int insert(List<TpPdgroupBean> list) throws SQLException ;
	/**
	 * 删除产品组别关系
	 * @param productId
	 * @return
	 * @throws SQLException 
	 */
	public int delete(List<TpPdgroupBean> list) throws SQLException ;
}