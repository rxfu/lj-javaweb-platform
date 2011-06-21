package com.pl.dao;

import java.util.List;

import com.pl.tdo.TpProductBean;



/**
 * @author 熊庆春
 *
 */

public interface PdDao
{
	public List<TpProductBean> selectByGroupId(String groupId,int maxNum);
}
