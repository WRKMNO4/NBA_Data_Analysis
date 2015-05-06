package com.kmno4.presentation;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class RainyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RainyPanel() {
		setLayout(null);
		setSize(Config.UI_WIDTH	, Config.UI_HEIGHT);
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Config.SMOKE.getImage(), 0, 0,this.getWidth(), this.getHeight(),null);
		repaint();
	}
	
	public static void main(String[] args){
		JFrame f=new JFrame();
		f.setBounds(100, 100, Config.UI_WIDTH, Config.UI_HEIGHT);
		f.setContentPane(new RainyPanel());
		f.setVisible(true);
	}
	
	
	

}
