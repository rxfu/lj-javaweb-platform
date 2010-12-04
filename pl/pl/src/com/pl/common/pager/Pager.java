package com.pl.common.pager;

import javax.transaction.SystemException;

public class Pager {
	/**
	 * 页开始记录数
	 */
	int offset ;
	/**
	 * 页最大记录数
	 */
	int maxPageItems = 3;
	/**
	 * 总记录数， 默认9999
	 */
	int items = 9999;
	/**
	 * 用总“记录数”，“最大记录数”计算出“最大页开始记录数”
	 * @return
	 */
	public int getMaxOffset(){
		if(maxPageItems==0){
			new SystemException("页最大记录数不能为0");
		}
		int mod = items%maxPageItems;
		if(mod == 0){
			return items-maxPageItems;
		}else{
			return items-mod;
		}
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public int getMaxPageItems() {
		return maxPageItems;
	}
	public void setMaxPageItems(int maxPageItems) {
		this.maxPageItems = maxPageItems;
	}
	
	
	
}
