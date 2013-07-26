package com.sys.spring.dao.ibatisImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/** 
 * by dyong 2010-6-16
 */
public class DaoImpl extends SqlMapClientDaoSupport{
	private static final Logger log = Logger.getLogger(DaoImpl.class);
	
	
	public void insert(String sqlMapName,Object obj){
		getSqlMapClientTemplate().insert(sqlMapName, obj) ;
	}
	
	public int update(String sqlMapName,Object obj){
		return getSqlMapClientTemplate().update(sqlMapName, obj) ;
	}
	
	public void delete(String sqlMapName,Object obj){
		getSqlMapClientTemplate().delete(sqlMapName, obj) ;
	}
	
	public Object queryForObject(String sqlMapName){
		return getSqlMapClientTemplate().queryForObject(sqlMapName) ;
	}
	
	public Object queryForObject(String sqlMapName,Object obj){
		return getSqlMapClientTemplate().queryForObject(sqlMapName, obj) ;
	}

	public List<?> queryForList(String sqlMapName){
		return getSqlMapClientTemplate().queryForList(sqlMapName) ;
	}
	
	public List<?> queryForList(String sqlMapName,Object obj){
		return getSqlMapClientTemplate().queryForList(sqlMapName, obj) ;
	}
	
	protected void logOut(String sqlMapName,HashMap<String,String> map){
		log.info(sqlMapName+map) ;
	}
}
