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
	
	private static final int CIRCLE_WIDTH=10;
	private static final int CIRCLE_Y=20;
	private static final int CIRCLE_X_GAP=20;
	private static final int FIRST_CIRCLE_X=830;	
	
	public JLabel page_name;
	private JLabel player;
	private ArrayList<ImageIcon> players;
	private int i;//球员代号
	private int count=51;//动图位置
	private int x,y;//球员图片位置
	private boolean isup;
	private int v;//图片切换移动的速度
//	private JLabel circle1,circle2,circle3,circle4;
	private int circle_num;
	private int full_circle_x;
	
	/**
	 * Create the panel.
	 */
	public PageInfoPanel(String pageInfo) {
		this.setBounds(0, Config.TOP_TAB_HEIGHT, Config.UI_WIDTH, Config.PAGE_INTRO_HEIGHT);
		this.setLayout(null);		
		
		i=x=y=0;
		circle_num=0;
		
		page_name = new JLabel(pageInfo);
		page_name.setForeground(Color.WHITE);
		page_name.setFont(new Font("default", Font.ITALIC, 20));
		page_name.setBounds(6, 6, Config.PAGE_INTRO_LABEL_WIDTH*4, Config.PAGE_INTRO_LABEL_HEIGHT);
		add(page_name);
		
		players=Config.getPlayers();
		new MotionThread().start();
		new PlayerThread().start();

	}
		
	public void refreshInfo(String pageInfo){
		this.page_name.setText(pageInfo);
	}
	
	public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		g.drawImage(Config.INTRO_PAGE_BG.getImage(),0, 0, Config.UI_WIDTH, Config.INTRODUCTION_WHITE, null);
		g.drawImage(players.get(i).getImage(),x,y, null);
		g.drawImage(Config.getLoadingMotions().get(count).getImage(), FIRST_CIRCLE_X+CIRCLE_X_GAP*circle_num-5,14,20, 20, this);
		g.setColor(Color.WHITE);
		g.drawLine(0, 40, 1000, 40);
		drawCircle(g);
    }
	
	public void drawCircle(Graphics g){
		g.drawImage(Config.CIRCLE_FULL.getImage(), FIRST_CIRCLE_X+CIRCLE_X_GAP*circle_num, CIRCLE_Y, CIRCLE_WIDTH, CIRCLE_WIDTH, null);

		g.drawImage(Config.CIRCLE_EMPTY.getImage(), FIRST_CIRCLE_X, CIRCLE_Y, CIRCLE_WIDTH, CIRCLE_WIDTH, null);
		g.drawImage(Config.CIRCLE_EMPTY.getImage(), FIRST_CIRCLE_X+CIRCLE_X_GAP, CIRCLE_Y, CIRCLE_WIDTH, CIRCLE_WIDTH, null);
		g.drawImage(Config.CIRCLE_EMPTY.getImage(), FIRST_CIRCLE_X+CIRCLE_X_GAP*2, CIRCLE_Y, CIRCLE_WIDTH, CIRCLE_WIDTH, null);
		g.drawImage(Config.CIRCLE_EMPTY.getImage(), FIRST_CIRCLE_X+CIRCLE_X_GAP*3, CIRCLE_Y, CIRCLE_WIDTH, CIRCLE_WIDTH, null);
	}
	
	class PlayerThread extends Thread{
		@Override
		public void run() {
			while(true){
				//pic num
				i++;
				if(i>9){
					i=0;
				}
				//pic direction
				double k=Math.random();
				if(k>0.5){
					isup=true;
				}else{
					isup=false;
				}				
				try {
					Thread.sleep(5000);
					//cicle
					circle_num++;
					if(circle_num>3){
						circle_num=0;
					}
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
				
				if(isup){
					y++;
				}else{
					y--;
				}
				
				if(y<-500||y>0){
					y=-200;
				}
				count++;
				if(count>=99){
					count=51;
				}
				try {
					Thread.sleep(70);
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	class PictureThread extends Thread{
		@Override
		public void run() {
			while(true){
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
