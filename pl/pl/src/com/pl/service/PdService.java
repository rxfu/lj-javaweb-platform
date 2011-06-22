package com.pl.service;

import java.util.List;

import com.pl.tdo.TpProductBean;


/**
 * @author 熊庆春
 *
 */

public interface PdService
{
	public List<TpProductBean> listByGroup(String groupId,int maxNum);
}
