package com.gzb.service.admin.impl;

import java.util.List;

import com.gzb.dao.admin.UserDao;
import com.gzb.domain.admin.User;
import com.gzb.service.admin.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao ;
	
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	/**
	 * 查询所有用户信息
	 */
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return dao.selectUsersByUser(new User()) ;
	}

	/**
	 * 查询单条用户信息
	 */
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return dao.selectUserByID(id) ;
	}

	/**
	 * 删除一条用户信息
	 */
	public boolean userDelete(int uid) {
		// TODO Auto-generated method stub
		return dao.deleteUserByID(uid)==0 ;
	}

	/**
	 * 用户注册
	 */
	public int userRegister(User user) {
		// TODO Auto-generated method stub
		if(user.getUsername()==null || user.getUsername().trim().length()==0){
			user.setUsername(user.getEmail().substring(0,user.getEmail().indexOf("@"))) ;
		}
		return dao.insertUser(user) ;
	}

	/**
	 * 用户信息修改
	 */
	public int userUpdate(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user) ;
	}
	
	/**
	 * 按条件查询
	 */
	public List<User> getUsersByUser(User user) {
		// TODO Auto-generated method stub
		return dao.selectUsersByUser(user);
	}
	
	/**
	 * 修改密码
	 */
	public int userPasswordUpdate(User user) {
		// TODO Auto-generated method stub
		user.setPassword(user.getPassword()) ;
		return dao.updateUserPwd(user) ;
	}

}
