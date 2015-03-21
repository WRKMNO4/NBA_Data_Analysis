package com.kmno4.presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.Table;

@SuppressWarnings("serial")
public class TeamDetailPanel extends JPanel {
	private TeamDetailPanel teamDetailPanel = this;
	private JLabel
	    team_icon;
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
	}
	
	
	
	
	
}
