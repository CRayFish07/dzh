package com.sys.spring.domain.admin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色
 * @author dyong
 *
 */
public class Rolse {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 12L;
	
	private int id ;
	private String rolse ;
	private String info ;
	private String modules ;
	private int state ;
	private List<Module> modulelist = new ArrayList<Module>() ;
	private int[] moduleid ;
	private Set<Integer> moduleids = new HashSet<Integer>() ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolse() {
		return rolse;
	}
	public void setRolse(String rolse) {
		this.rolse = rolse;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getModules() {
		return modules;
	}
	public void setModules(String modules) {
		this.modules = modules;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<Module> getModulelist() {
		return modulelist;
	}
	public void setModulelist(List<Module> modulelist) {
		this.modulelist = modulelist;
	}
	public int[] getModuleid() {
		return moduleid;
	}
	public void setModuleid(int[] moduleid) {
		this.moduleid = moduleid;
	}
	public Set<Integer> getModuleids() {
		return moduleids;
	}
	public void setModuleids(Set<Integer> moduleids) {
		this.moduleids = moduleids;
	}
	
}
