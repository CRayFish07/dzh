package com.gzb.game.evolution;

import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gzb.game.evolution.service.Organism;
import com.gzb.game.evolution.service.Service;
import com.gzb.game.xy.XYConstraints;
import com.gzb.game.xy.XYLayout;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4788845512877490383L;
	private Hashtable<Integer,Hashtable<Integer,Organism>> table = new Hashtable<Integer,Hashtable<Integer,Organism>>() ;
	public MainPanel() {
		XYLayout xYLayout1 = new XYLayout();
		xYLayout1.setWidth(Const.width);
		xYLayout1.setHeight(Const.height);
		this.setLayout(xYLayout1);
//		this.setBackground(SystemColor.LIGHT_GRAY);
		this.setBackground(SystemColor.controlLtHighlight);
        
		this.init() ;
	}
	
	//初始化
	private void init(){
		int size = Const.size ;
		int len = Const.len ;
		int head = Const.height-size*len ;

		table = new Hashtable<Integer,Hashtable<Integer,Organism>>() ;
		for(int i=0;i<size;i++){
			Hashtable<Integer,Organism> row = new Hashtable<Integer,Organism>() ;
			for(int j=0;j<size;j++){
				Organism org = new Organism(i,j) ;
				int r = (int)(Math.random()*100) ;
				if(r>70 && r<=90){
					org.change(1) ;
				}else if(r>90 && r<=95){
					org.change(2) ;
				}else if(r>95){
					org.change(3) ;
				}
				
				JLabel lab = org.getLabel() ;
				lab.addMouseListener(new LabelActionAdapter(i,j)) ;
				this.add(lab, new XYConstraints(len*j,head+len*i,len-1,len-1));
				
				row.put(j, org) ;
			}
			table.put(i, row) ;
		}
	}
	
	public void LableActionPerformed(int x,int y) {
		Organism org = table.get(x).get(y) ;
		int leve = org.getLeve() ;
		
		//有数据的不能点
		if(leve>0){
			return ;
		}
		int _leve = 1 ;
		Service service = new Service() ;
		service.change(table, org, _leve) ;
    }
	

	class LabelActionAdapter implements MouseListener {
		private int x,y;
		public LabelActionAdapter(int i, int j) {
			this.x = i ;
			this.y = j ;
		}

		public void mouseClicked(MouseEvent e) {
			LableActionPerformed(x,y) ;
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
}

