package com.gzb.dao.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import junit.framework.TestCase;

/** 
 * by dyong 2011-1-14
 * @param <T>
 */
public abstract class AbstDaoTest<T> extends TestCase {
	
	protected static Logger log = Logger.getLogger(AbstDaoTest.class);
	private static ApplicationContext context ;
	private T bean ;
	static{
		context = new ClassPathXmlApplicationContext("spring-*");
		
	}
	public AbstDaoTest(){
		this("userDao") ;
	}
	@SuppressWarnings("unchecked")
	public AbstDaoTest(String name){
		bean = (T) context.getBean(name) ;
	}
	
	/** 结果不为空*/
	public void testResultNotNull() {
		Assert.assertNotNull(bean) ;
	}
	
	public T getBean(){
		return bean ;
	}
	
}
