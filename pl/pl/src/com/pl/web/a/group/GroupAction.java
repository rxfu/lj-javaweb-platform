package com.pl.web.a.group;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
import com.pl.service.ProductService;

/**
 * 用户注册
 * 
 * @author 熊庆春
 * 
 */
@Result(name = "input", location = "product-preSave.jsp")
public class GroupAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(GroupAction.class);
	private ProductService productService;

	@Override
	public String list() {
//		if (!isFirst()) {
//			List<TpProductBean> reList = productService.list);
//			setRequestVal("reList", reList);
//		}
		return super.list();
	}

	// //////////////////////////////////////////////////////



	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	

}
