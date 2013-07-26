package com.sys.applet.main.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-9-1
 */
public class UpdateUserPanel extends CommonPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1886265672027455983L;
	//    text
    JTextField nameText = new JTextField();
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JTextField roleText = new JTextField();
    JTextField rankText = new JTextField();
//    button
    JButton runBut = new JButton();
    JButton reBackBut = new JButton();
    
    User user ;
    String type ="update";
    public UpdateUserPanel(int uid,String type) {
    	this.type = type ;
        user = ConstService.userService.getUserById(uid) ;
        
//       标签
        labList.add(new JLabel("用户名:"+user.getUsername())) ;
        fieldList.add(null) ;
        
    	if(type.equals("pwd")){
            labList.add(new JLabel("密码")) ;
            
            passwordText.setText("") ;
            fieldList.add(passwordText) ;
    	} else {
	        labList.add(new JLabel("姓名")) ;
	        labList.add(new JLabel("Role")) ;
	        labList.add(new JLabel("Rank")) ;
	        
	        nameText.setText(user.getName()) ;
//	        roleText.setText(user.getRole()) ;
	        rankText.setText(user.getRank()) ;
	        
	        fieldList.add(nameText) ;
	        fieldList.add(roleText) ;
	        fieldList.add(rankText) ;
    	}
        
//        按钮
        runBut.setText("提交");
        runBut.addActionListener(new RunButtonActionAdapter());
        buttonList.add(runBut) ;
        
        super.printFormModel() ;
    }
    private void submitAction(ActionEvent e) {
    	String message = "" ;
    	String name = nameText.getText().trim() ;
    	String pwd = passwordText.getText().trim() ;
    	String role = roleText.getText().trim() ;
    	String rank = rankText.getText().trim() ;
    	
    	if(type.equals("pwd")){
    		if(pwd.length()>=3){
    			User u = new User() ;
    			u.setUid(user.getUid()) ;
    			u.setPassword(pwd) ;
    			ConstService.userService.userUpdate(u) ;
    		} else {
    			message = "密码长度至少要3位。" ;
    		}
    	} else {
	    	user.setName(name) ;
//	    	user.setUsername(username) ;
	    	user.setPassword(null) ;
//	    	user.setRole(role) ;
	    	user.setRank(rank) ;
			int re = ConstService.userService.userUpdate(user) ;
			
    	}
    	if(message.length()>0){
    		jop.showMessageDialog(this, message) ;
    	} else {
    		jop.showMessageDialog(this, "修改成功") ;
    		listPanel() ;
    	}
    }
    
    private void listPanel(){
		this.removeAll();
		this.repaint() ;
		this.add(new ListUserPanel());
		this.validate();
    }
    class RunButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e) ;
        }
    }
    
}
