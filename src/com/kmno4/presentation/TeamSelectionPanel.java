package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class TeamSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TeamSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		
	}
	
	//画背景
	public void paintComponent(Graphics g)
	      {
				super.paintComponent(g);
				g.drawImage(Config.TEAM_SELECTION_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.SELECTION_HEIGHT,this);
	      }
}
