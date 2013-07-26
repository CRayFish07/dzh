package com.sys.spring.domain.admin;

import java.util.List;

public class Userinfo {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 15L;
	
	private int id ;
	private int userid ;
	private String rolses ;
	private int state ;
	private int[] rolsesid ;
	private List<Rolse> rolselist ;
	private User user ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRolses() {
		return rolses;
	}
	public void setRolses(String rolses) {
		this.rolses = rolses;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int[] getRolsesid() {
		return rolsesid;
	}
	public void setRolsesid(int[] rolsesid) {
		this.rolsesid = rolsesid;
	}
	public List<Rolse> getRolselist() {
		return rolselist;
	}
	public void setRolselist(List<Rolse> rolselist) {
		this.rolselist = rolselist;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
