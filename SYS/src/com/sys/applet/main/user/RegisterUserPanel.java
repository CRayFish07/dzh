package com.sys.applet.main.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-9-1
 */
public class RegisterUserPanel extends CommonPanel{
	
//    text
    JTextField nameText = new JTextField();
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    
//    button
    JButton runBut = new JButton();
    JButton reBackBut = new JButton();
    
    public RegisterUserPanel() {

//       标签
        labList.add(new JLabel("Name:")) ;
        labList.add(new JLabel("UserName:")) ;
        labList.add(new JLabel("Password:")) ;
        
        fieldList.add(nameText) ;
        fieldList.add(userNameText) ;
        fieldList.add(passwordText) ;
        
//        按钮
        runBut.setText("提交");
        runBut.addActionListener(new RunButtonActionAdapter());
        buttonList.add(runBut) ;
        reBackBut.setText("取消");
        reBackBut.addActionListener(new ReBackButtonActionAdapter());
        buttonList.add(reBackBut) ;
        
        super.printFormModel() ;
    }

    private void rebackAction(ActionEvent e) {
    	clear() ;
    }
    private void submitAction(ActionEvent e) {
    	String message = "" ;
    	String name = nameText.getText().trim() ;
    	String username = userNameText.getText().trim() ;
    	String pwd = passwordText.getText().trim() ;
    	
    	if(name==null || name.length()==0 ||
    			username==null || username.length()==0
    			|| pwd==null || pwd.length()==0){
    		message = "请完整输入注册信息。" ;
    	} else {
	    	User user = new User() ;
	    	user.setName(name) ;
	    	user.setUsername(username) ;
	    	user.setPassword(pwd) ;
			int re = ConstService.userService.userRegister(user) ;
			
    		message = "注册成功" ;
    		clear() ;
    	}
    	jop.showMessageDialog(this, message) ;
    }
    private void clear(){
    	nameText.setText("") ;
    	userNameText.setText("") ;
    	passwordText.setText("") ;
    }

    class RunButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e) ;
        }
    }

    class ReBackButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            rebackAction(e);
        }
    }
    
}
