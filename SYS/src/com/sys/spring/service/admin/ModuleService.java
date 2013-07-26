package com.sys.spring.service.admin;

import java.util.List;

import com.sys.spring.domain.admin.Module;

public interface ModuleService {

	public int addModule(Module mod) ;
	public int updateModule(Module mod) ;
	public Module findModuleByID(int id) ;
	public List<Module> findModuleList(Module mod) ;
	public List<Module> findModuleList() ;
	public List<Module> findModuleListByIds(String ids) ;
	public List<Module> findModuleListByParentId(int id) ;
}
