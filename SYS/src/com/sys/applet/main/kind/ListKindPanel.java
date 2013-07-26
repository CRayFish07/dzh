package com.sys.applet.main.kind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.applet.main.util.TableFactory;
import com.sys.spring.domain.Kind;

/** 
 * by dyong 2010-9-1
 */
public class ListKindPanel extends CommonPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = -811506488870674263L;
	
	//  text
	JComboBox parentBox = new JComboBox();
	List<String> list = new ArrayList<String>() ;
	
	//  button
	JButton submitBut = new JButton();
	
//	table
    List<List<Object>> data = new ArrayList<List<Object>>() ;
	
    public ListKindPanel() {
//       数据
    	List<Kind> kindList = ConstService.kindService.findKindList(0) ;
       list.add("") ;
       parentBox.addItem("全部") ;
       for(Kind k:kindList){
       	parentBox.addItem(k.getTitle()) ;
       	list.add(k.getUid()) ;
       }
//       按钮
       submitBut.setText("提交");
       submitBut.addActionListener(new SubmitActionAdapter());
       
//        
    	List<String> title = new ArrayList<String>() ;
    	title.add("UUID") ;
    	title.add("TITLE") ;
    	title.add("NOTE") ;
    	title.add("上级ID") ;
    	title.add("删除") ;
        table = TableFactory.createtable(title, data) ;
        table.addMouseListener(new TableMouseListener()) ;
        
        fieldList.add(new JLabel("上级类别")) ;
        fieldList.add(parentBox) ;
        fieldList.add(submitBut) ;
        
        super.printSearchTableModel() ;
        
        TableFactory.freshTableData(table, getData(-1)) ;
    }

    private void submitAction(ActionEvent e) {//查询 显示
    	int parentId = java.lang.Integer.parseInt(list.get(parentBox.getSelectedIndex())) ;
        List<List<Object>> data = getData(parentId) ;

        TableFactory.freshTableData(table, data) ;
    }
    
//    查询数据
    private List<List<Object>> getData(int parentId){
//    	查询
    	List<Kind> ulist = ConstService.kindService.findKindList(parentId) ;
    	
//    	封装
        if(ulist!=null)
        for(int i=0;i<ulist.size();i++){
        	List<Object> l = new ArrayList<Object>() ;
        	Kind k = ulist.get(i) ;
        	l.add(k.getUid()) ;
        	l.add(k.getTitle()) ;
        	l.add(k.getNote()) ;
        	l.add(k.getParentId()) ;
        	l.add("del");
        	data.add(l) ;
        }
        return data ;
    }
    
    class SubmitActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e);
        }
    }
    /**
     * 跳转到修改页面
     * @param uid
     */
    private void updateKind(int uid){
    	this.removeAll();
    	this.repaint() ;
    	this.add(new UpdateKindPanel(uid));
    	this.validate();
    }
    /**
     * 删除选中行
     * @param uid
     */
    private void deleteKind(int uid){
    	int rel=jop.showConfirmDialog(this,"你确定删除"+uid+"吗？","删除",jop.YES_NO_OPTION ) ;
        if(rel==jop.YES_OPTION ){
        	ConstService.kindService.deleteKindById(uid) ;
        }
        
        this.removeAll();
    	this.repaint() ;
    	this.add(new ListKindPanel());
    	this.validate();
    }
    class TableMouseListener extends MouseAdapter  {
    	public void mouseClicked(MouseEvent e){
    		int clickTimes = e.getClickCount();
    		if (clickTimes >= 1){
    			JTable table = (JTable)e.getSource() ;
    			int row = table.getSelectedRow() ;
    			int col = table.getSelectedColumn() ;
    			int uid = java.lang.Integer.parseInt(data.get(row).get(0).toString()) ;
//    			System.out.println("Doublc Clicked!"+row+"/"+uid);
    			
    			if(col==4){
    				deleteKind(uid) ;
    			} else {
    				updateKind(uid) ;
    			}
    		}
    	}
	}
}
