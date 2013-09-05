package com.gzb.game;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LittlePainterApplet extends Applet {
	  
	   private JColorChooser colorChooser;  
	   private ColorSelectionModel model;  
	   private ChangeListener changeListener;  
	   private Color color;  
	 
	   public void init() {                                 //覆盖init()  
	      PaintPanel paintPanel = new PaintPanel();         //创建控制板  
	 
	      colorChooser = new JColorChooser();  
	      add(colorChooser, BorderLayout.NORTH);  
	 
	      changeListener = new ChangeListener() {           //事件处理  
	            public void stateChanged(ChangeEvent changeEvent) {  
	                color = colorChooser.getColor();  
	            }  
	      };  
	      model = colorChooser.getSelectionModel();  
	      model.addChangeListener(changeListener);          //注册事件处理  
	      colorChooser.setPreviewPanel(paintPanel);  
	      add(paintPanel, BorderLayout.CENTER );            //注册显示  
	   }  
	class PaintPanel extends JPanel {                       //内部类控制板  
	    private int xValue, yValue;  
	    JTextArea textArea;  
	 
	    PaintPanel() {  
	        add(new Label( "用鼠标按下空白区，然后按下回车开始。 " 
	                        + " 按下回车清除绘画。"), BorderLayout.NORTH );  
	 
	        textArea = new JTextArea(14, 35);  
	        setVisible(true);  
	 
	        add(textArea, BorderLayout.SOUTH);  
	        textArea.addMouseMotionListener(  
	            new MouseMotionAdapter() {  
	                public void mouseDragged( MouseEvent e ) {  
	                       xValue = e.getX();  
	                       yValue = e.getY() + 20;  
	                       repaint();           //调用repaint()  
	                 }  
	            }  
	      );  
	    }  
	    public void paint( Graphics g ) {   //覆盖paint()，或paintComponent()  
	          g.setColor(color);  
	          g.fillOval( xValue, yValue, 4, 4 );  
	       }  
	  }  
}
