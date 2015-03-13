package com.kmno4.presentation;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;

import com.kmno4.common.Config;
import javax.swing.JTextField;

public class PlayerDetailPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayerDetailPanel() {
		
		this.setBounds(100, 100, 620,240);
		this.setLayout(null);
		
		JLabel player_icon = new JLabel("球员照片");
		player_icon.setBounds(111, 34, 131, 161);
		add(player_icon);
		
		JLabel player_number = new JLabel("球衣号");
		player_number.setBounds(316, 51, 61, 16);
		add(player_number);
		
		JLabel player_name = new JLabel("name");
		player_name.setBounds(411, 23, 61, 16);
		add(player_name);
		
		JLabel place = new JLabel("位置");
		place.setBounds(411, 51, 42, 16);
		add(place);
		
		JLabel team = new JLabel("服役球队");
		team.setBounds(411, 84, 61, 16);
		add(team);
		
		JLabel participating_in_several = new JLabel("参赛场数");
		participating_in_several.setBounds(289, 155, 88, 16);
		add(participating_in_several);
		
		JLabel first_in = new JLabel("先发场数");
		first_in.setBounds(411, 155, 61, 16);
		add(first_in);
		
		JLabel time_in_match = new JLabel("在场时间");
		time_in_match.setBounds(523, 155, 61, 16);
		add(time_in_match);
		
		
	}
}
