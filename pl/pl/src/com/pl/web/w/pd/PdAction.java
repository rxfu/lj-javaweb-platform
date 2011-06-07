package com.pl.web.w.pd;

import java.util.List;

import com.pl.common.base.BaseAction;
import com.pl.web.a.product.TpProduct;
import com.pl.web.w.pdtype.Pdtype;


public class PdAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private TpProduct tpProduct;
	private String groupId;
	private List<TpProduct> reList;
	private PdService pdService;
	private Pdtype pdType;
	
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
	public List<TpProduct> getReList() {
		return reList;
	}
	public void setReList(List<TpProduct> reList) {
		this.reList = reList;
	}
	public TpProduct getTpProduct() {
		return tpProduct;
	}
	public void setTpProduct(TpProduct tpProduct) {
		this.tpProduct = tpProduct;
	}
}