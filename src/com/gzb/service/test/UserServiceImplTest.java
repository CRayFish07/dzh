package com.gzb.service.test;

import com.gzb.domain.admin.User;
import com.gzb.service.admin.UserService;

import junit.framework.Assert;

public class UserServiceImplTest extends AbstServiceTest<UserService> {

	public UserServiceImplTest(){
		super("userService") ;
	}
	
	public void testGetAllUser(){
		int count = getBean().getAllUser().size() ;
		Assert.assertTrue(count>1) ;
	}
	public void testUserRegister(){
		User user = new User() ;
		user.setEmail("dy@163.com") ;
		user.setPassword("123") ;
		Assert.assertEquals(this.getBean().userRegister(user),1) ;
	}
	public void testUserUpdate(){
		User user = new User() ;
		user.setId(3) ;
		user.setUsername("ttt") ;
		user.setPassword("666") ;
		Assert.assertEquals(this.getBean().userUpdate(user),1) ;
	}
	public void testUserDelete(){
		Assert.assertNull(null) ;
	}
	public void testGetUserById(){
		Assert.assertNotNull(this.getBean().getUserById(2)) ;
		Assert.assertNotNull(this.getBean().getUserById(1)) ;
	}
	public void testGetUsersByUser(){
		Assert.assertNull(null) ;
	}
	
}
