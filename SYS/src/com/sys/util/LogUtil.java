package com.sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


/**
 * by dyong 2011-3-24
 */
public class LogUtil {
	private static final Logger log = Logger.getLogger(LogUtil.class);
//	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	public static void logInfo(String user,String message,String sql){
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:ss,SSS");
		log.info("|USER LOG|"+user+"|"+dateFormatter.format(new Date())+"|"+message+"|"+sql) ;
	}
}
