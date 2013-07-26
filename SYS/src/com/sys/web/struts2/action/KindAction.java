package com.sys.web.struts2.action;

import java.util.List;

import com.sys.spring.domain.Kind;
import com.sys.spring.service.account.KindService;
import com.sys.web.struts2.BaseAction;

/** 
 * by dyong 2010-6-16
 */
public class KindAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1623642742063346395L;
	private KindService kindService ;
	
//	result
	private Kind kind ;
	private List<Kind> list ;
	
	/**
	 * 新增
	 * @return
	 */
	public String insert(){
		list = kindService.findKindList(0) ;
		return INSERT ;
	}

	/**
	 * 修改
	 * @return
	 */
	public String update(){
		list = kindService.findKindList(0) ;
		kind = kindService.findKindById(kind.getId()) ;
		return INSERT ;
	}
	
	/**
	 * 提交
	 * @return
	 */
	public String addup(){
		int result = 0 ;
		if(kind.getId()==0){
			result = kindService.insertKind(kind) ;
		} else if(kind.getId()>0){
			result = kindService.updateKind(kind) ;
		}
		if(result==1){
			return list() ;
		}
		
		return INSERT ;
	}
	
	/**
	 * 列表
	 * @return
	 */
	public String list(){
		list = kindService.findKindList(-1) ;
		return LIST ;
	}

	public KindService getKindService() {
		return kindService;
	}

	public void setKindService(KindService kindService) {
		this.kindService = kindService;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public List<Kind> getList() {
		return list;
	}

	public void setList(List<Kind> list) {
		this.list = list;
	}
	
}
