package com.pl.web.a.product;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;

/**
 * 用户注册
 * @author 熊庆春
 *
 */

public class ProductAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private static final  Log log = LogFactory.getLog(ProductAction.class);
	private ProductService productService;
	private Pager pager;
	private TpProduct tpProduct;
	
	@Override
	public String preSave() {
		if(isUpdate()){
			this.tpProduct = productService.selectOneById(tpProduct.getProductId());
		}
		return PRESAVE;
	}

	@Override
	public String save() {
		try {
			if(isInsert()){
				productService.add(tpProduct);
				return this.list();
			}else if(isUpdate()){
				productService.edit(tpProduct);
				return PRESAVE;
			}else{
				log.error("产品保存失败："+SAVEEXCEPTIONSTRINT);
				this.addActionError("产品保存失败："+SAVEEXCEPTIONSTRINT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("产品保存失败："+e.getMessage());
			this.addActionError("产品保存失败："+e.getMessage());
		}
		return PRESAVE;
	}

	@Override
	public String list() {
		if(null == pager){
			pager = new Pager();
		}
		if(!isFirst()){
			List<TpProduct> reList = productService.list(tpProduct,pager);
			setRequestVal("reList",reList);
		}
		return super.list();
	}
	
	////////////////////////////////////////////////////////

	@Override
	public String deleteOne() {
		try {
			productService.deleteOne(tpProduct.getProductId());
			this.addActionMessage("产品删除成功：已经删除的产品Id为："+tpProduct.getProductId());
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("产品删除失败："+e.getMessage());
			this.addActionError("产品删除失败："+e.getMessage());
		}
		return this.list();
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public TpProduct getTpProduct() {
		return tpProduct;
	}

	public void setTpProduct(TpProduct tpProduct) {
		this.tpProduct = tpProduct;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}



}
