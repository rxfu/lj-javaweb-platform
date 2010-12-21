package com.pl.web.w.pd;

import java.util.List;

import com.pl.common.base.BaseAction;
import com.pl.web.a.product.TpProduct;


public class PdAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String groupId;
	private List<TpProduct> reList;
	private PdService pdService;
	
	public String searchByGroup(){
		reList = pdService.listByGroup(groupId,16);
		return "group";
	}
	//
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public void setPdService(PdService pdService) {
		this.pdService = pdService;
	}
	public List<TpProduct> getReList() {
		return reList;
	}
	public void setReList(List<TpProduct> reList) {
		this.reList = reList;
	}
}