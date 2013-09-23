package com.gzb.game.photodeal;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifDirectory;

public class DealImageDao {
	private String path = "g:/img/" ;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DealImageDao dao = new DealImageDao() ;
		
		File dir = new File(dao.path) ;;
		dao.dealFiles(dir) ;
//		File file = new File("g:/img/IMG_20130922_102025.jpg") ;
//		dao.dealImage(file) ;
	}
	
	/**
	 * 处理文件夹
	 * @param dir
	 */
	public void dealFiles(File dir){
		if(dir.isDirectory()){
			File[] list = dir.listFiles() ;
			for(File f :list){
				try {
					if(f.isFile()){
						this.dealImage(f) ;
					} else {
						this.dealFiles(f) ;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 处理图片
	 * @param file
	 * @throws IOException
	 */
	private void dealImage(File file) throws IOException{
		BufferedImage src = ImageIO.read(file) ;
        
		int x = 10;
		int y = 100;
		String str = file.getName() ;
		if(str.startsWith("deal")){
			return ;
		}
		
		String text = file.getParentFile().getName() ;
//		if(str.matches("IMG_20(.*?)jpg")){
//			String name = str.substring(4,19) ;	//IMG_20130922_102025
//			name = name.substring(0,8)+" "+ name.substring(9,11)+":"+name.substring(11,13)+":"+name.substring(13,15) ;
//			text += "_"+name ;
//		} else {
//			
//		}
		text += " "+this.getPhotoDate(file) ;	//打印水印 标题+日期
		src = this.addMark(src, text , x, y) ;
        
		File outdir = new File(path, "deal_"+str) ;
        ImageIO.write(src, "JPEG", outdir);// 输出到文件流
	}
	
	/**
	 * 加水印
	 * @param image
	 * @param text
	 * @param x
	 * @param y
	 * @return
	 */
	private BufferedImage addMark(BufferedImage image, String text, int x, int y){
		Color color = Color.black ;	// Color.white ;	//水印的字体颜色
        String fontName = "隶书";		//水印的字体名称
		int fontStyle = Font.ITALIC ;	//水印的字体样式
		int fontSize = 100 ;			//水印的字体大小
        float alpha = 0.7f ;			//
        try {
//            int width = src.getWidth(null);
//            int height = src.getHeight(null);
//            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
//            g.drawImage(src, 0, 0, width, height, null);
            g.drawImage(image, null, 0, 0) ;
            
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 在指定坐标绘制水印文字
            g.drawString(text, x, y);
            g.dispose();
            
            return image ;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	/**
	 * 获取照片拍摄时间
	 * @param file
	 * @return
	 */
	private String getPhotoDate(File file){
		Metadata metadata;
		try {
			metadata = JpegMetadataReader.readMetadata(file);
	        Directory exif = metadata.getDirectory(ExifDirectory.class);
	        
	        
	        String model = exif.getString(ExifDirectory.TAG_DATETIME_ORIGINAL);
	        System.out.println(model);
//	        
//	        Iterator tags = exif.getTagIterator();
//	        while (tags.hasNext()) {
//	        	
//	            Tag tag = (Tag)tags.next();
//	            System.out.println(tag);
//	        }
	        return model ;
		} catch (JpegProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return "" ;
	}
}
