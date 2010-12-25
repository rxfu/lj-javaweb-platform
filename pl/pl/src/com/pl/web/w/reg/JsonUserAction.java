package com.pl.web.w.reg;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;
/**
 * 注释jsonAction中不能出现非String的成员变量的get方法，否则json回调函数无法执行(原因为非基本数据类型的成员无法生产json的字符串)
 * @author 熊庆春
 */
@ParentPackage("json-default")
@Result(name = "success",type = "json")
public class JsonUserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String flag;
	private String username;
	private RegService regService;
	public String jsonUserExisted() throws Exception {
//		RegService regService = (RegService) this.getSpringBean("regService");
		this.flag = regService.isExisted(username);
		return "success";
	}
	// //////////////////////////
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setRegService(RegService regService) {
		this.regService = regService;
	}

}
