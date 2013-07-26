package com.sys.web.struts2.admin;

import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.sys.spring.domain.admin.Module;
import com.sys.spring.domain.admin.Rolse;
import com.sys.spring.service.admin.ModuleService;
import com.sys.spring.service.admin.RolseService;
import com.sys.web.struts2.BaseAction;

public class RolseAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RolseService rolseService ;
	private ModuleService modService ;
	
	private List<Module> modulelist ;
	private List<Rolse> rolselist ;
	private Rolse rolse = new Rolse() ; 
	public String execute(){
		return INDEX ;
	}
	//添加
	public String add(){
//		modulelist = modService.findModuleList() ;
		modulelist = modService.findModuleListByParentId(0) ;
		if(rolse.getId()>0){
			this.setCheck(modulelist) ;
		}
		return ADD ;
	}
	//添加/修改提交
	public String addup(){
		int result = 0 ;
		String ids = "" ;
		for(int id :rolse.getModuleid()){
			ids += ","+id ;
		}
		ids = ids.substring(1) ;
		rolse.setModules(ids) ;

		if(rolse.getId()==0){
			result = rolseService.addRolse(rolse) ;
		} else if(rolse.getId()>0){
			result = rolseService.updateRolse(rolse) ;
		}
		if(result==1){
			return list() ;
		}
		
		return add() ;
	}
	//列表
	public String list(){
		rolselist = rolseService.findRolseList() ;
		return LIST ;
	}
	//修改
	public String update(){
		int id = rolse.getId() ;//Integer.parseInt(ServletActionContext.getRequest().getParameter("id")) ;
		rolse = rolseService.findRolseByID(id) ;
		return add() ;
	}
	//修改状态
	public String upstate(){
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id")) ;
		int state = Integer.parseInt(ServletActionContext.getRequest().getParameter("state")) ;
		
		Rolse rolse = new Rolse() ;
		rolse.setId(id) ;
		rolse.setState(state) ;
		this.rolseService.updateRolse(rolse) ;
		
		return list() ;
	}
	
	private void setCheck(List<Module> modulelist){
		Set<Integer> set = rolse.getModuleids() ;
		for(Module mod:modulelist){
			if(set.contains(mod.getId())){
				mod.setChecked(true) ;
			}
			if(mod.getSublist().size()>0){
				this.setCheck(mod.getSublist()) ;
			}
		}
	}
	public RolseService getRolseService() {
		return rolseService;
	}
	public void setRolseService(RolseService rolseService) {
		this.rolseService = rolseService;
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
	public List<Rolse> getRolselist() {
		return rolselist;
	}
	public void setRolselist(List<Rolse> rolselist) {
		this.rolselist = rolselist;
	}
	public Rolse getRolse() {
		return rolse;
	}
	public void setRolse(Rolse rolse) {
		this.rolse = rolse;
	}
	
	
	
}
