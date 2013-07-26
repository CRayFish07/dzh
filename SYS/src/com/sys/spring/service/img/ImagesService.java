package com.sys.spring.service.img;

import java.util.List;

import com.sys.spring.domain.img.Images;

public interface ImagesService {

	public int insertImages(Images obj) ;
	public int updateImages(Images obj) ;
	public int deleteImages(int uid) ;
	public List<Images> getAllImages() ;
	public Images getImagesById(int uid) ;
	public List<Images> getImagesByImages(Images obj) ;
	public List<Images> getImagesBytype(int type) ;
	public List<Images> getImagesBytypes(List<Integer> type) ;

	
}
