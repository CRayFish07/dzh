package com.sys.web.struts2.image;

import java.io.File;
import java.sql.Date;

import com.sys.spring.domain.img.Images;
import com.sys.spring.service.img.ImageTypeService;
import com.sys.spring.service.img.ImagesService;
import com.sys.web.struts2.BaseAction;


/**
 * 文件批量上传功能
 * @author dyong
 *
 */
public class ImagesUploadAction extends BaseAction{
	private static final long serialVersionUID = -17618563083114565L;
	
	private ImagesService imagesService ;
	private ImageTypeService imageTypeService ;
	
	private Images img = new Images() ;

	private File Filedata ;
	private String FiledataFileName;//获取上传文件名称  
    private String FiledataContentType;//获取上传文件类型  
    private String Filename;//获取上传文件类型  

	public String execute(){
		return INDEX ;
	}
	public String add(){
		img.setName(FiledataFileName) ;
//    	img.setData(this.getFileByte(image)) ;
    	img.setFile(Filedata) ;
    	img.setImagetype("image") ;
    	
    	if(img.getDate()==null || img.getDate().trim().length()==0){
    		long time = Filedata.lastModified() ;
    		String datetime = datetimeFormatter.format(new Date(time)) ;
    		img.setDate(datetime) ;
    	}
		imagesService.insertImages(img) ;
		return SUCCESS ;
	}
	
	public ImagesService getImagesService() {
		return imagesService;
	}
	public void setImagesService(ImagesService imagesService) {
		this.imagesService = imagesService;
	}
	public ImageTypeService getImageTypeService() {
		return imageTypeService;
	}
	public void setImageTypeService(ImageTypeService imageTypeService) {
		this.imageTypeService = imageTypeService;
	}
	public Images getImg() {
		return img;
	}
	public void setImg(Images img) {
		this.img = img;
	}
	public File getFiledata() {
		return Filedata;
	}
	public void setFiledata(File filedata) {
		Filedata = filedata;
	}
	public String getFiledataFileName() {
		return FiledataFileName;
	}
	public void setFiledataFileName(String filedataFileName) {
		FiledataFileName = filedataFileName;
	}
	public String getFiledataContentType() {
		return FiledataContentType;
	}
	public void setFiledataContentType(String filedataContentType) {
		FiledataContentType = filedataContentType;
	}
	public String getFilename() {
		return Filename;
	}
	public void setFilename(String filename) {
		Filename = filename;
	}

}
