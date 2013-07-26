package com.sys.spring.dao.img.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.img.ImageTypeDao;
import com.sys.spring.domain.img.ImageType;

public class ImageTypeDaoImpl extends AbstractDBDao implements ImageTypeDao {
	private static final Logger log = Logger.getLogger(ImageTypeDaoImpl.class);
	
	public int insertImageType(ImageType type) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into imagetype (NAME,info,parentid) values(?,?,?)" ;
		Object[] params = {type.getName(),type.getInfo(),type.getParentid()} ;
		int result = update(sqlStr, params) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public ImageType selectImageTypeByID(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from imagetype where id = ? ";
		Object[] params = {id} ;
		ImageType result = super.selectObject(sqlStr,params, ImageType.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result==null?0:1)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public List<ImageType> selectImageTypesByImageType(ImageType type) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from imagetype where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		
		if(type.getName()!=null){
			sqlStr.append(" and name = ?") ;
			params.add(type.getName()) ;
		}
		if(type.getInfo()!=null){
			sqlStr.append(" and type = ?") ;
			params.add(type.getInfo()) ;
		}
		if(type.getParentid()>=0){
			sqlStr.append(" and parentid = ?") ;
			params.add(type.getParentid()) ;
		}
		List<ImageType> result = super.selectList(sqlStr.toString(), params.toArray(), ImageType.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result!=null?result.size():0)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	public int updateImageType(ImageType type) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update imagetype set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(type.getName()!=null){
			sqlStr.append(" name=?,") ;
			params.add(type.getName()) ;
		}
		if(type.getInfo()!=null){
			sqlStr.append(" info=?,") ;
			params.add(type.getInfo()) ;
		}
		if(type.getParentid()>0){
			sqlStr.append(" parentid=?,") ;
			params.add(type.getParentid()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(type.getId()) ;
		
		int result = update(sql, params.toArray()) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}
	


}
