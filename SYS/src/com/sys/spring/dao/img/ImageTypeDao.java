package com.sys.spring.dao.img;

import java.util.List;

import com.sys.spring.domain.img.ImageType;

/**
 * 照片分类管理
 * @author Administrator
 *
 */
public interface ImageTypeDao {

	public abstract int insertImageType(ImageType ImageType) ;	//新增用户
	public abstract int updateImageType(ImageType ImageType) ;	//修改用户信息
	public abstract ImageType selectImageTypeByID(int id) ;	//按ID查询用户
	public abstract List<ImageType> selectImageTypesByImageType(ImageType ImageType) ;	//按条件查询
	
}
