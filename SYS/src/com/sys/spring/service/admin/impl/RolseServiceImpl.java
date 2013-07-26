package com.sys.spring.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.admin.RolseDao;
import com.sys.spring.domain.admin.Module;
import com.sys.spring.domain.admin.Rolse;
import com.sys.spring.service.admin.ModuleService;
import com.sys.spring.service.admin.RolseService;

public class RolseServiceImpl implements RolseService {
	private static final Logger log = Logger.getLogger(RolseServiceImpl.class);
	
	private RolseDao rolsedao ;
	private ModuleService moduleserver ;
	
	public int addRolse(Rolse rolse) {
		// TODO Auto-generated method stub
		return rolsedao.insertRolse(rolse) ;
	}
	public int updateRolse(Rolse rolse) {
		// TODO Auto-generated method stub
		return rolsedao.updateRolse(rolse) ;
	}
	public Rolse findRolseByID(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		Rolse rolse = rolsedao.selectRolseById(id) ;
		if(rolse==null){
			return new Rolse() ;
		}
		rolse.setModulelist(moduleserver.findModuleListByIds(rolse.getModules())) ;
		for(Module mod:rolse.getModulelist()){
			rolse.getModuleids().add(mod.getId()) ;
		}
		
		buf.append("|").append(id)
		.append("|").append(rolse.getId()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return rolse ;
	}
	public List<Rolse> findRolseList(Rolse rolse) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		List<Rolse> list = rolsedao.selectRolseByRolse(rolse) ;
		if(list==null){
			return new ArrayList<Rolse>() ;
		}
		for(Rolse r:list){
			r.setModulelist(moduleserver.findModuleListByIds(r.getModules())) ;
		}
		buf.append("|")
		.append("|").append(list.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return list ;
	}
	public List<Rolse> findRolseList() {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		List<Rolse> list = rolsedao.selectRolseByRolse(new Rolse()) ;
		if(list==null){
			return new ArrayList<Rolse>() ;
		}
		for(Rolse r:list){
			r.setModulelist(moduleserver.findModuleListByIds(r.getModules())) ;
		}

		buf.append("|")
		.append("|").append(list.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return list ;
	}
	public List<Rolse> findRolseListByIds(String ids) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		List<Rolse> list = rolsedao.selectRolseByIds(ids) ;
		if(list==null){
			return new ArrayList<Rolse>() ;
		}
		for(Rolse r:list){
			r.setModulelist(moduleserver.findModuleListByIds(r.getModules())) ;
		}

		buf.append("|").append(ids)
		.append("|").append(list.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return list ;
	}

	public RolseDao getRolsedao() {
		return rolsedao;
	}
	public void setRolsedao(RolseDao rolsedao) {
		this.rolsedao = rolsedao;
	}
	public ModuleService getModuleserver() {
		return moduleserver;
	}
	public void setModuleserver(ModuleService moduleserver) {
		this.moduleserver = moduleserver;
	}
}
