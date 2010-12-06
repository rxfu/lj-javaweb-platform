package com.pl.web.w.reg;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;

import com.pl.common.base.BaseAction;

@ParentPackage("json-default")
@Result(type = "json", name = "test")
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String flag;
	private String username;

	public String test() throws Exception {
		this.flag = username;

		return "test";
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
