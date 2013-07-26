package com.sys.spring.dao.admin;

import java.util.List;

import com.sys.spring.domain.admin.Userinfo;

/**
 * 用户权限对照表
 * @author Administrator
 *
 */
public interface UserinfoDao {

	public int insertUserinfo(Userinfo userinfo) ;
	
	public int updateUserinfo(Userinfo userinfo) ;
	
	public Userinfo selectUserinfoById(int id) ;
	
	public List<Userinfo> selectUserinfoByUserinfo(Userinfo userinfo) ;
	
	public int deleteUserinfo(int id) ;
}
