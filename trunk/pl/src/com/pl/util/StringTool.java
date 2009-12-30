package com.pl.util;

public class StringTool {
	/**
	 * 判断str 是否为null或"";
	 * @param str
	 * @return 
	 */
	public static boolean isEmpty(String str) {
		if(null==str||"".equals(str)){
			return true;
		}else{
			return false;
		}
		
	}

}
