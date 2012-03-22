package com.pl.web.a.group;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;
import com.pl.exception.PlException;
import com.pl.service.GroupService;
import com.pl.service.ProductService;
import com.pl.tdo.TpPdgroupBean;
import com.pl.tdo.TpProductBean;

/**
 * 产品组管理
 * 
 * @author 熊庆春
 * 
 */
@Result(name = "input", location = "product-preSave.jsp")
public class GroupAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Pager pager;
	private ProductService productService;
	private GroupService groupService;
	private TpProductBean tpProductBean;
	private TpPdgroupBean tpPdgroupBean;
	private String actionType;
	private List<String> productIds;

	@Override
	public String list() {
		if (null == pager) {
			pager = new Pager();
		}
		if (!isFirst()) {
			List<TpProductBean> reList = productService.listByGroup(tpProductBean.getGroupId(),pager);
			setRequestVal("reList", reList);
		}
		return super.list();
	}
	@Override
	public String edit() {
		if("edit".equals(actionType)){
			
		}else if("add".equals(actionType)){
			
		}else if("del".equals(actionType)){
			
		}else{
			new PlException("无法识别的actionType"+actionType);
		}
		if (null == pager) {
			pager = new Pager();
		}
		List<TpProductBean> reList = productService.listByGroup(tpProductBean.getGroupId(),pager);
		setRequestVal("reList", reList);
		return super.list();
	}
	////////////////////////////////////////////////////////

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public TpProductBean getTpProductBean() {
		return tpProductBean;
	}

	public void setTpProductBean(TpProductBean tpProductBean) {
		this.tpProductBean = tpProductBean;
	}

	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public List<String> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<String> productIds) {
		this.productIds = productIds;
	}
	public GroupService getGroupService() {
		return groupService;
	}
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	public TpPdgroupBean getTpPdgroupBean() {
		return tpPdgroupBean;
	}
	public void setTpPdgroupBean(TpPdgroupBean tpPdgroupBean) {
		this.tpPdgroupBean = tpPdgroupBean;
	}
	
}
