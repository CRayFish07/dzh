package com.sys.spring.service.admin.impl;

import java.util.List;

import com.sys.spring.dao.admin.ModuleDao;
import com.sys.spring.domain.admin.Module;
import com.sys.spring.service.admin.ModuleService;

public class ModuleServiceImpl implements ModuleService {
	private ModuleDao dao ;
	
	public ModuleDao getDao() {
		return dao;
	}

	public void setDao(ModuleDao dao) {
		this.dao = dao;
	}

	public int addModule(Module mod) {
		// TODO Auto-generated method stub
		return dao.insertModule(mod);
	}

	public int updateModule(Module mod) {
		// TODO Auto-generated method stub
		return dao.updateModule(mod);
	}

	public Module findModuleByID(int id) {
		// TODO Auto-generated method stub
		return dao.selectModuleById(id);
	}

	public List<Module> findModuleList(Module mod) {
		// TODO Auto-generated method stub
		List<Module> list = dao.selectModuleByModule(mod);
		for(Module module:list){
			if(module!=null && module.getType()==1){
				module.setSublist(this.findModuleListByParentId(module.getId())) ;
			}
		}
		return list ;
	}

	public List<Module> findModuleList() {
		// TODO Auto-generated method stub
		return dao.selectModuleByModule(new Module()) ;
	}

	public List<Module> findModuleListByIds(String ids) {
		// TODO Auto-generated method stub
		return dao.selectModuleByIds(ids) ;
	}

	public List<Module> findModuleListByParentId(int id) {
		// TODO Auto-generated method stub
		Module mod = new Module() ;
		mod.setParentid(id) ;
		List<Module> list = dao.selectModuleByModule(mod) ;
		for(Module module:list){
			module.setSublist(this.findModuleListByParentId(module.getId())) ;
		}
		return list ;
	}

}
