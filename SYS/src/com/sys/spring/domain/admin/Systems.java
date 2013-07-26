package com.sys.spring.domain.admin;

/**
 * 关联系统
 * @author Administrator
 *
 */
public class Systems {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 13L;
	
	private int id ;
	private String name ;
	private String url ;
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
	
}
