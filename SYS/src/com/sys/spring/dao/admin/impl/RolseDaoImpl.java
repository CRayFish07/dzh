package com.sys.spring.dao.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.admin.RolseDao;
import com.sys.spring.domain.admin.Rolse;

public class RolseDaoImpl extends AbstractDBDao implements RolseDao {
	private static final Logger log = Logger.getLogger(RolseDaoImpl.class);
	
	public int insertRolse(Rolse rolse) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into yd_rolse (rolse,info,modules) values(?,?,?)" ;
		Object[] params = {rolse.getRolse(),rolse.getInfo(),rolse.getModules()} ;
		int result = update(sqlStr, params) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public int updateRolse(Rolse rolse) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update yd_rolse set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(rolse.getRolse()!=null){
			sqlStr.append(" rolse=?,") ;
			params.add(rolse.getRolse()) ;
		}
		if(rolse.getInfo()!=null){
			sqlStr.append(" info=?,") ;
			params.add(rolse.getInfo()) ;
		}
		if(rolse.getModules()!=null){
			sqlStr.append(" modules=?,") ;
			params.add(rolse.getModules()) ;
		}
		if(rolse.getState()!=0){
			sqlStr.append(" state=?,") ;
			params.add(rolse.getState()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(rolse.getId()) ;
		
		int result = update(sql, params.toArray()) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public Rolse selectRolseById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from yd_rolse where id = ? ";
		Object[] params = {id} ;
		Rolse result = super.selectObject(sqlStr,params, Rolse.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.getId())
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public List<Rolse> selectRolseByRolse(Rolse rolse) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from yd_rolse where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(rolse.getRolse()!=null){
			sqlStr.append(" and rolse = ?") ;
			params.add(rolse.getRolse()) ;
		}
		if(rolse.getState()!=0){
			sqlStr.append(" and state= ?") ;
			params.add(rolse.getState()) ;
		}
		if(rolse.getId()!=0){
			sqlStr.append(" and id= ?") ;
			params.add(rolse.getId()) ;
		}
		List<Rolse> result = super.selectList(sqlStr.toString(), params.toArray(), Rolse.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size())
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public List<Rolse> selectRolseByIds(String ids) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sql = "select * from yd_rolse where id in("+ids+")" ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		List<Rolse> result = super.selectList(sql, params.toArray(), Rolse.class) ;

		buf.append("|").append(sql)
		.append("|").append(result.size())
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}


}
