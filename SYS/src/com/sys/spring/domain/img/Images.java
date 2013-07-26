package com.sys.spring.domain.img;

import java.io.File;

public class Images {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 171L;
	
	private int id ;
	private String name ;	//图片名
	private String info ;	//介绍
	private String tag ;	//标签
	private String date ;	//日期
	private byte[] data ;	//字节数据
	private String imagetype ;	//图片类型
	private int type ;	//目录ID
	private int state ;	//状态
	private File file ;	//文件数据
	
	private String types ;	//多目录查询参数
	private ImageType imgtype ;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getImagetype() {
		return imagetype;
	}
	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public ImageType getImgtype() {
		return imgtype;
	}
	public void setImgtype(ImageType imgtype) {
		this.imgtype = imgtype;
	}
	
}
