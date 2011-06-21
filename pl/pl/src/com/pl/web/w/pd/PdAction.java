package com.pl.web.w.pd;

import java.util.List;

import com.pl.common.base.BaseAction;
import com.pl.service.PdService;
import com.pl.tdo.PdtypeBean;
import com.pl.tdo.TpProductBean;


public class PdAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private TpProductBean tpProduct;
	private String groupId;
	private List<TpProductBean> reList;
	private PdService pdService;
	private PdtypeBean pdType;
	
	public String searchById(){
		tpProduct = pdService.searchById(tpProduct.getProductId());
		return "searchone";
	}
	public String listByGroup(){
		reList = pdService.listByGroup(String.valueOf(pdType.getSeq()), pdType.getChildrens().size());
		return "listgroup";
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
	public List<TpProductBean> getReList() {
		return reList;
	}
	public void setReList(List<TpProductBean> reList) {
		this.reList = reList;
	}
	public TpProductBean getTpProduct() {
		return tpProduct;
	}
	public void setTpProduct(TpProductBean tpProduct) {
		this.tpProduct = tpProduct;
	}
}