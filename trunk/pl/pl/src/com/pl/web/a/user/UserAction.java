package com.pl.web.a.user;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Result;
import com.pl.common.base.BaseAction;
import com.pl.common.pager.Pager;
import com.pl.service.RegService;
import com.pl.tdo.TsUserBean;

/**
 * 用户管理
 * 
 * @author 符荣鑫
 *
 */
@Result(name= "input", location = "user-preSave.jsp")
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UserAction.class);
	private RegService regService;
	private Pager pager;
	private TsUserBean tsUser;

	@Override
	public String list() {
		// TODO Auto-generated method stub
		if (null == pager) {
			pager = new Pager();
		}
		if (!isFirst()) {
			List<TsUserBean> reList = regService.list(tsUser, pager);
			setRequestVal("reList", reList);
		}
		return super.list();
	}
	
	@Override
	public String deleteOne() {
		// TODO Auto-generated method stub
		try {
			regService.deleteOne(tsUser.getUserId());
			this.addActionMessage("产品删除成功：已经删除的产品Id为："
					+ tsUser.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("产品删除失败：" + e.getMessage());
			this.addActionError("产品删除失败：" + e.getMessage());
		}
		return this.list();
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		try {
			if (isUpdate()) {
				regService.edit(tsUser);
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

	public RegService getRegService() {
		return regService;
	}

	public void setRegService(RegService regService) {
		this.regService = regService;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public TsUserBean getTsUser() {
		return tsUser;
	}

	public void setTsUser(TsUserBean tsUser) {
		this.tsUser = tsUser;
	}

}
