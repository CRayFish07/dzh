package com.sys.applet;

import java.io.FileInputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.InputStreamResource;

import com.sys.applet.main.UserRank;
import com.sys.spring.domain.admin.User;
import com.sys.spring.service.account.AccountService;
import com.sys.spring.service.account.DiaryService;
import com.sys.spring.service.account.IncomeService;
import com.sys.spring.service.account.KindService;
import com.sys.spring.service.admin.UserService;

/** 
 * by dyong 2010-9-1
 */
public class ConstService {

	public static String ROOT = System.getProperty("user.dir") ;
	public static User user ;
	public static UserRank rank = new UserRank() ;
	
	public static UserService userService ;
	public static IncomeService incomeService ;
	public static AccountService accService ;
	public static DiaryService diaryService ;
	public static KindService kindService ;
	public static void initService(){

//		InputStreamResource resource = new InputStreamResource(
//				new FileInputStream("./spring-service.xml"));
//		BeanFactory factory = new XmlBeanFactory(resource);
//		userService = (UserService)(factory.getBean("dataSource"));
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-*");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"spring-dao.xml","spring-service.xml"});
		
		userService = (UserService)context.getBean("userService");
		accService = (AccountService)context.getBean("accountService");
		incomeService = (IncomeService)context.getBean("incomeService");
		diaryService = (DiaryService)context.getBean("diaryService");
		kindService = (KindService)context.getBean("kindService");
//		System.getProperty("user.dir") ;
		System.out.println("========="+System.getProperty("user.dir")) ;
	}
	
	public static void setUser(User u){
		user = u ;
//		char[] c = u.getRank().toCharArray() ;
//		rank.accunt = c[0] ;
//		rank.income = c[1] ;
//		rank.kind = c[2] ;
//		rank.diary = c[3] ;
		rank.accunt = '1' ;
		rank.income = '1' ;
		rank.kind = '1' ;
		rank.diary = '1' ;
		
	}
	public static void main(String[] args){
		initService() ;
	}
}
