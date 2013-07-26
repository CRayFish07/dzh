package com.sys.spring.service.admin;

import java.util.List;

import com.sys.spring.domain.admin.Userinfo;

public interface UserinfoService {

	public int addUserinfo(Userinfo userinfo) ;
	public int updateUserinfo(Userinfo userinfo) ;
	public Userinfo findUserinfoByID(int id) ;
	public List<Userinfo> findUserinfoList(Userinfo userinfo) ;
	public List<Userinfo> findUserinfoList() ;
	
	public int deleteUserinfo(int id) ;
	
}
