package com.kmno4.presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.Table;

@SuppressWarnings("serial")
public class PlayerDetailPanel extends JPanel {
	private JLabel 
	    player_icon,
	    player_num,
	    player_name,
	    player_place,
	    player_team,
	    avg,
	    sum;
	private Table
	    mainInfo,
	    sumInfo,
	    avgInfo;
	    
	public PlayerDetailPanel() {
		
		setBounds(0, 0,
				Config.PLAYER_DETAIL_UI_WIDTH,Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setBackground(Color.WHITE);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints cons = new GridBagConstraints();
		
		player_icon = new JLabel("球员照片");
		player_icon.setBounds(Config.PLAYER_ICON_X,Config.PLAYER_ICON_Y, 
				Config.PLAYER_ICON_WIDTH,Config.PLAYER_ICON_HEIGHT);
		add(player_icon);
		
		player_num = new JLabel("球衣号");
		player_num.setBounds(289, 25,
				Config.PLAYER_NUMBER_WIDTH, Config.PLAYER_NUMBER_HEIGHT);
		add(player_num);
		
		player_name = new JLabel("name");
		player_name.setBounds(411, 23, 
				Config.PLAYER_LABEL_WIDTH, Config.PLAYER_LABEL_HEIGHT);
		add(player_name);
		
		player_place = new JLabel("位置");
		player_place.setBounds(411, 51, 
				Config.PLAYER_LABEL_WIDTH, Config.PLAYER_LABEL_HEIGHT);
		add(player_place);
		
		player_team = new JLabel("服役球队");
		player_team.setBounds(411, 84,
				Config.PLAYER_LABEL_WIDTH, Config.PLAYER_LABEL_HEIGHT);
		add(player_team);
		
		
		
		
	}
}
