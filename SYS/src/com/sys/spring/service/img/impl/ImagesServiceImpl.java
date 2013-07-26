package com.sys.spring.service.img.impl;

import java.util.List;

import com.sys.spring.dao.img.ImagesDao;
import com.sys.spring.domain.img.Images;
import com.sys.spring.service.img.ImagesService;

public class ImagesServiceImpl implements ImagesService {
	private ImagesDao dao ;
	
	public ImagesDao getDao() {
		return dao;
	}
	public void setDao(ImagesDao dao) {
		this.dao = dao;
	}
	public int insertImages(Images obj) {
		// TODO Auto-generated method stub
		return dao.insertImages(obj) ;
	}
	public int updateImages(Images obj) {
		// TODO Auto-generated method stub
		return dao.updateImages(obj) ;
	}
	public int deleteImages(int id) {
		// TODO Auto-generated method stub
		return dao.deleteImagesByID(id) ;
	}
	public List<Images> getAllImages() {
		// TODO Auto-generated method stub
		return dao.selectImagessByImages(new Images()) ;
	}
	public Images getImagesById(int id) {
		// TODO Auto-generated method stub
		return dao.selectImagesByID(id) ;
	}
	public List<Images> getImagesByImages(Images obj) {
		// TODO Auto-generated method stub
		return dao.selectImagessByImages(obj) ;
	}
	public List<Images> getImagesBytype(int type) {
		// TODO Auto-generated method stub
		Images img = new Images() ;
		img.setType(type) ;
		return dao.selectImagessByImages(img) ;
	}
	/**
	 * 按多目录查询
	 */
	public List<Images> getImagesBytypes(List<Integer> type) {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer() ;
		for(int i=0;i<type.size();i++){
			buf.append(type.get(i)) ;
			if((i+1)<type.size()){
				buf.append(",") ;
			}
		}
		Images img = new Images() ;
		img.setTypes(buf.toString()) ;
		return dao.selectImagessByImages(img) ;
	}

}
