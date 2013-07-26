package com.sys.spring.dao.account;

import java.util.List;

import com.sys.spring.domain.Kind;

/** 
 * by dyong 2010-6-16
 */
public interface KindDao {

	public int insertKind(Kind kind) ;
	
	public int updateKind(Kind kind) ;

	public Kind findKindById(int id) ;
	
	public List<Kind> findAllKindList() ;
	
	public List<Kind> findKindListByParentId(int parentId) ;
	
	public int deleteKindById(int id) ;
	
}
