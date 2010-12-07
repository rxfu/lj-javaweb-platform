package com.pl.web.w.reg;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.pl.common.base.BaseAction;

@ParentPackage("json-default")
@Result(name = "success",type = "json")
public class JsonUserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String flag;
	private String username;
	public String jsonUserExisted() throws Exception {
		RegService regService = (RegService) this.getSpringBean("regService");
		
		this.flag = regService.isExisted(username);
		System.out.println(flag);
		return "success";
	}
	// //////////////////////////
	@JSON(name = "flag")
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

}
