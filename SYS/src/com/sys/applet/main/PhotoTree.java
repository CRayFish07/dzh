package com.sys.applet.main;

import javax.swing.JButton;

import com.sys.applet.main.photo.AddPhotoPanel;
import com.sys.applet.main.photo.ListPhotoPanel;

/** 
 * by dyong 2010-9-1
 */
public class PhotoTree extends TreePanel {

	private static final long serialVersionUID = -4682160841650877776L;
	
	JButton addButton = new JButton();
	JButton listButton = new JButton();
	
	public PhotoTree() {
	    addButton.setText("添加照片");
	    addButton.addActionListener(new ButtonActionAdapter(new AddPhotoPanel()));
	    listButton.setText("查看照片");
	    listButton.addActionListener(new ButtonActionAdapter(new ListPhotoPanel()));

	    buttonList.add(addButton);
	    buttonList.add(listButton);
	    
	    super.printButton() ;
	    new ButtonActionAdapter(new AddPhotoPanel()) ;
//	    addAction.print() ;
	}
	
}


