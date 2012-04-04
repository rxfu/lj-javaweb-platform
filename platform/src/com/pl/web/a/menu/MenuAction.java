package com.pl.web.a.menu;

import com.pl.common.base.BaseAction;
import com.pl.service.ProductService;
import com.pl.sys.SysContexts;

/**
 * 菜单管理
 * @author 熊庆春
 *
 */

public class MenuAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private ProductService productService;

	@Override
	public String list() {
		SysContexts.groupList1 = productService.listByGroup("1", 10);
		SysContexts.groupList2 = productService.listByGroup("2", 10);
		SysContexts.groupList3 = productService.listByGroup("3", 10);
		SysContexts.groupList4 = productService.listByGroup("4", 10);
		return super.list();
	}
	//get set	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	
}
