package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.Season;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LMouseAdapter;

@SuppressWarnings("serial")
public class MatchSelectionPanel extends JPanel {
	JPanel seasonPanel;
	JLabel 
	    lb_firstSeason,
		lb_secondSeason,
		lb_thirdSeason,
		lb_forthSeason,
		lblNewLabel_1,
		lb_vs,
		foreground;
	
	public MatchSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		foreground=new JLabel();
		foreground.setIcon(Config.LABEL_FOREGROUND);
		foreground.setBounds(0, 134/3, Config.UI_WIDTH/3, 134/3+10);
		add(foreground);
		
		seasonPanel = new JPanel();
		seasonPanel.setBounds(0, 0, Config.UI_WIDTH, 134);
		seasonPanel.setBackground(new Color(0, 0, 0, 0));
		seasonPanel.setLayout(new GridLayout(1, 0));
		lb_firstSeason = new JLabel("2012-2013赛季", JLabel.CENTER);
		lb_firstSeason.setFont(new Font("default", Font.ITALIC, 20));
		lb_firstSeason.setForeground(Color.white);
		seasonPanel.add(lb_firstSeason);
		lb_secondSeason = new JLabel("2013-2014赛季", JLabel.CENTER);
		lb_secondSeason.setFont(new Font("default", Font.ITALIC, 20));
		lb_secondSeason.setForeground(Color.white);
		seasonPanel.add(lb_secondSeason);
		lb_thirdSeason = new JLabel("2014-2015赛季", JLabel.CENTER);
		lb_thirdSeason.setFont(new Font("default", Font.ITALIC, 20));
		lb_thirdSeason.setForeground(Color.white);
		seasonPanel.add(lb_thirdSeason);
		add(seasonPanel);
		lb_firstSeason.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				foreground.setBounds(lb_firstSeason.getX(), 134/3, Config.UI_WIDTH/3, 134/3+10);
				changeSeason(Season.season12_13);
			}
		});
		lb_secondSeason.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				foreground.setBounds(lb_secondSeason.getX(), 134/3, Config.UI_WIDTH/3, 134/3+10);
				changeSeason(Season.season13_14);
			}
		});
		lb_thirdSeason.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				foreground.setBounds(lb_thirdSeason.getX(), 134/3, Config.UI_WIDTH/3, 134/3+10);
				changeSeason(Season.season14_15);
			}
		});
		current_season = Config.LASTEST_SEASON;
		
//		lblNewLabel_1 = new JLabel("日历");
//		lblNewLabel_1.setIcon(Config.SCHEDULE);
//		lblNewLabel_1.setBounds(660, 66, 98, 43);
//		add(lblNewLabel_1);
		

//		cb_team2 = new JComboBox<String>();
//		cb_team2.setBounds(275, 75, 164, 27);
//		add(cb_team2);
//		
//		lb_vs = new JLabel("VS");
//		lb_vs.setBounds(213, 79, 61, 16);
//		add(lb_vs);
		new refThread().start();
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(Config.MATCH_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
	}
	
	private Season current_season;
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
					if(MainFrame.mainFrame.bl.getAllMatches(current_season).size()>matchesNum){
						changeSeason(current_season);
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
