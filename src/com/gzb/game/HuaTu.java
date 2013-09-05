package com.gzb.game;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 进化论
 * @author Administrator
 *
 */
public class HuaTu extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9172794534557860218L;

//	public void paint(Graphics g) {
////		g.drawString ("你好,Java世界！",2,20);
//		
//		g.drawRect(0,0,250,100);
//		g.setColor(Color.blue);
//		g.drawString("Look at me, I'm a Java Applet!",10,50);
//	}
	
	JColorChooser colorChooser;
	ColorSelectionModel model;
	JLabel label;
	ChangeListener changeListener;
	public void init() {       //init()方法创建组件
		label = new JLabel("我爱Java", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 48));
		add(label, BorderLayout.SOUTH);
		colorChooser = new JColorChooser(label.getBackground());
		colorChooser.setBorder(BorderFactory.createTitledBorder("选择您喜欢的颜色"));
		add(colorChooser, BorderLayout.CENTER);
		changeListener = new ChangeListener() {   //事件处理
			public void stateChanged(ChangeEvent changeEvent) {
			Color newForegroundColor = colorChooser.getColor();
			label.setForeground(newForegroundColor);
			}
		};
		model = colorChooser.getSelectionModel();
		model.addChangeListener(changeListener);
	}
}
