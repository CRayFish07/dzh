package com.sys.spring.service.img;

import java.util.List;

import com.sys.spring.domain.img.ImageType;

public interface ImageTypeService {

	public int insertImageType(ImageType obj) ;
	public int updateImageType(ImageType obj) ;
	public List<ImageType> getAllImageType() ;
	public ImageType getImageTypeById(int uid) ;
	public List<ImageType> getImageTypeByParentid(int id) ;
	
	
}
