package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kmno4.common.Config;

public class HotSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HotSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		
	}

	public void paintComponent(Graphics g){
		
	}
}
