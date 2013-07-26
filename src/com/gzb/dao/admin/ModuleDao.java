package com.gzb.dao.admin;

import java.util.List;

import com.gzb.domain.admin.Module;

public interface ModuleDao {

	public int insertModule(Module mod) ;
	
	public int updateModule(Module mod) ;
	
	public Module selectModuleById(int id) ;
	public List<Module> selectModuleByModule(Module mod) ;

	public List<Module> selectModuleByIds(String ids) ;
	
}
