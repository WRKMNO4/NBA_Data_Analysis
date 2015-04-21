package com.kmno4.presentation;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.kmno4.presentation.table.SmallTable;

import PO.PlayerPO;
import PO.TeamPO;

@SuppressWarnings("serial")
public class LastestGamePanel extends JPanel {
	
	private TeamPO teamPO;
	private PlayerPO playerPO;
	
	private SmallTable table;
	
	public LastestGamePanel(TeamPO t) {
		teamPO = t;
		ini(t);
	}
	public LastestGamePanel(PlayerPO p) {
		playerPO = p;
		ini(p);
	}
	
	private void ini(Object o) {
		if(o instanceof TeamPO) {
			TeamPO t = (TeamPO) o;
			
		}
		else if(o instanceof PlayerPO) {
			
		}
		else return;
		table = new SmallTable(
				    new String[]{"11", "11", "11", "11"},
				    new String[][] {
				    		{"11", "11", "11", "11"},
				    		{"11", "11", "11", "11"},
				    		{"11", "11", "11", "11"},
				    		{"11", "11", "11", "11"}});
		table.head.setVisible(false);
		table.remove(table.head);
		table.setLayout(new GridLayout(table.getRowNum(), 1));
		
		addLink();
	}
	
	private void addLink() {
		for(int i = 0; i < table.getRowNum(); i ++) {
			table.body[0][i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//TODO
				}
			});
		}
	}
}
