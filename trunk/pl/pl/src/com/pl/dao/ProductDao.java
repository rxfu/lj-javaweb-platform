package com.pl.dao;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.exception.PlException;
import com.pl.tdo.TpProductBean;


/**
 * @author 熊庆春
 *
 */

public interface ProductDao
{
	/**
	 * 分页查询商品
	 * @param tpProduct
	 * @param pager
	 * @return
	 */
	public List<TpProductBean> selectPager(TpProductBean tpProduct, Pager pager);
	/**
	 * 增加商品
	 * @param tpProduct
	 * @return
	 * @throws PlException
	 */
	public TpProductBean insert(TpProductBean tpProduct) throws PlException ;
	/**
	 * 更新商品
	 * @param tpProduct
	 * @return
	 * @throws SQLException
	 */
	
	public int update(TpProductBean tpProduct) throws SQLException;
	/**
	 * 更具商品ID查询商品
	 * @param productId
	 * @return
	 */
	public TpProductBean selectOneById(String productId);
	/**
	 * 根据商品ID删除商品
	 * @param productId
	 * @throws SQLException
	 */
	public void deleteById(String productId) throws SQLException;
	/**
	 * 根据商品组别及最大记录数查询商品列表
	 * @param groupId
	 * @param maxNum
	 * @return
	 */
	public List<TpProductBean> selectByGroupId(String groupId,int maxNum);
	/**
	 * 根据商品组查询商品列表
	 * @param groupId
	 * @return
	 */
	public List<TpProductBean> selectInGroupId(String groupId);
}
