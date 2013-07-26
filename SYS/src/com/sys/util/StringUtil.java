package com.sys.util;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

/** 
 * by dyong 2010-5-26
 */
public class StringUtil {

	public static void main(String[] s){
		System.out.println(md5("dyong")) ;
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString() ;
	}
	
	public static String md5(String str){
		return DigestUtils.md5Hex(str) ;
	}
	
	public static String ISO2UTF(String key){
		if(key==null){
			return "" ;
		}
		try {
			return new String(key.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return key ;
	}
}
