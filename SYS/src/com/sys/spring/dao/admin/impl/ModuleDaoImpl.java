package com.sys.spring.dao.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.admin.ModuleDao;
import com.sys.spring.domain.admin.Module;

public class ModuleDaoImpl extends AbstractDBDao implements ModuleDao {
	private static final Logger log = Logger.getLogger(ModuleDaoImpl.class);
	
	public int insertModule(Module mod) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into yd_module (name,url,type,parentid) values(?,?,?,?)" ;
		Object[] params = {mod.getName(),mod.getUrl(),mod.getType(),mod.getParentid()} ;
		int result = update(sqlStr, params) ;
		buf.append("|").append(sqlStr).append(" ")
		.append(mod.getName()).append(",")
		.append(mod.getUrl()).append(",")
		.append(mod.getType()).append(",")
		.append(mod.getParentid())
		.append("|").append(result) ;
		
		buf.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public int updateModule(Module mod) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update yd_module set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(mod.getName()!=null){
			sqlStr.append(" name=?,") ;
			params.add(mod.getName()) ;
		}
		if(mod.getUrl()!=null){
			sqlStr.append(" url=?,") ;
			params.add(mod.getUrl()) ;
		}
		if(mod.getType()>0){
			sqlStr.append(" type=?,") ;
			params.add(mod.getType()) ;
		}
		if(mod.getParentid()>-1){
			sqlStr.append(" parentid=?,") ;
			params.add(mod.getParentid()) ;
		}
		
		if(mod.getState()!=0){
			sqlStr.append(" state=?,") ;
			params.add(mod.getState()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(mod.getId()) ;
		
		int result = update(sql, params.toArray()) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public Module selectModuleById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from yd_module where id = ? ";
		Object[] params = {id} ;
		Module result = super.selectObject(sqlStr,params, Module.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result.getId()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public List<Module> selectModuleByModule(Module mod) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from yd_module where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(mod.getName()!=null){
			sqlStr.append(" and name = ?") ;
			params.add(mod.getName()) ;
		}
		if(mod.getType()>0){
			sqlStr.append(" and type= ?") ;
			params.add(mod.getType()) ;
		}
		if(mod.getParentid()>=0){
			sqlStr.append(" and parentid= ?") ;
			params.add(mod.getParentid()) ;
		}
		if(mod.getState()>0){
			sqlStr.append(" and state= ?") ;
			params.add(mod.getState()) ;
		}
		List<Module> result = super.selectList(sqlStr.toString(), params.toArray(), Module.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public List<Module> selectModuleByIds(String ids) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from yd_module where id in("+ids+") ";
		ArrayList<Object> params = new ArrayList<Object>() ;
//		params.add(ids) ;
		List<Module> result = super.selectList(sqlStr.toString(), params.toArray(), Module.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

}
