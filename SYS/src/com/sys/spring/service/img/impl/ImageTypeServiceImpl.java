package com.sys.spring.service.img.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.img.ImageTypeDao;
import com.sys.spring.domain.img.ImageType;
import com.sys.spring.domain.img.Images;
import com.sys.spring.service.img.ImageTypeService;
import com.sys.spring.service.img.ImagesService;

public class ImageTypeServiceImpl implements ImageTypeService {
	private ImageTypeDao dao ;
	private ImagesService imagesService ;
	private static final Logger log = Logger.getLogger(ImageTypeServiceImpl.class);
	
	public ImageTypeDao getDao() {
		return dao;
	}
	public void setDao(ImageTypeDao dao) {
		this.dao = dao;
	}
	public ImagesService getImagesService() {
		return imagesService;
	}
	public void setImagesService(ImagesService imagesService) {
		this.imagesService = imagesService;
	}
	
	/**
	 * 图片分类添加
	 */
	public int insertImageType(ImageType obj) {
		// TODO Auto-generated method stub
		return dao.insertImageType(obj) ;
	}
	
	/**
	 * 分类信息修改
	 */
	public int updateImageType(ImageType obj) {
		// TODO Auto-generated method stub
		return dao.updateImageType(obj) ;
	}
	
	/**
	 * 获取所有分类信息
	 */
	public List<ImageType> getAllImageType() {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		List<ImageType> list = dao.selectImageTypesByImageType(new ImageType()) ;
		for(ImageType type:list){
			this.getFullName(list, type ,type.getParentid()) ;
		}
		buf.append("|").append(list.size())
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return list ;
	}
	
	/**
	 * 按ID查询
	 */
	public ImageType getImageTypeById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		ImageType imgtype = dao.selectImageTypeByID(id) ;
		if(imgtype!=null){
			List<ImageType> list = dao.selectImageTypesByImageType(new ImageType()) ;
			this.deal(list,imgtype) ;
		}
		buf.append("|").append(id)
		.append("|").append(imgtype!=null?0:1)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return imgtype ;
	}
	
	/**
	 * 按上级ID查询
	 */
	public List<ImageType> getImageTypeByParentid(int id) {
		List<ImageType> list = dao.selectImageTypesByImageType(new ImageType()) ;

		ImageType ImageType = new ImageType() ;
		ImageType.setParentid(id) ;
		List<ImageType> result = dao.selectImageTypesByImageType(ImageType) ;
		
		for(ImageType type:result){
			this.deal(list, type) ;
		}
		return result ;
	}
	/**
	 * 后续处理，补充上级、下级文件夹信息、补充图片集信息等
	 * @param list
	 * @param imagetype
	 * @return
	 */
	private void deal(List<ImageType> list,ImageType imagetype){
		//计算下级文件夹数目
		for(ImageType it:list){
			//子文件夹
			if(it.getParentid()==imagetype.getId()){
				this.deal(list, it) ;
				imagetype.getSublist().add(it) ;
			}
			//父文件夹
			if(it.getId()==imagetype.getParentid()){
				imagetype.getParentlist().add(it) ;
			}
		}
		//计算子文件夹数
		imagetype.setSub(imagetype.getSublist().size()) ;
		//补充全名
		this.getFullName(list, imagetype ,imagetype.getParentid()) ;
		
		//计算文件夹下照片数目
		List<Images> imageslist = imagesService.getImagesBytype(imagetype.getId()) ;
		if(imageslist!=null){
			imagetype.setPhoto(imageslist.size()) ;
//			imagetype.setImagelist(imageslist) ;
		}
	}

	private void getFullName(List<ImageType> list,ImageType imagetype,int id){
		if(imagetype.getFullname()==null){
			imagetype.setFullname("/"+imagetype.getName()) ;
		}
		for(ImageType it:list){
			//父文件夹
			if(it.getId()==id){
				imagetype.setFullname("/"+it.getName()+imagetype.getFullname()) ;
				this.getFullName(list, imagetype,it.getParentid()) ;
			}
		} 
	}

}
