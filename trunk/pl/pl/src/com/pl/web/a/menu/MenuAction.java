package com.pl.web.a.menu;

import com.pl.common.base.BaseAction;
import com.pl.sys.SysContexts;
import com.pl.web.w.pd.PdService;

/**
 * 用户注册
 * @author 熊庆春
 *
 */

public class MenuAction extends BaseAction
{
	private static final long serialVersionUID = 1L;
	private PdService pdService;

	@Override
	public String list() {
		SysContexts.groupList1 = pdService.listByGroup("1", 10);
		SysContexts.groupList2 = pdService.listByGroup("2", 10);
		SysContexts.groupList3 = pdService.listByGroup("3", 10);
		SysContexts.groupList4 = pdService.listByGroup("4", 10);
		return super.list();
	}

	public PdService getPdService() {
		return pdService;
	}

	public void setPdService(PdService pdService) {
		this.pdService = pdService;
	}
	
	
	
}
