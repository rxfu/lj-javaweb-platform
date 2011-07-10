package com.pl.web.a.group;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
import com.pl.service.ProductService;
import com.pl.tdo.TpProductBean;

/**
 * 用户注册
 * 
 * @author 熊庆春
 * 
 */
@Result(name = "input", location = "product-preSave.jsp")
public class GroupAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	private String groupId;

	@Override
	public String list() {
		List<TpProductBean> reList = productService.listByGroup(groupId);
		setRequestVal("reList", reList);
		return super.list();
	}

	// //////////////////////////////////////////////////////



	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public ProductService getProductService() {
		return productService;
	}

	

}
