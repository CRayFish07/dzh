package com.sys.applet.main.photo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.spring.domain.Diary;

/** 
 * by dyong 2010-9-2
 */
public class AddPhotoPanel extends CommonPanel{
    
	private static final long serialVersionUID = 1217463325990042093L;
	//    text
    JTextField type = new JTextField();
    JTextArea noteText = new JTextArea();
    
//    button
    JButton submitBut = new JButton();
    
    public AddPhotoPanel() {
       labList.add(new JLabel("照片集")) ;
       labList.add(new JLabel("照片")) ;
       
//       noteText.setWrapStyleWord(true) ;
//       noteText.setAutoscrolls(true) ;
       noteText.setLineWrap(true) ;
       fieldList.add(type) ;
       fieldList.add(noteText) ;
       
//        按钮
        submitBut.setText("提交");
        submitBut.addActionListener(new SubmitButtonActionAdapter());
        buttonList.add(submitBut) ;
        
        super.printFormModel() ;
    }

    private void submitAction(ActionEvent e) {
    	String message = "" ;
    	String title = type.getText() ;
    	String note	= noteText.getText() ;
    	
    	if(title==null || note==null ){
    		message = "信息不完整" ;
    	} else {
//    		Diary d = new Diary() ;
//    		d.setTitle(title) ;
//    		d.setContent(note) ;
//    		d.setDatetime(new Date().toLocaleString()) ;
//			int re = ConstService.diaryService.insertDiary(d, ConstService.user) ;
			
    		message = "添加成功" ;
    		clear() ;
    	}
    	jop.showMessageDialog(this, message) ;
    }
    private void clear(){
    	//type.setText("") ;
    	noteText.setText("") ;
    }

    class SubmitButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e) ;
        }
    }

}
