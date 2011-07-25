package com.pl.dao;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.pager.Pager;
import com.pl.exception.PlException;
import com.pl.tdo.TsUserBean;


public interface RegDao {
	/**
	 * 增加用户
	 * @param tsUser
	 * @return
	 * @throws PlException
	 */
	public TsUserBean insert(TsUserBean tsUser) throws PlException;

	/**
	 * 判断用户是否存在
	 * @param username
	 * @return
	 */
	public String isExisted(String username);
	
	/**
	 * 分页查询用户
	 * @param tsUser
	 * @param pager
	 * @return
	 */
	public List<TsUserBean> selectPager(TsUserBean tsUser, Pager pager);
	
	/**
	 * 更新用户
	 * @param tsUser
	 * @return
	 * @throws SQLException
	 */
	public int update(TsUserBean tsUser) throws SQLException;
	
	/**
	 * 根据用户ID删除用户
	 * @param userId
	 * @throws SQLException
	 */
	public void deleteById(String userId) throws SQLException;
}
