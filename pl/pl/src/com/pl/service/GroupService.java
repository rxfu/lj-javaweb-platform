package com.pl.service;

import java.util.List;

import com.pl.tdo.TpProductBean;

/**
 * @author 熊庆春
 *
 */

public interface GroupService
{
	public void addPdGrpup(TpProductBean tpProductBean, List<String> productIds);
	public void delPdGrpup(TpProductBean tpProductBean, List<String> productIds);
	public void editPdGrpup(TpProductBean tpProductBean, List<String> productIds);
}
