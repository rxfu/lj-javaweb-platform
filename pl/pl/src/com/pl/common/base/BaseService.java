package com.pl.common.base;

import java.util.List;
/**
 * Service的抽象类，用户规范Service的格式。
 * 所有的Service必须继承自此类。
 * @author 熊庆春
 *
 */
public class BaseService
{
	private static final long serialVersionUID = 1L;
	/**
	 * 查询列表
	 * @return 返回列表
	 */
	public List<?> list(){
		return null;
	}
	/**
	 * 添加前的准备
	 * @return
	 */
	public Object preAdd(){
		return null;
	}
	/**
	 * 添加
	 * @return
	 */
	public void add(){
	}
	/**
	 * 查询单个
	 * @return
	 */
	public Object selectOne(){
		return null;
	}
	/**
	 * 查询单个
	 * @return
	 */
	public Object selectOneById(){
		return null;
	}
	
	/**
	 * 修改前的准备
	 * @return
	 */
	public Object preEdit(){
		return null;
	}
	/**
	 * 修改
	 * @return
	 */
	public void edit(){
	}
	/**
	 * 单个删除
	 * @return
	 */
	public void deleteOne(){
	}
	/**
	 * 多个删除
	 * @return 删除数量
	 */
	public  int deleteSelect(){
		return 0;
	}
}
