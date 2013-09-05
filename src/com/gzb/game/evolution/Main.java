package com.gzb.game.evolution;

import java.applet.Applet;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

public class Main extends Applet {

	private String imagePath = System.getProperty("user.dir")+"/src/com/gzb/game/evolution/image/" ;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6335542905272687433L;

	public void init(){
//		JLabel label = new JLabel("我爱Java", JLabel.CENTER);
//		label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 48));
//		add(label, BorderLayout.SOUTH);
		
	}
	
	public void paint(Graphics g){
		int size = 6 ;
		int len = 50 ;

		URL file = this.getClass().getResource("image/0.jpg") ;
		ImageIcon icon=new ImageIcon(file);

		g.drawString(file.toString(), 0, 400) ;
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
//				ImageIcon icon=new ImageIcon(imagePath+"0.jpg");
				g.drawImage(icon.getImage(),len*j,len*i,len,len,this);
			}
		}
	}
	
//	public static void main(String[] args) throws IOException{
//		String file = System.getProperty("user.dir")+"/src/com/gzb/game/evolution/image/0.jpg" ;
//		System.out.println(file) ;
//		File f = new File(file) ;
//		System.out.println(file) ;
//		
//		InputStream is = new FileInputStream(f);
//		BufferedInputStream bis = new BufferedInputStream(is);
//		
//		byte[] b1=new byte[1024*1000];//设一个1024*bufferSize字节的数组 
//		int read=0;
//		while((read=bis.read(b1))!=-1){
//		}
//		System.out.println();
//		
//	}
}