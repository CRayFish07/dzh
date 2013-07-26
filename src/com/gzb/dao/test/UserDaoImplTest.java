package com.gzb.dao.test;


import junit.framework.Assert;

import com.gzb.dao.admin.UserDao;
import com.gzb.domain.admin.User;

public class UserDaoImplTest extends AbstDaoTest<UserDao>{
	
	public UserDaoImplTest(){
		super("userDao");
	}
	public void testInsertUser(){
		User user = new User() ;
		user.setEmail("dyong525@163.com") ;
		user.setPassword("123") ;
		user.setUsername("DY") ;
		int result = super.getBean().insertUser(user) ;
		Assert.assertEquals(result, 1) ;
	}
	
	public void testSelectOneUser(){
		User result = super.getBean().selectUserByID(3) ;
		Assert.assertEquals(result.getUsername(), "DY") ;
	}
		
	public void testUpdateUser(){
		User user = new User() ;
		user.setId(1) ;
		user.setUsername("dyong") ;
		user.setPassword("456") ;
		int result = super.getBean().updateUser(user) ;
		Assert.assertEquals(result, 1) ;
	}
	
	public void testDeleteUser(){
		int result = super.getBean().deleteUserByID(2) ;
		Assert.assertEquals(result, 1) ;
	}
}
