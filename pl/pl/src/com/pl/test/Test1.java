package com.pl.test;

public class Test1 {
	
	/**
	 * 增加換行字符串
	 * @param str
	 * @param len
	 * @return
	 */
	public String setWrapLine(String str ,int len){
		String strTemp = "";
		int temp = 0;
		for (int i = len; i < str.length(); i=i+len) {
			strTemp += str.substring(i-len,i)+"\r\n";
			temp = i;
		}
		strTemp +=str.substring(temp,str.length());
		return strTemp;
		
	}
	/**
	 * 測試
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "12345678901234567890";
		System.out.println(new Test1().setWrapLine(str, 2));
	}
}
