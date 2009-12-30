package com.pl.util;
import org.apache.log4j.Logger;

public class PLLog {
	private static Logger log = Logger.getLogger("PL");;
	/**
	 * 写fatal级别日志
	 * @param name 类名
	 * @param info 日志信息
	 */
	public static void fatal(String name,String info) {
		log.fatal("["+name+"]---->"+info);
	}
	/**
	 *  写fatal级别日志
	 * @param cls 调用的类this
	 * @param info 日志信息
	 */
	public static void fatal(Object obj,String info) {
		fatal(obj.getClass().getName(),info);
	}
	/**
	 * 写info级别日志
	 * @param name 类名
	 * @param info 日志信息
	 */
	public static void info(String name,String info) {
		log.info("["+name+"]---->"+info);
	}
	/**
	 *  写info级别日志
	 * @param cls 调用的类this
	 * @param info 日志信息
	 */
	public static void info(Object obj,String info) {
		info(obj.getClass().getName(),info);
	}
	/**
	 * 写debug级别日志
	 * @param name 类名
	 * @param info 日志信息
	 */
	public static void debug(String name,String info) {
		log.debug("["+name+"]---->"+info);
	}
	/**
	 *  写debug级别日志
	 * @param cls 调用的类this
	 * @param info 日志信息
	 */
	public static void debug(Object obj,String info) {
		debug(obj.getClass().getName(),info);
	}
	/**
	 * 写error级别日志
	 * @param name 类名
	 * @param info 日志信息
	 */
	public static void error(String name,String info) {
		log.error("["+name+"]---->"+info);
	}
	/**
	 *  写error级别日志
	 * @param cls 调用的类this
	 * @param info 日志信息
	 */
	public static void error(Object obj,String info) {
		error(obj.getClass().getName(),info);
	}

}
