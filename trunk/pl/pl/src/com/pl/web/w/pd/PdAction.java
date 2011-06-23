package com.pl.web.w.pd;

import java.util.List;

import com.pl.common.base.BaseAction;
import com.pl.service.ProductService;
import com.pl.tdo.PdtypeBean;
import com.pl.tdo.TpProductBean;


public class PdAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private TpProductBean tpProduct;
	private String groupId;
	private List<TpProductBean> reList;
	private ProductService productService;
	private PdtypeBean pdType;
	
	public String searchById(){
		tpProduct = productService.searchById(tpProduct.getProductId());
		return "searchone";
	}
	public String listByGroup(){
		reList = productService.listByGroup(String.valueOf(pdType.getSeq()), 10);
		return "searchgroup";
	}
	//
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
	public PdtypeBean getPdType() {
		return pdType;
	}
	public void setPdType(PdtypeBean pdType) {
		this.pdType = pdType;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}