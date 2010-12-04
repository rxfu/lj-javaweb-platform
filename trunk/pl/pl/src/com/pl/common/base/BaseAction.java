package com.pl.common.base;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Action的抽象类，用户规范Action的格式。
 * 所有的Action必须继承自此类。
 * @author 熊庆春
 */
public abstract class BaseAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	/**
	 * 查询列表前的准备
	 */
	protected final static String PRELIST = "preList";
	/**
	 * 列表查询
	 */
	protected final static String LIST = "list";
	/**
	 * 添加前的准备
	 */
	protected final static String PREADD = "preAdd";
	/**
	 * 添加
	 */
	protected final static String ADD = "add";
	/**
	 * 修改前的准备
	 */
	protected final static String PREEDIT = "preEdit";
	/**
	 * 修改
	 */
	protected final static String EDIT = "edit";
	/**
	 * 删除一个
	 */
	protected final static String DELETEONE = "deleteOne";
	/**
	 * 删除多个
	 */
	protected final static String DELETESELECT = "deleteSelect";
	/**
	 * 查询列表前的准备
	 * @return
	 */
	public String preList(){
		return PRELIST;
	}
	/**
	 * 查询列表
	 * @return
	 */
	public String list(){
		return LIST;
	}
	/**
	 * 添加前的准备
	 * @return
	 */
	public String preAdd(){
		return PREADD;
	}
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		return ADD;
	}
	/**
	 * 修改前的准备
	 * @return
	 */
	public String preEdit(){
		return PREEDIT;
	}
	/**
	 * 修改
	 * @return
	 */
	public String edit(){
		return EDIT;
	}
	/**
	 * 单个删除
	 * @return
	 */
	public String deleteOne(){
		return DELETEONE;
	}
	/**
	 * 多个删除
	 * @return
	 */
	public String deleteSelect(){
		return DELETESELECT;
	}
	/**
	 * 从Request获取值
	 * @param val Request取值key
	 * @return
	 */
	public Object getRequestVal(String val){
		return ServletActionContext.getRequest().getAttribute(val);
	}
	/**
	 * 往Request保存值
	 * @param val key值
	 * @param object 要保存的值
	 */
	public void setRequestVal(String val,Object object){
		ServletActionContext.getRequest().setAttribute(val, object);
	}
	/**
	 * 从Session获取值
	 * @param val Session取值key
	 * @return
	 */
	public Object getSessionVal(String val){
		String userId = (String)ServletActionContext.getRequest().getSession().getAttribute("userId");
		return ServletActionContext.getRequest().getSession().getAttribute(userId+val);
	}
	/**
	 * 往Session保存值
	 * @param val key值
	 * @param object 要保存的值
	 */
	public void setSessionVal(String val,Object object){
		String userId = (String)ServletActionContext.getRequest().getSession().getAttribute("userId");
		ServletActionContext.getRequest().getSession().setAttribute(userId+val,object);
	}
}
