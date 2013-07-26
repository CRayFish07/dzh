package com.sys.spring.dao.admin;

import java.util.List;

import com.sys.spring.domain.admin.Module;

/**
 * 模块管理
 * @author Administrator
 *
 */
public interface ModuleDao {

	public int insertModule(Module mod) ;
	
	public int updateModule(Module mod) ;
	
	public Module selectModuleById(int id) ;
	
	public List<Module> selectModuleByModule(Module mod) ;

	public List<Module> selectModuleByIds(String ids) ;	//批量查询，按ID号批量查询
	
}
