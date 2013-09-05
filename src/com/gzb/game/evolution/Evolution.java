package com.gzb.game.evolution;

import java.applet.Applet;

public class Evolution extends Applet {

	/**
	 * 进化论游戏
	 */
	private static final long serialVersionUID = -3686041319497537761L;

	public void init(){
		this.setSize(Const.width,Const.height) ;
		MainPanel paintPanel = new MainPanel() ;
		add(paintPanel) ;
	}
	
}
