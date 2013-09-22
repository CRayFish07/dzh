package com.gzb.game.photodeal;

import java.applet.Applet;

import com.gzb.game.evolution.Const;

public class DealPhoto extends Applet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1765675L;

	public void init(){
		this.setSize(Const.width,Const.height) ;
		DealPanel panel = new DealPanel() ;
		add(panel) ;
	}
}

