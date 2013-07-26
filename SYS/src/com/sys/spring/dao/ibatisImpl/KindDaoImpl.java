package com.sys.spring.dao.ibatisImpl;

import java.util.List;

import com.sys.spring.dao.account.KindDao;
import com.sys.spring.domain.Kind;

/** 
 * by dyong 2010-7-5
 */
public class KindDaoImpl extends DaoImpl implements KindDao {

	public int insertKind(Kind kind) {
		super.insert("saveKind", kind);
		return 0 ;
	}
	public int updateKind(Kind kind) {
		return super.update("updateKind", kind);
	}

	public Kind findKindById(int id) {
		return (Kind) super.queryForObject("selectKindById", id);
	}

	public List<Kind> findAllKindList() {
		return (List<Kind>) super.queryForList("selectAllKinds");
	}

	public List<Kind> findKindListByParentId(int parentId) {
		return (List<Kind>) super.queryForList("selectKindListByParentId",parentId);
	}
	public int deleteKindById(int id) {
		super.delete("deleteKindById",id) ;
		return 0 ;
	}

}
