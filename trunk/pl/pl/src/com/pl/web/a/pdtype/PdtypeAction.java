/**
 * 产品类别管理
 */
package com.pl.web.a.pdtype;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
import com.pl.service.PdtypeService;
import com.pl.tdo.PdtypeBean;


/**
 * 产品类别管理
 * 
 * @author 符荣鑫
 *
 */
@Result(name="input", location="product-preSave.jsp")
public class PdtypeAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(PdtypeAction.class);
	private PdtypeService pdtypeService;
	private List<PdtypeBean> pdTypes;
	
	@Override
	public String preSave() {
		// TODO Auto-generated method stub
		if (isUpdate()) {
			this.pdTypes = pdtypeService.getCurrentAllPdtype();
		}
		return super.preSave();
	}

}
