package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class SplashPanel extends JPanel {

	private int i=51;//动效初始index
	private JLabel bg;
	private int count=0;//记录动效的循环次数

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
		if(count<=2){
			g.drawImage(Config.getLoadingMotions().get(i).getImage(), Config.SPLASH_MOTION_X,
				Config.SPLASH_MOTION_Y, 
				Config.getLoadingMotions().get(i).getIconWidth(), 
				Config.getLoadingMotions().get(i).getIconHeight(), this);
		}
		if(count>2){
			this.getParent().disable();
			this.getParent().setVisible(false);
			this.setVisible(false);
			
			}
		changeMotionIndex();
	}
	
	
	public void changeMotionIndex(){
		i++;
		if(i>=99){
			i=51;
			count++;
		}
	}
	
	class PaintThread extends Thread{
		@Override
		public void run() {
		// TODO Auto-generated method stub
			//执行5秒
//			long begin_time=System.currentTimeMillis();
			while(true){
				repaint();
				try {
					Thread.sleep(80);
//					long endTime=System.currentTimeMillis();
//					if((endTime-begin_time)>5000){
//						repaint();
//						break;
//					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
