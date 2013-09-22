package com.gzb.game.photodeal;

import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gzb.game.evolution.Const;
import com.gzb.game.evolution.service.Organism;
import com.gzb.game.evolution.service.Service;
import com.gzb.game.xy.XYConstraints;
import com.gzb.game.xy.XYLayout;

public class DealPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4788845512877490383L;
	private Hashtable<Integer,Hashtable<Integer,Organism>> table = new Hashtable<Integer,Hashtable<Integer,Organism>>() ;
	private Service service = new Service() ;
	
	private int add_leve ;
	private int add_type ;
	private JLabel add_Label = new JLabel() ;
	public DealPanel() {
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
		JFileChooser jc = new JFileChooser();
		
		this.add(jc, new XYConstraints(0,0,500,300));
		this.setAddLeve() ;
	}
	
	public void LableActionPerformed(int x,int y) {
		Organism org = table.get(x).get(y) ;
		int leve = org.getLeve() ;
		
		//有数据的不能点
		if(leve>0){
			return ;
		}
		service.change(table, x, y, add_leve, add_type) ;
		this.setAddLeve() ;
    }
	
	private void setAddLeve(){
		this.add_leve = service.getRandomLeve()+1 ;
		this.add_type = 0 ;
		URL file = this.getClass().getResource("/com/gzb/game/evolution/image/"+add_type+add_leve+".jpg") ;
		ImageIcon icon = new ImageIcon(file);
		add_Label.setIcon(icon) ;
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

