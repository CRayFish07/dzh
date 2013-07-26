package com.sys.applet.main.acc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.spring.domain.Account;
import com.sys.spring.domain.Kind;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-9-1
 */
public class AddAccountPanel extends CommonPanel{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//    text
    JTextField titleText = new JTextField();
    JTextField moneyText = new JTextField();
    JComboBox kindBox = new JComboBox();
    JTextField timeText = new JTextField();
    private List<Kind> kindList ;
    
//    button
    JButton submitBut = new JButton();
    JButton cancleBut = new JButton();
    
    public AddAccountPanel() {
    	labList.add(new JLabel("名称")) ;
    	labList.add(new JLabel("价格")) ;
    	labList.add(new JLabel("类别")) ;
    	labList.add(new JLabel("时间")) ;
    	labList.add(new JLabel("记录人：\t"+ConstService.user.getName())) ;
    	
//        数据
        kindList = ConstService.kindService.findKindList(-1) ;
        for(Kind k:kindList){
        	kindBox.addItem(k.getTitle()) ;
        }
        timeText.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) ;
        fieldList.add(titleText) ;
        fieldList.add(moneyText) ;
        fieldList.add(kindBox) ;
        fieldList.add(timeText) ;
        fieldList.add(null) ;
        
//        按钮
        submitBut.setText("提交");
        submitBut.addActionListener(new SubmitButtonActionAdapter());
        cancleBut.setText("取消");
        cancleBut.addActionListener(new CancelButtonActionAdapter());
        buttonList.add(submitBut) ;
        buttonList.add(cancleBut) ;
        super.printFormModel() ;
        titleText.grabFocus() ;
    }

    private void cancelAction(ActionEvent e) {
    	clear() ;
    }
    private void submitAction(ActionEvent e) {
    	String message = "" ;
    	String title	= titleText.getText() ;
    	String money	= moneyText.getText() ;
    	String kind		= kindBox.getSelectedItem().toString() ;
    	String time		= timeText.getText() ;
    	
    	if(title==null || money==null || time==null || 
      			title.length()==0 || money.length()==0 || time.length()==0){
    		message = "信息不完整" ;
    	} else {
    		User user = ConstService.user ;
        	Account acc = new Account() ;
        	acc.setTitle(title) ;
        	acc.setMoney(Double.parseDouble(money)) ;
        	for(Kind k:kindList){
        		if(k.getTitle().equals(kind)){
        			acc.setKindid(k.getUid()) ;
        			acc.setKindTitle(k.getTitle()) ;
        			break ;
        		}
        	}
        	acc.setDatetime(time) ;
        	acc.setUserId(user.getUid()) ;
        	acc.setUsername(user.getUsername()) ;
        	
			int re = ConstService.accService.insertAccount(acc, user) ;
			
    		message = "添加成功" ;
    		clear() ;
    	}
    	jop.showMessageDialog(this, message) ;
    }
    private void clear(){
    	titleText.setText("") ;
    	moneyText.setText("") ;
    	titleText.grabFocus() ;
    }

    class SubmitButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e) ;
        }
    }

    class CancelButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cancelAction(e);
        }
    }
    
}
