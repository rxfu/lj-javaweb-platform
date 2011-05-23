package com.pl.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.pl.exception.PlException;

public class IDFactory {

	private static String iDtemp = "";

	private static final SimpleDateFormat formatter = new SimpleDateFormat(
			"yyMMddHHmmss");

	/**
	 * 获取ID
	 * @return
	 * @throws InterruptedException
	 */
	public static String getId() throws PlException {
		synchronized (formatter) {
			Calendar date = Calendar.getInstance();
			String strDate = formatter.format(date.getTime());
			while (strDate.equals(iDtemp)) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
					new PlException("IDFactory无法创建Id");
				}
				date = Calendar.getInstance();
				strDate = formatter.format(date.getTime());
				System.out.print("-");
			}
			iDtemp = strDate;
			return strDate;
		}
	}
}
