package com.kmno4.presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.kmno4.presentation.table.SlideTable;
import com.kmno4.presentation.table.Table;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MatchInfoDetailPanel extends JPanel {
	private MatchInfoDetailPanel matchInfoDetailPanel;
	private MatchInfoDetailFrame matchInfoDetailFrame;
	
	private JPanel team1, team2;
	private JLabel 
	    vs,
	    score,
	    data;
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	public MatchInfoDetailPanel(MatchInfoDetailFrame f) {
		matchInfoDetailFrame = f;
		matchInfoDetailPanel = this;
		setBounds(0, 0, 700, 600);
		setBackground(new Color(255, 255, 255, 255));
		layout = new GridBagLayout();
		setLayout(layout);
		c = new GridBagConstraints();
		
		team1 = new TeamPanel();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 10;
		c.weighty = 4;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team1, c);
		add(team1);
		
		team2 = new TeamPanel();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 10;
		c.weighty = 4;
		layout.setConstraints(team2, c);
		add(team2);
		
		vs = new JLabel();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 8;
		c.weighty = 1;
		layout.setConstraints(vs, c);
		add(vs);
		
		score = new JLabel("得分情况");
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(score, c);
		add(score);
		
		data = new JLabel("球员数据");
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		layout.setConstraints(data, c);
		add(data);
		
	}
	
	
	class TeamPanel extends JPanel {
		private JLabel 
		    headLabel,
		    blankLabel;
		private SlideTable
		    scoreTable,
		    dataTable;
		private boolean isScoreTable;
		private GridBagLayout gbl;
		private GridBagConstraints gbc;
		public TeamPanel() {
			isScoreTable = false;
			gbl = new GridBagLayout();
			setLayout(gbl);
			gbc = new GridBagConstraints();
			
			headLabel = new JLabel();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 2;
			gbc.weightx = 3;
			gbc.weighty = 2;
			gbl.setConstraints(headLabel, gbc);
			add(headLabel);
			//TODO
			blankLabel = new JLabel();
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 8;
			gbc.weighty = 1;
			gbl.setConstraints(blankLabel, gbc);
			add(blankLabel);
			
			scoreTable = new SlideTable(null, null);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 8;
			gbc.weighty = 1;
			gbl.setConstraints(scoreTable, gbc);
			add(scoreTable);
			
			dataTable = new SlideTable(null, null);
		}
		
		public void changeTable() {
			if(isScoreTable) {
				remove(scoreTable);
				gbl.setConstraints(dataTable, gbc);
				add(dataTable);
			}
			else {
				remove(dataTable);
				gbl.setConstraints(scoreTable, gbc);
				add(scoreTable);
			}
			matchInfoDetailFrame.repaint();
		}
		
	}

}
