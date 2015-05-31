package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.Season;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LMouseAdapter;

@SuppressWarnings("serial")
public class MatchSelectionPanel extends JPanel {
	JLabel 
	    lb_firstSeason,
		lb_secondSeason,
		lb_thirdSeason,
		lb_forthSeason,
		lblNewLabel_1,
		lb_vs,
		foreground;
	private final int LABEL_Y=134/3+2;
	
	public MatchSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		foreground=new JLabel();
		foreground.setIcon(Config.LABEL_FOREGROUND);
		foreground.setBounds(0, LABEL_Y, Config.UI_WIDTH/3, 134/3+10);
		add(foreground);
		

		lb_firstSeason = new JLabel("2012-2013赛季", JLabel.CENTER);
		lb_firstSeason.setBounds(0, LABEL_Y, Config.UI_WIDTH/3, 134/3+10);
		lb_firstSeason.setFont(new Font("default", Font.ITALIC, 20));
		lb_firstSeason.setForeground(Color.white);
		add(lb_firstSeason);
		lb_secondSeason = new JLabel("2013-2014赛季", JLabel.CENTER);
		lb_secondSeason.setBounds(Config.UI_WIDTH/3, LABEL_Y, Config.UI_WIDTH/3, 134/3+10);
		lb_secondSeason.setFont(new Font("default", Font.ITALIC, 20));
		lb_secondSeason.setForeground(Color.white);
		add(lb_secondSeason);
		lb_thirdSeason = new JLabel("2014-2015赛季", JLabel.CENTER);
		lb_thirdSeason.setBounds(2*Config.UI_WIDTH/3, LABEL_Y, Config.UI_WIDTH/3, 134/3+10);
		lb_thirdSeason.setFont(new Font("default", Font.ITALIC, 20));
		lb_thirdSeason.setForeground(Color.white);
		add(lb_thirdSeason);
		lb_firstSeason.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			@Override
			public void mouseClicked(MouseEvent e) {
				foreground.setBounds(lb_firstSeason.getX(),LABEL_Y, Config.UI_WIDTH/3, 134/3+10);
				changeSeason(Season.season12_13);
			}
		});
		lb_secondSeason.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			@Override
			public void mouseClicked(MouseEvent e) {
				foreground.setBounds(lb_secondSeason.getX(), LABEL_Y, Config.UI_WIDTH/3, 134/3+10);
				changeSeason(Season.season13_14);
			}
		});
		lb_thirdSeason.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			@Override
			public void mouseClicked(MouseEvent e) {
				foreground.setBounds(lb_thirdSeason.getX(), LABEL_Y, Config.UI_WIDTH/3, 134/3+10);
				changeSeason(Season.season14_15);
			}
		});
		current_season = Season.season12_13;
		
		new refThread().start();
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(Config.MATCH_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
	}
	
	public Season current_season;
	private void changeSeason(Season season) {
		current_season = season;
		MainFrame.mainFrame.topTabPanel.refreshMatchTable(MainFrame.mainFrame.bl.getAllMatches(season));
	}
	
	
	
	class refThread extends Thread {
		private int matchesNum=MainFrame.mainFrame.bl.getAllMatches(current_season).size();
		
		public refThread() {
			
		}
		public void run() {
			while(true){
				try {		
					if(MainFrame.mainFrame.topTabPanel.isMatchClicked){
						int v;
						try {
						    v = MainFrame.mainFrame.topTabPanel.tg.jsp.getVerticalScrollBar().getValue();
						}catch(Exception e) { v = 0; }
						changeSeason(current_season);		
						try {
							MainFrame.mainFrame.topTabPanel.tg.jsp.getVerticalScrollBar().setValue(v);
						} catch(Exception e) {}
					}
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
