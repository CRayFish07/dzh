package com.sys.spring.domain.img;

import java.util.ArrayList;
import java.util.List;

public class ImageType {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 17L;
	
	private int id ;
	private String name ;		//文件夹名
	private String info ;		//简介
	private int parentid = -1 ;	//上级文件夹ID
	
	private String fullname ;	//文件夹全名
	private List<ImageType> sublist = new ArrayList<ImageType>() ;		//子目录
	private List<ImageType> parentlist = new ArrayList<ImageType>() ;	//上级目录
	private List<Images> imagelist = new ArrayList<Images>() ;			//照片集
	private List<Images> allimagelist = new ArrayList<Images>() ;		//全部照片集，包括子文件夹下
	
	private int sub ;	//子相册数
	private int photo ;	//招聘数
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getSub() {
		return sub;
	}
	public void setSub(int sub) {
		this.sub = sub;
	}
	public int getPhoto() {
		return photo;
	}
	public void setPhoto(int photo) {
		this.photo = photo;
	}
	public List<ImageType> getSublist() {
		return sublist;
	}
	public void setSublist(List<ImageType> sublist) {
		this.sublist = sublist;
	}
	public List<ImageType> getParentlist() {
		return parentlist;
	}
	public void setParentlist(List<ImageType> parentlist) {
		this.parentlist = parentlist;
	}
	public List<Images> getImagelist() {
		return imagelist;
	}
	public void setImagelist(List<Images> imagelist) {
		this.imagelist = imagelist;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public List<Images> getAllimagelist() {
		return allimagelist;
	}
	public void setAllimagelist(List<Images> allimagelist) {
		this.allimagelist = allimagelist;
	}
	
}
