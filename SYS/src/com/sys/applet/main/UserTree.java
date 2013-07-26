package com.sys.applet.main;

import javax.swing.JButton;

import com.sys.applet.ConstService;
import com.sys.applet.main.user.ListUserPanel;
import com.sys.applet.main.user.RegisterUserPanel;
import com.sys.applet.main.user.UpdateUserPanel;

/** 
 * by dyong 2010-9-1
 */
public class UserTree extends TreePanel {
	private static final long serialVersionUID = 2738010164904409693L;
	JButton registerButton = new JButton();
	JButton listButton = new JButton();
	
	public UserTree() {
//	    if(ConstService.user.getRole().equals("1")){
	    	registerButton.setText("用户注册");
		    registerButton.addActionListener(new ButtonActionAdapter(new RegisterUserPanel()));
		    listButton.setText("信息修改");
		    ButtonActionAdapter listAction = new ButtonActionAdapter(new ListUserPanel());
		    listButton.addActionListener(listAction);
		    
		    new ButtonActionAdapter(new RegisterUserPanel()) ;
//	    } else {
		    registerButton.setText("信息修改");
		    registerButton.addActionListener(new ButtonActionAdapter(new UpdateUserPanel(ConstService.user.getId(),"update")));
		    listButton.setText("密码修改");
		    listButton.addActionListener(new ButtonActionAdapter(new UpdateUserPanel(ConstService.user.getId(),"pwd")));
		    
		    new ButtonActionAdapter(new UpdateUserPanel(ConstService.user.getId(),"update"));
//	    }
	    buttonList.add(registerButton);
	    buttonList.add(listButton);
	    
	    super.printButton() ;
	}
	
}
