package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kmno4.common.Config;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MatchSelectionPanel extends JPanel {
	
	JLabel 
	    lb_firstSeason,
		lb_secondSeason,
		lb_thirdSeason,
		lb_forthSeason;
	JComboBox cb_team1 ;
	JComboBox cb_team2;
	
	public MatchSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		cb_team1=new JComboBox();
		cb_team1.setBounds(22, 75, 186, 27);
		add(cb_team1);
		
		lb_firstSeason = new JLabel("第一赛季");
		lb_firstSeason.setBounds(0, 0, 200, 30);
		add(lb_firstSeason);
		lb_secondSeason = new JLabel("第二赛季");
		lb_secondSeason.setBounds(200,0, 200, 30);
		add(lb_secondSeason);
		lb_thirdSeason = new JLabel("第三赛季");
		lb_thirdSeason.setBounds(400,0, 200, 30);
		add(lb_thirdSeason);
		lb_forthSeason = new JLabel("第四赛季");
		lb_forthSeason.setBounds(600,0, 200, 30);
		add(lb_forthSeason);
		
		JLabel lblNewLabel_1 = new JLabel("日历");
		lblNewLabel_1.setIcon(Config.SCHEDULE);
		lblNewLabel_1.setBounds(660, 66, 98, 43);
		add(lblNewLabel_1);
		
		cb_team2 = new JComboBox();
		cb_team2.setBounds(275, 75, 164, 27);
		add(cb_team2);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setBounds(213, 79, 61, 16);
		add(lblVs);
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(Config.MATCH_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
	}
}
