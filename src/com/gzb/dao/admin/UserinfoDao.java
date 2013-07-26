package com.gzb.dao.admin;

import java.util.List;

import com.gzb.domain.admin.Userinfo;

public interface UserinfoDao {

	public int insertUserinfo(Userinfo userinfo) ;
	
	public int updateUserinfo(Userinfo userinfo) ;
	
	public Userinfo selectUserinfoById(int id) ;
	public List<Userinfo> selectUserinfoByUserinfo(Userinfo userinfo) ;
	
	public int deleteUserinfo(int id) ;
}
