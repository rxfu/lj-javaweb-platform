/**
 * 产品类别管理
 */
package com.pl.web.a.pdtype;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;
import com.pl.service.PdtypeService;
import com.pl.tdo.PdtypeBean;


/**
 * 产品类别管理
 * 
 * @author 符荣鑫
 *
 */
@Result(name = "input", location = "pdtype-preSave.jsp")
public class PdtypeAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(PdtypeAction.class);
	private PdtypeService pdtypeService;
	private PdtypeBean pdType;
	private Pager pager;
	
	@Override
	public String list() {
		// TODO Auto-generated method stub
		if (null == pager) {
			pager = new Pager();
		}
		if (! isFirst()) {
			List<PdtypeBean> reList = pdtypeService.getCurrentAllPdtype();
			setRequestVal("reList", reList);
		}
		return super.list();
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		try {
			if (isInsert()) {
				pdtypeService.add(pdType);
				return this.list();
			} else if (isUpdate()) {
				pdtypeService.edit(pdType);
				return PRESAVE;
			} else {
				log.error("类别保存失败：" + SAVEEXCEPTIONSTRINT);
				this.addActionError("类别保存失败：" + SAVEEXCEPTIONSTRINT);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("类别保存失败：" + e.getMessage());
			this.addActionError("类别保存失败：" + e.getMessage());
		}
		return PRESAVE;
//		return super.save();
	}

	public PdtypeService getPdtypeService() {
		return pdtypeService;
	}

	public void setPdtypeService(PdtypeService pdtypeService) {
		this.pdtypeService = pdtypeService;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
