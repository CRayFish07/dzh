package com.sys.applet.main.acc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.applet.main.util.DoubleUtil;
import com.sys.applet.main.util.TableFactory;
import com.sys.spring.domain.Account;
import com.sys.spring.domain.Kind;

/** 
 * by dyong 2010-9-1
 */
public class ListAccountPanel extends CommonPanel{
	private static final long serialVersionUID = 8094222460871915784L;
	
	JTextField titleText = new JTextField() ;
	JTextField moneyText = new JTextField() ;
	JComboBox kindBox = new JComboBox();
    JTextField beginTimeText = new JTextField();
    JTextField endTimeText = new JTextField();
    private List<Kind> kindList ;
    
//	table
    List<List<Object>> data = new ArrayList<List<Object>>() ;
    
//	button
    JButton submitButton = new JButton();
    
    public ListAccountPanel() {
        kindList = ConstService.kindService.findKindList(-1) ;
        kindBox.addItem("-请选择-") ;
        for(Kind k:kindList){
        	kindBox.addItem(k.getTitle()) ;
        }
        String beginDate = new SimpleDateFormat("yyyy-MM-").format(new Date()) +"01" ;
        beginTimeText.setText(beginDate) ;
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ;
        endTimeText.setText(endDate) ;
        
        submitButton.setText("确定");
        submitButton.addActionListener(new SubmitActionAdapter());
        
    	fieldList.add(new JLabel("名称")) ;
    	fieldList.add(titleText) ;
    	fieldList.add(new JLabel("价格")) ;
    	fieldList.add(moneyText) ;
    	fieldList.add(new JLabel("类别")) ;
    	fieldList.add(kindBox) ;
    	fieldList.add(null) ;
    	fieldList.add(new JLabel("时间")) ;
    	fieldList.add(beginTimeText) ;
    	fieldList.add(endTimeText) ;
    	fieldList.add(submitButton) ;
    	
//        table
    	List<String> title = new ArrayList<String>() ;
    	title.add("ID") ;
    	title.add("名称") ;
    	title.add("价格(元)") ;
    	title.add("类别") ;
    	title.add("日期") ;
        table = TableFactory.createtable(title, data);
        table.addMouseListener(new TableMouseListener()) ;
        
        super.printSearchTableModel() ;
        
//        初始化表数据
        List<Account> ulist = ConstService.accService.findAccountList(beginDate,endDate, new Account(),ConstService.user) ;
        data = getData(ulist) ;
        TableFactory.freshTableData(table, data) ;
    }

    private void submitAction(ActionEvent e) {//查询 显示
    	String begin = beginTimeText.getText() ;
    	String end = endTimeText.getText() ;
    	Account acc = getAccount() ;
    	List<Account> ulist = ConstService.accService.findAccountList(begin, end, acc, ConstService.user) ;
        
        TableFactory.freshTableData(table, getData(ulist)) ;
    }
    
//    查询结果输出到表格
    private List<List<Object>> getData(List<Account> accList){
    	data.removeAll(data) ;
    	double allMoney = 0 ;
    	int count = 0 ;
        if(accList!=null)
        for(int i=0;i<accList.size();i++){
        	List<Object> l = new ArrayList<Object>() ;
        	Account acc = accList.get(i) ;
        	l.add(acc.getId()) ;
        	l.add(acc.getTitle()) ;
        	l.add(DoubleUtil.money(acc.getMoney())) ;
        	l.add(acc.getKindTitle()) ;
        	l.add(acc.getDatetime()) ;
        	data.add(l) ;
        	count ++ ;
        	allMoney+=acc.getMoney() ;
        }
        List<Object> l = new ArrayList<Object>() ;
        l.add("总计") ;
        l.add(count+"笔") ;
        l.add(DoubleUtil.money(allMoney)) ;
        l.add("") ;
        l.add("") ;
        data.add(l) ;
        return data ;
    }

    private void updateAcc(int id){
    	this.removeAll();
    	this.repaint() ;
    	this.add(new UpdateAccountPanel(id));
    	this.validate();
    }
    private Account getAccount(){
    	String title = titleText.getText() ;
    	String money = moneyText.getText() ;
    	int index = kindBox.getSelectedIndex() ;
    	
    	Account acc = new Account() ;
    	if(title!=null && title.length()>0){
    		acc.setTitle(title) ;
    	}
    	if(money!=null && money.trim().length()>0){
    		acc.setMoney(Double.parseDouble(money)) ;
    	}
    	if(index>0){
        	Kind kind = kindList.get(index-1) ;
    		acc.setKindid(kind.getUid()) ;
    	}
        return acc ;
    }
    class SubmitActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e);
        }
    }
    class TableMouseListener extends MouseAdapter  {
    	public void mouseClicked(MouseEvent e){
    		int clickTimes = e.getClickCount();
    		if (clickTimes >= 1){
    			JTable table = (JTable)e.getSource() ;
    			int allRow = table.getRowCount() ;
    			int row = table.getSelectedRow() ;
    			int col = table.getSelectedColumn() ;
    			int id = Integer.parseInt(data.get(row).get(0).toString()) ;
//    			System.out.println("Doublc Clicked!"+row+"/"+uid);
    			
//    			进入详细页面
    			if(row<allRow-1){
    				updateAcc(id) ;
//    			} else {
//    				showAcc(uid) ;
    			}
    		}
    	}
	}
}
