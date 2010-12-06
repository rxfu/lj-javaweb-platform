package com.pl.web.w.reg;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.pl.common.base.BaseAction;

@ParentPackage("json-default")   
@Result(type="json",name="test")   
public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String name = "fish119";

	 public String test() throws Exception{   
	     this.name += ": Test method!!";   
	         
	      return "test";   
	  }   


	 
	 ////////////////////////////////////
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		 

}
