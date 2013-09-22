package com.gzb.game.photodeal;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DealImageDao {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DealImageDao dao = new DealImageDao() ;
		
		File dir = new File("g:/img/") ;;
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
		if(!str.matches("IMG_20(.*?)jpg")){
			return ;
		}
		str = str.substring(4,19) ;	//IMG_20130922_102025
		String name = file.getParentFile().getName() ;
		String s = name+"_"+str.substring(0,8)+" "+ str.substring(9,11)+":"+str.substring(11,13)+":"+str.substring(13,15) ;
		src = this.addMark(src, s , x, y) ;
        
		File outdir = new File(file.getParent()+"/"+str+".jpg") ;
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
		Color color = Color.cyan ;// Color.white ;	//水印的字体颜色
        String fontName = "宋体";		//水印的字体名称
		int fontStyle = Font.BOLD ;	//水印的字体样式
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
}
