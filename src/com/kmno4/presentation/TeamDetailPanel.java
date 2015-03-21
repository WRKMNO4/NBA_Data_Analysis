package com.kmno4.presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.BorderLabel;
import com.kmno4.presentation.table.Table;

@SuppressWarnings("serial")
public class TeamDetailPanel extends JPanel {
	private TeamDetailPanel teamDetailPanel = this;
	private JLabel
	    team_icon,
	    team_name,
	    team_coach,
	    team_achi,
	    avg,
	    sum;
	private Table
	    mainInfo,
	    sumInfo,
	    avgInfo;
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	public TeamDetailPanel() {
		setBounds(0, 0,
				Config.PLAYER_DETAIL_UI_WIDTH,Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setBackground(Color.WHITE);
		layout = new GridBagLayout();
		setLayout(layout);
		c = new GridBagConstraints();
		
		team_icon = new BorderLabel("队伍头像", JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.weightx = 4;
		c.weighty = 4;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_icon, c);
		add(team_icon);
		
		team_name = new BorderLabel("", JLabel.CENTER);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 2;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_name, c);
		add(team_name);
		
		team_coach = new BorderLabel("", JLabel.CENTER);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_coach, c);
		add(team_coach);
		
		team_achi = new BorderLabel("", JLabel.CENTER);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 2;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_achi, c);
		add(team_achi);
		
		sum = new BorderLabel("总计", JLabel.CENTER);
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(sum, c);
		add(sum);
		
		avg = new BorderLabel("平均", JLabel.CENTER);
		c.gridx = 5;
		layout.setConstraints(avg, c);
		add(avg);
		
		mainInfo = new Table(
				new String[]{"", "", "", ""},
				new String[][]{{"", "", "", ""}},
				true);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 6;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(mainInfo, c);
		add(mainInfo);
		
		sumInfo = new Table(
				new String[]{"", "", "", "", "", "", ""},
				new String[][]{
						{"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}},
				true);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 6;
		c.gridheight = 1;
		c.weightx = 12;
		c.weighty = 3;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(sumInfo, c);
		add(sumInfo);
		
		avgInfo = new Table(
				new String[]{"", "", "", "", "", "", ""},
				new String[][]{
						{"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}},
				true);
		layout.setConstraints(avgInfo, c);
		//add(avgInfo);
		
	}
	
	
	
	
	
}
