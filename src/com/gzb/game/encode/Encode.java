package com.gzb.game.encode;

import java.applet.Applet;

public class Encode extends Applet {

	/**
	 * 字符串编码
	 * 支持GBK UTF8编码 和md5编码
	 */
	private static final long serialVersionUID = -3686041319497537761L;

	public void init(){
		this.setSize(400,200) ;
		PaintPanel paintPanel = new PaintPanel() ;
		
		add(paintPanel) ;
	}
	
}
