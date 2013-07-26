package com.gzb.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDBDao {

	private JdbcTemplate jdbc ;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	public abstract String getSelectCommonParams() ;
	
	public int update(String sql,Object[] params){
		if(params==null || params.length==0){
			return jdbc.update(sql) ;
		}
		return jdbc.update(sql, params) ;
	}
	
	public <T> T selectObject(String sql,Object[] params,Class<?> T){
		List<T> result = selectList(sql, params, T) ;
		if(result.size()>0){
			return result.get(0) ;
		}
		return null ;
	}
	
	public <T> List<T> selectList(String sql,Object[] params,Class<?> T){
		List<?> list ;
		if(params==null || params.length==0){
			list = jdbc.queryForList(sql) ;
		} else {
			list = jdbc.queryForList(sql,params) ;
		}
		if(list==null || list.size()==0){
			return new ArrayList<T>() ;
		}
		return queryToObjectList(list,T) ;
	}
	
	@SuppressWarnings("unchecked")
	protected <T> List<T> queryToObjectList(List<?> result,Class<?> T) {
		List<T> list = new ArrayList<T>() ;
		
		Iterator<?> iterator = result.iterator();
		
		while (iterator.hasNext()) {
			Map<String, Object> itmap = (Map<String, Object>) iterator.next();
			try {
				T o = (T) T.newInstance();

				mapToBean(itmap, o, T) ;
				list.add(o) ;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list ;
	}
	
	private void mapToBean(Map<String,Object> map,Object bean,Class<?> clas){
		if(!clas.getSuperclass().equals(Object.class)){
			this.mapToBean(map, bean, clas.getSuperclass()) ;
		}
		Field[] fs = clas.getDeclaredFields();	//获取私有属性。
		for(Field f:fs){
			if(map.containsKey(f.getName())){
				f.setAccessible(true);//设置私有、保护变量的可以访问权限。
				try {
					f.set(bean, map.get(f.getName())) ;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
