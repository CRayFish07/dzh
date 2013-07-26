package com.sys.spring.dao.img.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.img.ImagesDao;
import com.sys.spring.domain.img.Images;
import com.sys.util.ImageUtils;


public class ImagesDaoImpl extends AbstractDBDao implements ImagesDao {
	private static final Logger log = Logger.getLogger(ImagesDaoImpl.class);
	
	/**
	 * 删除图片
	 */
	public int deleteImagesByID(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "delete from images where ID=?" ;
		Object[] params = {id} ;
		int result = super.update(sqlStr, params) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	/**
	 * 图片添加
	 */
	public int insertImages(Images images) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		try {
			this.dealImage(images) ;
			
			String sqlStr = "insert into images (NAME,info,tag,date,DATA,type,imagetype) values(?,?,?,?,?,?,?)" ;
			conn = this.getJdbc().getDataSource().getConnection() ;
			pstmt = conn.prepareStatement(sqlStr) ;
			pstmt.setString(1, images.getName()) ;
			pstmt.setString(2, images.getInfo()) ;
			pstmt.setString(3, images.getTag()) ;
			pstmt.setString(4, images.getDate()) ;
//			pstmt.setBinaryStream(5, new FileInputStream(images.getFile()), (int) images.getFile().length());
			pstmt.setBinaryStream(5, new ByteArrayInputStream(images.getData()), images.getData().length);
			pstmt.setInt(6, images.getType()) ;
			pstmt.setString(7, images.getImagetype()) ;
			
			int result = pstmt.executeUpdate() ;
			
			buf.append("|").append(sqlStr)
			.append("|").append(result)
			.append("|").append(System.currentTimeMillis()-start) ;
			log.info(buf.toString()) ;
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		    try {
				pstmt.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				conn.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}

	/**
	 * 按ID查询
	 */
	public Images selectImagesByID(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from images where id = ? ";
		Object[] params = {id} ;
		Images result = super.selectObject(sqlStr,params, Images.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result==null?0:1)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	/**
	 * 按条件查询
	 */
	public List<Images> selectImagessByImages(Images images) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select id,name,info,tag,date,imagetype,type,state from images where 1=1") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		
		if(images.getName()!=null){
			sqlStr.append(" and name = ?") ;
			params.add(images.getName()) ;
		}
		if(images.getTag()!=null){
			sqlStr.append(" and tag = ?") ;
			params.add(images.getTag()) ;
		}
		if(images.getType()>0){
			sqlStr.append(" and type = ?") ;
			params.add(images.getType()) ;
		}
		if(images.getDate()!=null){
			sqlStr.append(" and date(date) = ?") ;
			params.add(images.getDate()) ;
		}
		if(images.getTypes()!=null){
			sqlStr.append(" and type in ("+images.getTypes()+")") ;
		}
		sqlStr.append(" order by type,id") ;
		List<Images> result = super.selectList(sqlStr.toString(), params.toArray(), Images.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result!=null?result.size():0)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}

	/**
	 * 更新
	 */
	public int updateImages(Images images) {
		if(images.getFile()!=null){
			this.dealImage(images) ;
			return this.updateImageData(images) ;
		} else {
			return this.updateImageInfo(images) ;
		}
	}
	/**
	 * 更新图片信息
	 * @param images
	 * @return
	 */
	private int updateImageInfo(Images images){
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update images set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(images.getName()!=null){
			sqlStr.append(" name=?,") ;
			params.add(images.getName()) ;
		}
		if(images.getTag()!=null){
			sqlStr.append(" tag=?,") ;
			params.add(images.getTag()) ;
		}
		if(images.getInfo()!=null){
			sqlStr.append(" info=?,") ;
			params.add(images.getInfo()) ;
		}
		if(images.getDate()!=null){
			sqlStr.append(" date=?,") ;
			params.add(images.getDate()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(images.getId()) ;
		
		int result = update(sql, params.toArray()) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis()-start) ;
		log.info(buf.toString()) ;
		return result ;
	}
	/**
	 * 更新图片数据
	 * @param images
	 * @return
	 */
	private int updateImageData(Images images){
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		try {
			String sqlStr = "update images set  data=? ,imagetype=? where id=?" ;
			conn = this.getJdbc().getDataSource().getConnection() ;
			pstmt = conn.prepareStatement(sqlStr) ;
			pstmt.setBinaryStream(1, new ByteArrayInputStream(images.getData()), images.getData().length);
			pstmt.setString(2, images.getImagetype()) ;
			pstmt.setInt(3, images.getId()) ;
			
			int result = pstmt.executeUpdate() ;
			
			buf.append("|").append(sqlStr)
			.append("|").append(result)
			.append("|").append(System.currentTimeMillis()-start) ;
			log.info(buf.toString()) ;
			return result ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		    try {
				pstmt.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				conn.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * 照片处理
	 * 照片压缩大小，限制照片大小不超过1000像素
	 * @param images
	 */
	private void dealImage(Images images){
		try {
			BufferedImage src = ImageIO.read(images.getFile()) ;
            int width = src.getWidth(); // 得到源图宽
            int height = src.getHeight(); // 得到源图长
            int size = 1000 ;
            if(width>size || height>size){
            	double rank = width*1.0/height ;
            	if(width>height){
            		width = size ;
            		height = (int)(height/rank) ;
            	} else {
            		height = size ;
            		width = (int)(height*rank) ;
            	}
            }
//            src.getType() ;

        	byte[] stream = ImageUtils.scale2(images.getFile(), height, width, false) ;
        	images.setData(stream) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
