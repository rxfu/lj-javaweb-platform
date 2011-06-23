package com.pl.dao;

import java.sql.SQLException;

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
	public TpPdgroupBean insert(TpPdgroupBean tpPdgroupBean) throws PlException ;
	/**
	 * 删除产品组别关系
	 * @param productId
	 * @return
	 * @throws SQLException 
	 */
	public int delete(String productId) throws SQLException ;
}