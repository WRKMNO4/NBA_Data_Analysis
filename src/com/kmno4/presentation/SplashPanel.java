package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class SplashPanel extends JPanel {

	private int i;
	private JLabel bg;

	/**
	 * Create the panel.
	 */
	public SplashPanel() {
			this.setBounds(0, 0, Config.UI_WIDTH,Config.UI_HEIGHT);
			this.setLayout(null);
			
			bg=new JLabel(); 
			bg.setBounds(0, 0, Config.UI_WIDTH,Config.UI_HEIGHT);
			bg.setBackground(Color.BLUE);
			bg.setIcon(Config.SPLASH_BACKGROUND);
			this.add(bg);
	}
	
	public void launch(){
		new PaintThread().start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(Config.getLoadingMotions().get(i).getImage(), 400, 300, 
				Config.getLoadingMotions().get(i).getIconWidth(), 
				Config.getLoadingMotions().get(i).getIconHeight(), this);
		changeMotionIndex();
	}
	
	
	public void changeMotionIndex(){
		i++;
		if(i>=99){
			i=0;
		}
	}
	
	class PaintThread extends Thread{
		@Override
		public void run() {
		// TODO Auto-generated method stub
			while(true){
				repaint();
				try {
					Thread.sleep(80);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
