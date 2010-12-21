package com.pl.web.w.pd;

import java.util.List;

import com.pl.web.a.product.TpProduct;



/**
 * @author 熊庆春
 *
 */

public interface PdDao
{
	public List<TpProduct> selectByGroupId(String groupId,int maxNum);
}
