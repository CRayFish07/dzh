package com.sys.web.struts2.admin;

import java.util.ArrayList;
import java.util.List;

import com.sys.spring.domain.admin.Module;
import com.sys.spring.service.admin.ModuleService;
import com.sys.web.struts2.BaseAction;


public class ModuleAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ModuleService modService ;
	
	private List<Module> modulelist = new ArrayList<Module>() ;
	private Module module = new Module() ;
	public String execute(){
		return INDEX ;
	}
	//添加
	public String add(){
		Module mod = new Module() ;
		mod.setType(1) ;
		modulelist = modService.findModuleList(mod) ;
		return ADD ;
	}
	//添加/修改提交
	public String addup(){
		int result = 0 ;
		if(module.getId()==0){
			result = modService.addModule(module) ;
		} else if(module.getId()>0){
			result = modService.updateModule(module) ;
		}
		if(result==1){
			return list() ;
		}
		
		return ADD ;
	}
	//列表
	public String list(){
//		modulelist = modService.findModuleList() ;
		List<Module> list = modService.findModuleListByParentId(0) ;
		this.setModuleTreeToList(list,"/") ;
		return LIST ;
	}
	//修改
	public String update(){
		int id = module.getId() ;//Integer.parseInt(ServletActionContext.getRequest().getParameter("id")) ;
		module = modService.findModuleByID(id) ;

		Module mod = new Module() ;
		mod.setType(1) ;
		modulelist = modService.findModuleList(mod) ;
		return ADD ;
	}
	//修改状态
	public String upstate(){
		int id = module.getId() ;//Integer.parseInt(ServletActionContext.getRequest().getParameter("id")) ;
		int state = module.getState() ;//Integer.parseInt(ServletActionContext.getRequest().getParameter("state")) ;
		
		Module mod = new Module() ;
		mod.setId(id) ;
		mod.setState(state) ;
		this.modService.updateModule(mod) ;
		
		return list() ;
	}
	private void setModuleTreeToList(List<Module> list,String parentname){
		if(list.size()>0)
		for(Module mod:list){
			mod.setName(parentname+mod.getName()) ;
			modulelist.add(mod) ;
			if(mod.getSublist().size()>0){
				this.setModuleTreeToList(mod.getSublist(),mod.getName()+"/") ;
			}
		}
	}
	
	public ModuleService getModService() {
		return modService;
	}
	public void setModService(ModuleService modService) {
		this.modService = modService;
	}
	public List<Module> getModulelist() {
		return modulelist;
	}
	public void setModulelist(List<Module> modulelist) {
		this.modulelist = modulelist;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	
}
