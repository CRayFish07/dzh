package com.sys.applet.main.acc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.spring.domain.Account;
import com.sys.spring.domain.Kind;

/** 
 * by dyong 2010-9-1
 */
public class UpdateAccountPanel extends CommonPanel{

//  text
	JTextField titleText = new JTextField();
    JTextField moneyText = new JTextField();
    JComboBox kindBox = new JComboBox();
    JTextField timeText = new JTextField();
    private List<Kind> kindList ;
    
//    button
    JButton submitBut = new JButton();
    JButton cancleBut = new JButton();
    int id ;
    public UpdateAccountPanel(int id) {
    	this.id = id ;
    	Account acc = ConstService.accService.findAccountById(id, ConstService.user) ;
    	
    	labList.add(new JLabel("名称")) ;
    	labList.add(new JLabel("价格")) ;
    	labList.add(new JLabel("类别")) ;
    	labList.add(new JLabel("时间")) ;
    	labList.add(new JLabel("记录人：\t"+acc.getUsername())) ;
    	
//        数据
        kindList = ConstService.kindService.findKindList(-1) ;
        for(Kind k:kindList){
        	kindBox.addItem(k.getTitle()) ;
        	if(k.getUid().equals(acc.getKindid())){
        		kindBox.setSelectedItem(k.getTitle()) ;
        	}
        }
        titleText.setText(acc.getTitle()) ;
        moneyText.setText(String.valueOf(acc.getMoney())) ;
        timeText.setText(acc.getDatetime()) ;
        fieldList.add(titleText) ;
        fieldList.add(moneyText) ;
        fieldList.add(kindBox) ;
        fieldList.add(timeText) ;
        fieldList.add(null) ;
        
//        按钮
        submitBut.setText("提交");
        submitBut.addActionListener(new SubmitButtonActionAdapter());
        buttonList.add(submitBut) ;
        super.printFormModel() ;
    }

	private void submitAction(ActionEvent e) {//查询 显示
    	String title = titleText.getText() ;
    	String money = moneyText.getText() ;
    	int kindex = kindBox.getSelectedIndex() ;
    	Kind kind = kindList.get(kindex) ;
    	String time = timeText.getText() ;
    	
    	Account acc = ConstService.accService.findAccountById(id, ConstService.user) ;
    	acc.setTitle(title) ;
    	acc.setMoney(Double.parseDouble(money)) ;
    	acc.setKindid(kind.getUid()) ;
    	acc.setKindTitle(kind.getTitle()) ;
    	acc.setDatetime(time) ;
    	ConstService.accService.updateAccount(acc, ConstService.user) ;
    	
//    	list
    	this.removeAll();
    	this.repaint() ;
    	this.add(new ListAccountPanel());
    	this.validate();
    }
    
    class SubmitButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e);
        }
    }
    
}
