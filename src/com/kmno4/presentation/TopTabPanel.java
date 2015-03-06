package com.kmno4.presentation;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class TopTabPanel extends JPanel {
	
	private List<JLabel> tabs;
	
	private JLabel player;
	private JLabel match;
	private JLabel team;
	private JLabel help;
	private JLabel aboutus;

	/**
	 * Create the panel.
	 */
	public TopTabPanel() {
		
		this.setBounds(0, 0, Config.UI_WIDTH, Config.TOP_TAB_HEIGHT);
		this.setBackground(Color.BLUE);
		setLayout(null);
		
		player = new JLabel("球员");
		team = new JLabel("球队");
		match = new JLabel("比赛");
		help = new JLabel("帮助");
		aboutus = new JLabel("关于");

		tabs=new ArrayList<JLabel>();
		
		tabs.add(player);
		tabs.add(team);
		tabs.add(match);
		tabs.add(help);
		tabs.add(aboutus);
		
//		for(int i=0;i<tabs.size();i++){
//			tabs.get(i).setBounds(Config.UI_WIDTH-(tabs.size()-i)*Config.TOP_TAB_LABLE_WIDTH, 
//					Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, 
//					Config.TOP_TAB_LABLE_WIDTH,
//					Config.TOP_TAB_LABLE_HEIGHT);
//			tabs.get(i).setBackground(Color.WHITE);
//			this.add(tabs.get(i));
//			}
		
		player.setBounds(Config.UI_WIDTH-5*Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_LABLE_HEIGHT);
		player.setBackground(Color.WHITE);
		add(player);
		
		team.setBounds(Config.UI_WIDTH-4*Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_LABLE_HEIGHT);
		team.setBackground(Color.WHITE);
		add(team);
		
		match.setBounds(Config.UI_WIDTH-3*Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_LABLE_HEIGHT);
		match.setBackground(Color.WHITE);
		add(match);
		
		help.setBounds(Config.UI_WIDTH-2*Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_LABLE_HEIGHT);
		help.setBackground(Color.WHITE);
		add(help);
		
		aboutus.setBounds(Config.UI_WIDTH-1*Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_LABLE_HEIGHT);
		aboutus.setBackground(Color.WHITE);
		add(aboutus);

	}
}
