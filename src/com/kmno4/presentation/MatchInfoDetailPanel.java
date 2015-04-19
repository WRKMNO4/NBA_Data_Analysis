package com.kmno4.presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import PO.MatchPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.BorderLabel;
import com.kmno4.presentation.table.SlideTable;
import com.kmno4.presentation.table.SmallTable;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MatchInfoDetailPanel extends JPanel {
	private MatchInfoDetailFrame matchInfoDetailFrame;
	private MatchPO matchPO;
	
	private TeamPanel team1, team2;
	private JLabel 
	    vs,
	    score,
	    data;
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	
	public MatchInfoDetailPanel(MatchPO p, MatchInfoDetailFrame f) {
		matchInfoDetailFrame = f;
		matchPO = p;
		setBounds(0, 0, f.getWidth(), f.getHeight());
		setBackground(new Color(255, 255, 255, 0));
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
		score.setEnabled(false);
		score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!score.isEnabled()) return;
				team1.changeTable();
				team2.changeTable();
				score.setEnabled(false);
				data.setEnabled(true);
			}
		});
		
		data = new JLabel("球员数据");
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		layout.setConstraints(data, c);
		add(data);
		data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!data.isEnabled()) return;
				team1.changeTable();
				team2.changeTable();
				data.setEnabled(false);
				score.setEnabled(true);
			}
		});
	}
	
	private static final int 
	    HEAD_ICON_WIDTH = 200,
	    HEAD_ICON_HEIGHT = 200;
	
	class TeamPanel extends JPanel {
		private JLabel 
		    headLabel,
		    blankLabel;
		private SlideTable dataTable;
		private SmallTable scoreTable;
		private boolean isScoreTable;
		private GridBagLayout gbl;
		private GridBagConstraints gbc;
		public TeamPanel() {
			isScoreTable = true;
			gbl = new GridBagLayout();
			setLayout(gbl);
			gbc = new GridBagConstraints();
			
			headLabel = new BorderLabel("头像");
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 2;
			gbc.weightx = 3;
			gbc.weighty = 2;
			gbc.fill = GridBagConstraints.BOTH;
			gbl.setConstraints(headLabel, gbc);
			add(headLabel);
			
			blankLabel = new JLabel();
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 8;
			gbc.weighty = 1;
			gbl.setConstraints(blankLabel, gbc);
			add(blankLabel);
			
			scoreTable = new SmallTable(new String[]{"第一节", "第二节", "第三节", "第四节", "总计"}, 
					new String[][]{{"10", "20", "30", "40", "100"}});
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 8;
			gbc.weighty = 0.5;
			gbc_score = (GridBagConstraints)gbc.clone();
			gbl.setConstraints(scoreTable, gbc_score);
			add(scoreTable);
			
			gbc_data = (GridBagConstraints) gbc.clone();
			gbc_data.weighty = 3;
			dataTable = new SlideTable(
					new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}, 
					new String[][]{{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"},
					               {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"},
					               {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}},
					0, 0, 50, 50, Config.MATCH_DETAIL_WIDTH - HEAD_ICON_WIDTH);
			dataTable.setVisible(false);
			
			addTeamLink();
			addPlayerLink();
		}
		
		private GridBagConstraints gbc_score, gbc_data;
		
		public void changeTable() {
			if(isScoreTable) {
				scoreTable.setVisible(false);
				remove(scoreTable);
				dataTable.setVisible(true);
				gbl.setConstraints(dataTable, gbc_data);
				add(dataTable);
			}
			else {
				dataTable.setVisible(false);
				remove(dataTable);
				scoreTable.setVisible(true);
				gbl.setConstraints(scoreTable, gbc_score);
				add(scoreTable);
			}
			isScoreTable = !isScoreTable;
			matchInfoDetailFrame.repaint();
		}
		
		
		private void addTeamLink() {
			headLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//TODO
				}
			});
		}
		private void addPlayerLink() {
			//TODO
		}
		
	}

}
