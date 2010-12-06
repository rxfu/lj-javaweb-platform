package com.pl.common.base;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Service的抽象类，用户规范Service的格式。
 * 所有的Service必须继承自此类。
 * @author 熊庆春
 *
 */
public abstract class BaseService extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	protected static  Log log;
	public BaseService(){
		log   =  LogFactory.getLog(this.getClass().getName()); 
	}
	/**
	 * 查询列表
	 * @return 返回列表
	 */
	public abstract List<?> list();
	/**
	 * 添加前的准备
	 * @return
	 */
	public abstract Object preAdd();
	/**
	 * 添加
	 * @return
	 */
	public abstract void add();
	/**
	 * 修改前的准备
	 * @return
	 */
	public abstract Object preEdit();
	/**
	 * 修改
	 * @return
	 */
	public abstract void edit();
	/**
	 * 单个删除
	 * @return
	 */
	public abstract void deleteOne();
	/**
	 * 多个删除
	 * @return 删除数量
	 */
	public abstract int deleteSelect();
}
