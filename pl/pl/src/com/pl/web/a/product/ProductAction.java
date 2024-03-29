package com.pl.web.a.product;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;
import com.pl.service.ProductService;
import com.pl.tdo.TpProductBean;

/**
 * 产品管理
 * 
 * @author 熊庆春
 * 
 */
@Result(name = "input", location = "product-preSave.jsp")
@InterceptorRefs({
		@InterceptorRef(value = "fileUpload", params = { "allowedTypes",
				"image/bmp,image/png,image/gif,image/JPEG,image/jpeg,image/JPG,image/jpg,image/x-png,image/pjpeg",
				"maximumSize", "20971520" }),
		@InterceptorRef(value = "defaultStack")
		})
public class ProductAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ProductAction.class);
	private ProductService productService;
	private Pager pager;
	private TpProductBean tpProduct;

	@Override
	public String preSave() {
		if (isUpdate()) {
			this.tpProduct = productService.selectOneById(tpProduct
					.getProductId());
		}
		return PRESAVE;
	}

	@Override
	public String save() {
		try {
			if (isInsert()) {
				productService.add(tpProduct);
				return this.list();
			} else if (isUpdate()) {
				productService.edit(tpProduct);
				return PRESAVE;
			} else {
				log.error("产品保存失败：" + SAVEEXCEPTIONSTRINT);
				this.addActionError("产品保存失败：" + SAVEEXCEPTIONSTRINT);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("产品保存失败：" + e.getMessage());
			this.addActionError("产品保存失败：" + e.getMessage());
		}
		return PRESAVE;
	}

	@Override
	public String list() {
		if (null == pager) {
			pager = new Pager();
		}
		if (!isFirst()) {
			List<TpProductBean> reList = productService.list(tpProduct, pager);
			setRequestVal("reList", reList);
		}
		return super.list();
	}

	// //////////////////////////////////////////////////////

	@Override
	public String deleteOne() {
		try {
			productService.deleteOne(tpProduct.getProductId());
			this.addActionMessage("产品删除成功：已经删除的产品Id为："
					+ tpProduct.getProductId());
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("产品删除失败：" + e.getMessage());
			this.addActionError("产品删除失败：" + e.getMessage());
		}
		return this.list();
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public TpProductBean getTpProduct() {
		return tpProduct;
	}

	public void setTpProduct(TpProductBean tpProduct) {
		this.tpProduct = tpProduct;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
