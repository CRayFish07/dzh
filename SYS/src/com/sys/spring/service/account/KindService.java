package com.sys.spring.service.account;

import java.util.List;

import com.sys.spring.domain.Kind;

/** 
 * by dyong 2010-6-16
 */
public interface KindService {

	public int insertKind(Kind kind) ;
	
	public int updateKind(Kind kind) ;
	
//	按父级ID查询
	public List<Kind> findKindList(int parentId) ;
	
	public Kind findKindById(int id) ;
	
	public void deleteKindById(int id) ;
}
