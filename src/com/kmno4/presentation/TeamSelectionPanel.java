package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class TeamSelectionPanel extends JPanel implements MouseListener{


	private JComboBox standrad;
	
	public JLabel total_sort;
	public JLabel avg_sort;
	
	
	public TeamSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		standrad = new JComboBox(Config.SORT_TEAM_STANDRAD);
		add(standrad);

		total_sort=new JLabel("总计");
		total_sort.setBounds(85, 6, 61, 16);
		total_sort.addMouseListener(this);
		avg_sort=new JLabel("场均");
		avg_sort.setBounds(x, y, width, height);
		avg_sort.addMouseListener(this);
		
		JLabel label = new JLabel("场均");
		label.setBounds(85, 6, 61, 16);
		add(label);
		
		JLabel label_1 = new JLabel("总计");
		label_1.setBounds(85, 25, 61, 16);
		add(label_1);
	}
	
	//画背景
	public void paintComponent(Graphics g)
	      {
				super.paintComponent(g);
				g.drawImage(Config.TEAM_SELECTION_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.SELECTION_HEIGHT,this);
	      }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
