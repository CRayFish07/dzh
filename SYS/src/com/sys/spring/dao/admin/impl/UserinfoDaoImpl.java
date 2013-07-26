package com.sys.spring.dao.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.admin.UserinfoDao;
import com.sys.spring.domain.admin.Userinfo;


public class UserinfoDaoImpl extends AbstractDBDao implements UserinfoDao {
	private static final Logger log = Logger.getLogger(UserinfoDaoImpl.class);
	
	public int insertUserinfo(Userinfo userinfo) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into yd_userinfo (userid,rolses) values(?,?)" ;
		Object[] params = {userinfo.getUserid(),userinfo.getRolses()} ;
		int result = update(sqlStr, params) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public int updateUserinfo(Userinfo userinfo) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update yd_userinfo set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(userinfo.getUserid()>0){
			sqlStr.append(" userid=?,") ;
			params.add(userinfo.getUserid()) ;
		}
		if(userinfo.getRolses()!=null){
			sqlStr.append(" rolses=?,") ;
			params.add(userinfo.getRolses()) ;
		}
		if(userinfo.getState()!=0){
			sqlStr.append(" state=?,") ;
			params.add(userinfo.getState()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(userinfo.getId()) ;
		
		int result = update(sql, params.toArray()) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public Userinfo selectUserinfoById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from yd_userinfo where id = ? ";
		Object[] params = {id} ;
		Userinfo result = super.selectObject(sqlStr,params, Userinfo.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.getId())
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public List<Userinfo> selectUserinfoByUserinfo(Userinfo userinfo) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from yd_userinfo where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(userinfo.getUserid()>0){
			sqlStr.append(" and id = ?") ;
			params.add(userinfo.getUserid()) ;
		}
		if(userinfo.getState()!=0){
			sqlStr.append(" and state= ?") ;
			params.add(userinfo.getState()) ;
		}
		if(userinfo.getId()!=0){
			sqlStr.append(" and id= ?") ;
			params.add(userinfo.getId()) ;
		}
		List<Userinfo> result = super.selectList(sqlStr.toString(), params.toArray(), Userinfo.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size())
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}
	public int deleteUserinfo(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "delete from yd_userinfo where id = ? ";
		Object[] params = {id} ;
		int result = update(sqlStr, params) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	

}
