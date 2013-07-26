package com.sys.spring.domain.admin;

import java.util.ArrayList;
import java.util.List;


/**
 * 模块
 * @author dyong
 *
 */
public class Module {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 11L;
	private int id ;
	private String name ;
	private String url ;
	private int type ;
	private int parentid=-1 ;
	private int state ;
	private List<Module> sublist = new ArrayList<Module>() ;//下级
	private boolean checked = false ;	//是否选中
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Module> getSublist() {
		return sublist;
	}
	public void setSublist(List<Module> sublist) {
		this.sublist = sublist;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
