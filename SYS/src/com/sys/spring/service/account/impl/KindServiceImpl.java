package com.sys.spring.service.account.impl;

import java.util.List;
import java.util.UUID;

import com.sys.spring.dao.account.KindDao;
import com.sys.spring.domain.Kind;
import com.sys.spring.service.account.KindService;

/** 
 * by dyong 2010-6-16
 */
public class KindServiceImpl implements KindService {

	private KindDao kindDao ;
	
	public KindDao getKindDao() {
		return kindDao;
	}
	public void setKindDao(KindDao kindDao) {
		this.kindDao = kindDao;
	}
	public int insertKind(Kind kind) {
		kind.setUid(UUID.randomUUID().toString()) ;
		return kindDao.insertKind(kind);
	}
	public int updateKind(Kind kind) {
		return kindDao.updateKind(kind);
	}
	public Kind findKindById(int id) {
		return kindDao.findKindById(id);
	}

	public List<Kind> findKindList(int parentId) {
		if(parentId==-1){
			return kindDao.findAllKindList() ;
		}
		return kindDao.findKindListByParentId(parentId);
	}
	public void deleteKindById(int id) {
		kindDao.deleteKindById(id) ;
	}

}
