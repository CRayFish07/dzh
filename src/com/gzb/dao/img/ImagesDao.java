package com.gzb.dao.img;

import java.util.List;

import com.gzb.domain.img.Images;

public interface ImagesDao {

	public abstract int insertImages(Images Images) ;	//新增用户
	public abstract int updateImages(Images Images) ;	//修改用户信息
	public abstract Images selectImagesByID(int id) ;	//按ID查询用户
	public abstract List<Images> selectImagessByImages(Images Images) ;	//按条件查询
	public abstract int deleteImagesByID(int id) ;
	
}
