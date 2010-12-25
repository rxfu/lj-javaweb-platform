package com.pl.web.w.pd;

import java.util.List;

import com.pl.web.a.product.TpProduct;


/**
 * @author 熊庆春
 *
 */

public interface PdService
{
	public List<TpProduct> listByGroup(String groupId,int maxNum);
	public TpProduct searchById(String productId);

}
