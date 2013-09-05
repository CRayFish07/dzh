package com.gzb.game;

import java.applet.Applet;
import java.awt.Graphics;
import java.io.IOException;

/**
 * 计算器
 * @author Administrator
 *
 */
public class JiSuanQi extends Applet {
	public void paint(Graphics g) {
        g.drawRect(0, 0, 499, 149);
        g.drawString("Hello World", 5, 70);
	 }
	 /**
	  * 通过applet调用本地的计算器
	  */
	 public void openApp() {
	        String url = "C://WINDOWS//system32//calc.exe";
	        System.out.println("url=" + url);
	        try {
	               Runtime.getRuntime().exec(url);
	        } catch (IOException e) {
	               e.printStackTrace();
	        }
	 }
}
