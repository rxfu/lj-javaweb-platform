package com.pl.common.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Action的抽象类，用户规范Action的格式。
 * 所有的Action必须继承自此类。
 * @author 熊庆春
 */
public abstract class BaseAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	protected static  Log log;
	public BaseAction(){
		log   =  LogFactory.getLog(this.getClass().getName()); 
	}
	
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
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	/**
	 * 从Request获取值
	 * @param val Request取值key
	 * @return
	 */
	protected Object getRequestVal(String val){
		return ServletActionContext.getRequest().getAttribute(val);
	}
	/**
	 * 往Request保存值
	 * @param val key值
	 * @param object 要保存的值
	 */
	protected void setRequestVal(String val,Object object){
		ServletActionContext.getRequest().setAttribute(val, object);
	}
	protected HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	/**
	 * 从Session获取值
	 * @param val Session取值key
	 * @return
	 */
	protected Object getSessionVal(String val){
		String userId = (String)ServletActionContext.getRequest().getSession().getAttribute("userId");
		return ServletActionContext.getRequest().getSession().getAttribute(userId+val);
	}
	/**
	 * 往Session保存值
	 * @param val key值
	 * @param object 要保存的值
	 */
	protected void setSessionVal(String val,Object object){
		String userId = (String)ServletActionContext.getRequest().getSession().getAttribute("userId");
		ServletActionContext.getRequest().getSession().setAttribute(userId+val,object);
	}
	/**
	 * 从Spring中获取bean
	 * @param beanId beanId
	 * @return 返回bean对象
	 */
	protected Object getSpringBean(String beanId){
		WebApplicationContext ctx  = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getSession().getServletContext());
		return ctx.getBean(beanId);
	}
	
}
