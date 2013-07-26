package com.sys.web.struts2;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.domain.admin.Module;
import com.sys.spring.domain.admin.Systems;
import com.sys.spring.service.admin.ModuleService;


public class MainAction extends BaseAction{

	private static final long serialVersionUID = 9035439762362528233L;
	public static final Logger log = Logger.getLogger(MainAction.class);
	
	private ModuleService modService ;
	private List<Systems> systems = new ArrayList<Systems>() ;
	private String modulelist ;
	/**
	 * 主页面
	 */
	public String execute(){
		if(super.getUser()==null ){
			this.setMessage("用户自动退出。") ;
			return ERROR ;
		}
		return INDEX ;
	}
	public String top(){
		Systems s = new Systems() ;
		s.setName("百度");
		s.setUrl("http://www.baidu.com") ;
		systems.add(s) ;
		s = new Systems() ;
		s.setName("腾讯");
		s.setUrl("http://www.qq.com") ;
		systems.add(s) ;
		
		return "top" ;
	}
	
	public String left(){
		List<Module> modulelist = modService.findModuleList() ;
		
		StringBuffer buf = new StringBuffer() ;
		for(Module mod:modulelist){
			//停用模块剔除
			if(mod.getState()!=1){
//				modulelist.remove(mod) ;
				continue ;
			}
			//拼接文件夹
			if(mod.getType()==1){
				buf.append("d.add(").append(mod.getId()).append(",")
				.append(mod.getParentid()).append(",'")
				.append(mod.getName()).append("','','")
				.append(mod.getName()).append("');\r\n") ;
//				modulelist.remove(mod) ;
			}
		}
		for(Module mod:modulelist){
			//停用模块剔除
			if(mod.getState()!=1){
				continue ;
			}
			//拼接文件目录
			if(mod.getType()!=1){
				buf.append("d.add(").append(mod.getId()).append(",")
				.append(mod.getParentid()).append(",'")
				.append(mod.getName()).append("','")
				.append(mod.getUrl()).append("','")
				.append(mod.getName()).append("','main');\r\n") ;
//				modulelist.remove(mod) ;
			}
		}
		this.setModulelist(buf.toString()) ;
		return "left" ;
	}

	public String right(){
		return "right" ;
	}
	public List<Systems> getSystems() {
		return systems;
	}
	public void setSystems(List<Systems> systems) {
		this.systems = systems;
	}
	public ModuleService getModService() {
		return modService;
	}
	public void setModService(ModuleService modService) {
		this.modService = modService;
	}
	public String getModulelist() {
		return modulelist;
	}
	public void setModulelist(String modulelist) {
		this.modulelist = modulelist;
	}
	
	
	
}
