package com.sys.web.struts2.image;

import java.util.List;

import com.sys.spring.domain.img.ImageType;
import com.sys.spring.service.img.ImageTypeService;
import com.sys.web.struts2.BaseAction;


public class ImageTypeAction extends BaseAction{
	private static final long serialVersionUID = -176185630831141565L;
	
	private ImageTypeService imageTypeService ;
	
	private ImageType type = new ImageType() ;
	private List<ImageType> list ;
	
	/**
	 * 列表
	 * @return
	 */
	public String list(){
		list = imageTypeService.getAllImageType() ;
		return LIST ;
	}
	public String add(){
		list = imageTypeService.getAllImageType() ;
		return ADD ;
	}
	public String addup(){
		int result = 0 ;
		if(type.getId()==0){
			result = imageTypeService.insertImageType(type) ;
		} else if(type.getId()>0){
			result = imageTypeService.updateImageType(type) ;
		}
		if(result==1){
			return list() ;
		}
		
		return ADD ;
	}
	public String update(){
		type = imageTypeService.getImageTypeById(type.getId()) ;
		return add() ;
	}
	
	public ImageTypeService getImageTypeService() {
		return imageTypeService;
	}
	public void setImageTypeService(ImageTypeService imageTypeService) {
		this.imageTypeService = imageTypeService;
	}
	public ImageType getType() {
		return type;
	}
	public void setType(ImageType type) {
		this.type = type;
	}
	public List<ImageType> getList() {
		return list;
	}
	public void setList(List<ImageType> list) {
		this.list = list;
	}

	
}
