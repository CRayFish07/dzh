package com.gzb.dao.img;

import java.util.List;

import com.gzb.domain.img.ImageType;

public interface ImageTypeDao {

	public abstract int insertImageType(ImageType ImageType) ;	//新增用户
	public abstract int updateImageType(ImageType ImageType) ;	//修改用户信息
	public abstract ImageType selectImageTypeByID(int id) ;	//按ID查询用户
	public abstract List<ImageType> selectImageTypesByImageType(ImageType ImageType) ;	//按条件查询
	
}
