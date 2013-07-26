package com.sys.spring.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.admin.UserinfoDao;
import com.sys.spring.domain.admin.Userinfo;
import com.sys.spring.service.admin.RolseService;
import com.sys.spring.service.admin.UserService;
import com.sys.spring.service.admin.UserinfoService;

public class UserinfoServiceImpl implements UserinfoService {
	private static final Logger log = Logger.getLogger(UserinfoServiceImpl.class);
	
	private RolseService rolseservice ;
	private UserinfoDao userinfodao ;
	private UserService userservice ;
	
	public int addUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return userinfodao.insertUserinfo(userinfo) ;
	}
	public int updateUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return userinfodao.updateUserinfo(userinfo) ;
	}
	public Userinfo findUserinfoByID(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		Userinfo info = userinfodao.selectUserinfoById(id) ;
		if(info==null){
			return new Userinfo() ;
		}
		setUserinfo(info) ;

		buf.append("|").append(id)
		.append("|").append(info.getId()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return info ;
	}
	public List<Userinfo> findUserinfoList(Userinfo userinfo) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		List<Userinfo> list = userinfodao.selectUserinfoByUserinfo(userinfo) ;
		if(list==null){
			return new ArrayList<Userinfo>() ;
		}
		for(Userinfo info:list){
			setUserinfo(info) ;
		}

		buf.append("|") 
		.append("|").append(list.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return list ;
	}
	public List<Userinfo> findUserinfoList() {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		List<Userinfo> list = userinfodao.selectUserinfoByUserinfo(new Userinfo()) ;
		if(list==null){
			return new ArrayList<Userinfo>() ;
		}
		for(Userinfo info:list){
			setUserinfo(info) ;
		}
		
		buf.append("|") 
		.append("|").append(list.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return list ;
	}
	public int deleteUserinfo(int id) {
		// TODO Auto-generated method stub
		return userinfodao.deleteUserinfo(id) ;
	}
	private void setUserinfo(Userinfo info){
		info.setRolselist(rolseservice.findRolseListByIds(info.getRolses())) ;
		info.setUser(userservice.getUserById(info.getUserid())) ;
	}
	public RolseService getRolseservice() {
		return rolseservice;
	}
	public void setRolseservice(RolseService rolseservice) {
		this.rolseservice = rolseservice;
	}
	public UserinfoDao getUserinfodao() {
		return userinfodao;
	}
	public void setUserinfodao(UserinfoDao userinfodao) {
		this.userinfodao = userinfodao;
	}
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	

}
