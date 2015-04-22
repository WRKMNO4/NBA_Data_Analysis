package com.kmno4.presentation;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.kmno4.common.Config;

public class ContentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ContentPanel() {
		super();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Config.FRAME_BACKGROUND.getImage(), 0, 0, Config.UI_WIDTH, Config.UI_HEIGHT, null);
	}
	
	

}
