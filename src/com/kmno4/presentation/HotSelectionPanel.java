package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kmno4.common.Config;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class HotSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HotSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		JLabel lb_data_player = new JLabel("当日热点球员");
		lb_data_player.setBounds(0, 0, 200, 30);
		add(lb_data_player);
		JLabel lb_season_player = new JLabel("赛季热点球员");
		lb_season_player.setBounds(200, 0, 200, 30);
		add(lb_season_player);
		JLabel lb_improve_player = new JLabel("进步最快球员");
		lb_improve_player.setBounds(400, 0, 200, 30);
		add(lb_improve_player);
		JLabel lb_season_team = new JLabel("赛季热点球队");
		lb_season_team.setBounds(600, 0, 200, 30);
		add(lb_season_team);
		
		JRadioButton radioButton = new JRadioButton("第一赛季");
		radioButton.setBounds(0, 35, 141, 23);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("第二赛季");
		radioButton_1.setBounds(0, 61, 141, 23);
		add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("第三赛季");
		radioButton_2.setBounds(0, 85, 141, 23);
		add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("第四赛季");
		radioButton_3.setBounds(0, 106, 141, 23);
		add(radioButton_3);
		
		
	}

	public void paintComponent(Graphics g){
		
	}
}
