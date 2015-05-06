package com.kmno4.presentation;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class RainyPanel extends JPanel {
	
	private int count=0;

	private ArrayList<ImageIcon> rains;
	/**
	 * Create the panel.
	 */
	public RainyPanel() {
		setLayout(null);
		setSize(Config.UI_WIDTH	, Config.UI_HEIGHT);
		setVisible(true);
		
		rains=Config.getRains();
		new RainThread().start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(rains.get(count).getImage(), 0, 0,this.getWidth(), this.getHeight(),null);
		repaint();
	}
	
	public static void main(String[] args){
		JFrame f=new JFrame();
		f.setBounds(100, 100, Config.UI_WIDTH, Config.UI_HEIGHT);
		f.setContentPane(new RainyPanel());
		f.setVisible(true);
	}
	
	
	class RainThread extends Thread{
		@Override
		public void run() {
			while (true) {
				count++;
				System.out.println(count);
				if (count > 8) {
					count = 0;
				}
				repaint();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	

}
