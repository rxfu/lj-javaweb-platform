package com.pl.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IDFactory {

	private static String iDtemp = "";

	private static final SimpleDateFormat formatter = new SimpleDateFormat(
			"yyMMddHHmmssSSS");

	/**
	 * 获取ID
	 * @return
	 * @throws InterruptedException
	 */
	public static String getId() throws InterruptedException {
		synchronized (formatter) {
			Calendar date = Calendar.getInstance();
			String strDate = formatter.format(date.getTime());
			while (strDate.equals(iDtemp)) {
				Thread.sleep(10);
				date = Calendar.getInstance();
				strDate = formatter.format(date.getTime());
				System.out.print("-");
			}
			iDtemp = strDate;
			return strDate;
		}
	}
}
