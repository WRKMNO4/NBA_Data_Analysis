package com.kmno4.presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.BorderLabel;
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
		player_icon = new BorderLabel("球员照片", JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.weightx = 3;
		c.weighty = 3;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(player_icon, c);
		add(player_icon);
		
		player_num = new BorderLabel("球衣号", JLabel.CENTER);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		layout.setConstraints(player_num, c);
		add(player_num);
		
		player_name = new BorderLabel("name", JLabel.CENTER);
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 2;
		c.weighty = 1;
		layout.setConstraints(player_name, c);
		add(player_name);
		
		player_place = new BorderLabel("位置", JLabel.CENTER);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 1;
		layout.setConstraints(player_place, c);
		add(player_place);
		
		player_team = new BorderLabel("服役球队", JLabel.CENTER);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.weightx = 3;
		c.weighty = 2;
		layout.setConstraints(player_team, c);
		add(player_team);
		
		avg = new BorderLabel("场均", JLabel.CENTER);
		avg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		layout.setConstraints(avg, c);
		add(avg);
		
		sum = new BorderLabel("总计", JLabel.CENTER);
		c.gridx = 4;
		layout.setConstraints(sum, c);
		add(sum);
		
		
		mainInfo = new Table(
				new String[] {"A", "B", "C"},
				new String[][] {{"0", "0", "0"}},
				true);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(mainInfo, c);
		add(mainInfo);
		
		sumInfo = new Table(
				new String[] {"s1", "s2", "s3", "s4", "s5", "s6", "s7"},
				new String[][] {{"0", "0", "0", "0", "0", "0", "0"}},
				true);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 5;
		c.gridheight = 1;
		c.weightx = 9;
		c.weighty = 1;
		layout.setConstraints(sumInfo, c);
		add(sumInfo);
		
		avgInfo = new Table(
				new String[] {"a1", "a2", "a3", "a4", "a5"},
				new String[][] {{"0", "0", "0", "0", "0"}},
				true);
		layout.setConstraints(avgInfo, c);
		//add(avgInfo);
		
		
	}
}
