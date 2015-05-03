package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
//用来显示页面信息的panel
public class PageInfoPanel extends JPanel {
	public JLabel page_name;
	private JLabel player;
	private ArrayList<ImageIcon> players;
	private int i;//球员代号
	private int count=51;//动图位置
	private int x,y;//球员图片位置
	/**
	 * Create the panel.
	 */
	public PageInfoPanel(String pageInfo) {
		this.setBounds(0, Config.TOP_TAB_HEIGHT, Config.UI_WIDTH, Config.PAGE_INTRO_HEIGHT);
		this.setLayout(null);		
		
		i=x=y=0;
		
		page_name = new JLabel(pageInfo);
		page_name.setForeground(Color.WHITE);
		page_name.setFont(new Font("default", Font.ITALIC, 20));
		page_name.setBounds(6, 6, Config.PAGE_INTRO_LABEL_WIDTH*4, Config.PAGE_INTRO_LABEL_HEIGHT);
		add(page_name);
		
		players=Config.getPlayers();
		new MotionThread().start();
		new PlayerThread().start();
//		
//		player=new JLabel();
//		player.setIcon(Config.PLYAER);
//		player.setBounds(800, 5, 30, 36);
//		add(player);
	}
	
	public void refreshInfo(String pageInfo){
		this.page_name.setText(pageInfo);
	}
	
	public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		g.drawImage(Config.INTRO_PAGE_BG.getImage(),0, 0, Config.UI_WIDTH, Config.INTRODUCTION_WHITE, null);
//		g.drawImage(players.get(i).getImage(),0-x,-300-y, null);
		g.drawImage(Config.getLoadingMotions().get(count).getImage(), 800,13,20, 20, this);
//		g.setColor(Color.WHITE);
//		g.drawLine(0, 40, 1000, 40);
    }
	
	class PlayerThread extends Thread{
		@Override
		public void run() {
			while(true){
				i++;
				if(i>9){
					i=0;
				}
				try {
					Thread.sleep(5000);
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	class MotionThread extends Thread{
		@Override
		public void run() {
			while(true){
				x--;
				y--;
				if(x<-500){
					x=y=0;
					if(i>8){
						i=0;
					}
					i++;
				}
				count++;
				if(count>=99){
					count=51;
				}
				try {
					Thread.sleep(50);
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
