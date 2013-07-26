package com.sys.web.struts2.image;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sys.spring.domain.img.ImageType;
import com.sys.spring.domain.img.Images;
import com.sys.spring.service.img.ImageTypeService;
import com.sys.spring.service.img.ImagesService;
import com.sys.web.struts2.BaseAction;

public class ImagesAction extends BaseAction{
	private static final long serialVersionUID = -1761856308311431565L;
	
	private ImagesService imagesService ;
	private ImageTypeService imageTypeService ;
	
	private Images img = new Images() ;
	private List<Images> list ;
	private List<ImageType> typelist ;

	private File image ;
	private String imageFileName;//获取上传文件名称  
    private String imageContentType;//获取上传文件类型  
    private Images next = new Images() ;
	
	/**
	 * 图片列表
	 * @return
	 */
	public String list(){
		typelist = imageTypeService.getAllImageType() ;
		
		if(img.getType()==0){
			img.setType(typelist.get(0).getId()) ;
		}
		ImageType tree = imageTypeService.getImageTypeById(img.getType()) ;
		if(tree!=null){
			List<Integer> types = new ArrayList<Integer>() ;
			Hashtable<Integer,ImageType> table = new Hashtable<Integer,ImageType>() ;
			this.gettypes(tree,types,table) ;
			list = imagesService.getImagesBytypes(types) ;
			for(Images img:list){
				img.setImgtype(table.get(img.getType())) ;
			}
		}
		return LIST ;
	}
	//图片添加、目录选择
	public String add(){
		typelist = imageTypeService.getImageTypeByParentid(img.getType()) ;
		return ADD ;
	}
	//照片添加页面
	public String add2(){
		
		return "add2" ;
	}
	//照片信息入库
	public String addup(){
		int result = 0 ;
		if(img.getId()>0){
			if(image!=null){
				img.setName(imageFileName) ;
		    	img.setFile(image) ;
		    	img.setImagetype(imageContentType) ;
			}
			result = imagesService.updateImages(img) ;
		} else {
			img.setName(imageFileName) ;
	//    	img.setData(this.getFileByte(image)) ;
	    	img.setFile(image) ;
	    	img.setImagetype(imageContentType) ;
	    	
	    	if(img.getDate()==null || img.getDate().trim().length()==0){
//	    		long time = image.lastModified() ;
//	    		String datetime = datetimeFormatter.format(new Date(time)) ;
//	    		img.setDate(datetime) ;
	    	}
			result = imagesService.insertImages(img) ;
		}
		if(result==1){
			return list() ;
		}
		return list() ;
	}
	//照片修改页面
	public String update(){
		img = imagesService.getImagesById(img.getId()) ;
		return add2() ;
	}
	//照片删除页面
	public String del(){
		int re = imagesService.deleteImages(img.getId()) ;
		this.setMessage(String.valueOf(re)) ;
		return RESULT ;
	}
	//照片展示
	public String img(){
		try {
			img = imagesService.getImagesById(img.getId()) ;
			if(img!=null){
				HttpServletResponse response = ServletActionContext.getResponse() ;
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				response.setContentType("image/png");
				response.getOutputStream().write(img.getData()) ;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return INDEX ;
	}
	//照片展示
	public String show(){

		ImageType tree = imageTypeService.getImageTypeById(img.getType()) ;
		Hashtable<Integer,ImageType> table = new Hashtable<Integer,ImageType>() ;
		if(tree!=null){
			List<Integer> types = new ArrayList<Integer>() ;
			this.gettypes(tree,types,table) ;
			list = imagesService.getImagesBytypes(types) ;
		}
		boolean b = false ;
		for(Images i:list){
			if(b){
				this.next = i ;
				i.setImgtype(table.get(i.getType())) ;
				break ;
			}
			if(i.getId()==img.getId()){
				b = true ;
				img.setImgtype(table.get(img.getType())) ;
			}
		}
		return "show" ;
	}

	private void gettypes(ImageType imgtype,List<Integer> list,Hashtable<Integer,ImageType> table){
		list.add(imgtype.getId()) ;
		table.put(imgtype.getId(), imgtype) ;
		if(imgtype.getSublist().size()>0){
			for(ImageType t:imgtype.getSublist()){
				this.gettypes(t,list,table) ;
			}
		}
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
	public List<Images> getList() {
		return list;
	}
	public void setList(List<Images> list) {
		this.list = list;
	}
	public List<ImageType> getTypelist() {
		return typelist;
	}
	public void setTypelist(List<ImageType> typelist) {
		this.typelist = typelist;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public Images getNext() {
		return next;
	}
	public void setNext(Images next) {
		this.next = next;
	}


}
