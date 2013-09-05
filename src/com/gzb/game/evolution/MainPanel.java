package com.gzb.game.evolution;

import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gzb.game.xy.XYConstraints;
import com.gzb.game.xy.XYLayout;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4788845512877490383L;
	XYLayout xYLayout1 = new XYLayout();
	
	public MainPanel() {
		XYLayout xYLayout1 = new XYLayout();
		xYLayout1.setWidth(Const.width);
		xYLayout1.setHeight(Const.height);
		this.setLayout(xYLayout1);
		this.setBackground(SystemColor.LIGHT_GRAY);
//		this.setBackground(SystemColor.controlLtHighlight);
        
		int size = Const.size ;
		int len = Const.len ;
		int head = Const.height-size*len ;
		URL file = this.getClass().getResource("/com/gzb/game/evolution/image/0.jpg") ;
		ImageIcon icon=new ImageIcon(file);

		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				JLabel lab = new JLabel(icon);
				lab.addMouseListener(new LabelActionAdapter(i,j)) ;
				this.add(lab, new XYConstraints(len*j,head+len*i,len-1,len-1));
			}
		}
	}
	
	public void LableActionPerformed(int x,int y) {
		
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

