package com.gzb.game.encode;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gzb.game.xy.XYConstraints;
import com.gzb.game.xy.XYLayout;

public class PaintPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4788845512877490383L;
	XYLayout xYLayout1 = new XYLayout();

	JTextField text = new JTextField() ;
	JLabel label2 = new JLabel("") ;
	JComboBox box = new JComboBox();
	
	public PaintPanel() {
		XYLayout xYLayout1 = new XYLayout();
		xYLayout1.setWidth(400);
		xYLayout1.setHeight(200);
		this.setLayout(xYLayout1);
		this.setBackground(SystemColor.LIGHT_GRAY);
//		this.setBackground(SystemColor.controlLtHighlight);
        
//		JLabel label = new JLabel("字符串") ;
//		label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
		box.addItem("GBK") ;
		box.addItem("UTF-8") ;
		box.addItem("md5") ;
		
		JButton button = new JButton("转码") ;
		button.addActionListener(new ButtonActionAdapter());
		
//		this.add(label, new XYConstraints(0, 10, 100, 20));
		this.add(text, new XYConstraints(5, 10 , 200 ,20 ));
		this.add(box, new XYConstraints(211, 10 , 60 ,20 ));
		this.add(button, new XYConstraints(275, 10 , 60 ,20 ));
		this.add(label2, new XYConstraints(10, 50 , 300 ,20 ));
	}
	
	public void but_actionPerformed(ActionEvent e) {
    	String key = text.getText() ;
    	String enc = box.getSelectedItem().toString() ;
		try {
			if(enc.equals("md5")){
				MD5 md5 = new MD5();  
		        key = md5.getMD5ofStr(key);  
//				key = org.apache.commons.codec.digest.DigestUtils.md5Hex(key) ;
			} else {
				key = java.net.URLEncoder.encode(key, enc ) ;
			}
	    	this.label2.setText(key) ;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
    }

	class ButtonActionAdapter implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        but_actionPerformed(e) ;
	    }
	}
}

