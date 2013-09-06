package com.gzb.game.evolution.service;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 生物体
 * @author Administrator
 *
 */
public class Organism {

	private int type = 0 ;		//类型： 植物 0， 动物 1 
	private int leve = 0 ;		//等级
	private int x ;				//x坐标
	private int y ;				//y坐标

	private JLabel label = new JLabel() ;		//
	
	public Organism(int x,int y){
		this(x, y, 0) ;
	}
	
	public Organism(int x,int y,int leve){
		this.x = x ;
		this.y = y ;
		this.leve = leve ;
		
		this.setLabel() ;
	}
	
	public int change(int leve){
		this.leve = leve ;
		
		this.setLabel() ;
		return 0 ;
	}

	public void setLabel() {
		URL file = this.getClass().getResource("/com/gzb/game/evolution/image/"+type+leve+".jpg") ;
		ImageIcon icon = new ImageIcon(file);
		this.label.setIcon(icon) ;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLeve() {
		return leve;
	}
	public void setLeve(int leve) {
		this.leve = leve;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
