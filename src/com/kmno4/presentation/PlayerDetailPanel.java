package com.kmno4.presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	    avg, //场均切换标签
	    sum; //总计切换标签
	private Table
	    mainInfo, //主要信息表格
	    sumInfo, //总计信息表格
	    avgInfo; //场均信息表格
	    
	public PlayerDetailPanel() {
		
		setBounds(0, 0,
				Config.PLAYER_DETAIL_UI_WIDTH,Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setBackground(Color.WHITE);
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		//TODO
		player_icon = new JLabel("球员照片", JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 7;
		c.gridheight = 6;
		layout.setConstraints(player_icon, c);
		add(player_icon);
		
		player_num = new JLabel("球衣号", JLabel.CENTER);
		c.gridx = 8;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 2;
		layout.setConstraints(player_num, c);
		add(player_num);
		
		player_name = new JLabel("name", JLabel.CENTER);
		c.gridx = 10;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 2;
		layout.setConstraints(player_name, c);
		add(player_name);
		
		player_place = new JLabel("位置", JLabel.CENTER);
		c.gridx = 10;
		c.gridy = 2;
		c.gridwidth = 4;
		c.gridheight = 1;
		layout.setConstraints(player_place, c);
		add(player_place);
		
		player_team = new JLabel("服役球队", JLabel.CENTER);
		c.gridx = 14;
		c.gridy = 0;
		c.gridwidth = 5;
		c.gridheight = 3;
		layout.setConstraints(player_team, c);
		add(player_team);
		
		avg = new JLabel("场均", JLabel.CENTER);
		avg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		c.gridx = 15;
		c.gridy = 5;
		c.gridwidth = 2;
		c.gridheight = 1;
		layout.setConstraints(avg, c);
		add(avg);
		
		sum = new JLabel("总计", JLabel.CENTER);
		c.gridx = 17;
		layout.setConstraints(sum, c);
		add(sum);
		
		
		mainInfo = new Table(
				new String[] {"场均得分", "场均篮板", "场均助攻"},
				new String[][] {{"0", "0", "0"}});
		mainInfo.hidtp(true);
		c.gridx = 8;
		c.gridy = 3;
		c.gridwidth = 6;
		c.gridheight = 2;
		layout.setConstraints(mainInfo, c);
		add(mainInfo);
		
		sumInfo = new Table(
				new String[] {"总1", "总2", "总3", "总4", "总5", "总6", "总7"},
				new String[][] {{"0", "0", "0", "0", "0", "0", "0"}});
		sumInfo.hidtp(true);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 19;
		c.gridheight = 3;
		layout.setConstraints(sumInfo, c);
		//add(sumInfo);
		
		avgInfo = new Table(
				new String[] {"均1", "均2", "均3", "均4", "均5"},
				new String[][] {{"0", "0", "0", "0", "0"}});
		avgInfo.hidtp(true);
		layout.setConstraints(avgInfo, c);
		add(avgInfo);
		
		
	}
}
