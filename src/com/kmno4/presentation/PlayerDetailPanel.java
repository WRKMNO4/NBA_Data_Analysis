package com.kmno4.presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class PlayerDetailPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayerDetailPanel() {
		
		this.setBounds(0, 0,
				Config.PLAYER_DETAIL_UI_WIDTH,Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		this.setLayout(null);
		
		JLabel player_icon = new JLabel("球员照片");
		player_icon.setBounds(Config.PLAYER_ICON_X,Config.PLAYER_ICON_Y, 
				Config.PLAYER_ICON_WIDTH,Config.PLAYER_ICON_HEIGHT);
		add(player_icon);
		
		JLabel player_number = new JLabel("球衣号");
		player_number.setBounds(289, 25,
				Config.PLAYER_NUMBER_WIDTH, Config.PLAYER_NUMBER_HEIGHT);
		add(player_number);
		
		JLabel player_name = new JLabel("name");
		player_name.setBounds(411, 23, 
				Config.PLAYER_LABEL_WIDTH, Config.PLAYER_LABEL_HEIGHT);
		add(player_name);
		
		JLabel place = new JLabel("位置");
		place.setBounds(411, 51, 
				Config.PLAYER_LABEL_WIDTH, Config.PLAYER_LABEL_HEIGHT);
		add(place);
		
		JLabel team = new JLabel("服役球队");
		team.setBounds(411, 84,
				Config.PLAYER_LABEL_WIDTH, Config.PLAYER_LABEL_HEIGHT);
		add(team);
		
		//以下用自定义table替代
		
		JLabel participating_in_several = new JLabel("参赛场数");
		participating_in_several.setBounds(289, 155, 88, 16);
		add(participating_in_several);
		
		JLabel first_in = new JLabel("先发场数");
		first_in.setBounds(411, 155, 61, 16);
		add(first_in);
		
		JLabel time_in_match = new JLabel("在场时间");
		time_in_match.setBounds(523, 155, 61, 16);
		add(time_in_match);
		
		JLabel lblMatches = new JLabel("matches");
		lblMatches.setBounds(289, 179, 61, 16);
		add(lblMatches);
		
		JLabel lblFirstout = new JLabel("firstOut");
		lblFirstout.setBounds(411, 179, 61, 16);
		add(lblFirstout);
		
		JLabel lblInsquretime = new JLabel("in_squre_time");
		lblInsquretime.setBounds(523, 179, 61, 16);
		add(lblInsquretime);
		
		
		
	}
}
