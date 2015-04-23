package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import PO.MatchPO;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerListPO;
import PO.TeamListPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.BorderLabel;
import com.kmno4.presentation.table.SlideTable;
import com.kmno4.presentation.table.SmallTable;
import com.kmno4.presentation.table.TableList;

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
		setBackground(Color.white);
		layout = new GridBagLayout();
		setLayout(layout);
		c = new GridBagConstraints();
		
		team1 = new TeamPanel(true);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 10;
		c.weighty = 4;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team1, c);
		add(team1);
		
		team2 = new TeamPanel(false);
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
	    HEAD_ICON_WIDTH = 250,
	    HEAD_ICON_HEIGHT = 250;
	
	class TeamPanel extends JPanel {
		private JLabel 
		    headLabel,
		    blankLabel;
		private SlideTable dataTable;
		private SmallTable scoreTable;
		private boolean isScoreTable;
		private GridBagLayout gbl;
		private GridBagConstraints gbc;
		
		private boolean isFirstTeam;
		public TeamPanel(boolean isFirstTeam) {
			this.isFirstTeam = isFirstTeam;
			setBackground(Color.white);
			isScoreTable = true;
			gbl = new GridBagLayout();
			setLayout(gbl);
			gbc = new GridBagConstraints();
			gbc_data = new GridBagConstraints();
			gbc_score = new GridBagConstraints();
			
			headLabel = new JLabel();
			TeamDetailPanel.fillIcon(
					headLabel,
					isFirstTeam ? TeamListPO.findTeamByShortName(matchPO.getFirstTeam()).getTeamLogoURL() : TeamListPO.findTeamByShortName(matchPO.getSecondTeam()).getTeamLogoURL(),
					HEAD_ICON_WIDTH,
					HEAD_ICON_HEIGHT);
			gbc.gridx = 0;
			gbc.gridy = 0;	
			gbc.gridwidth = 1;
			gbc.gridheight = 2;
			gbc.weightx = 2;
			gbc.weighty = 1;
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
			gbc.fill = GridBagConstraints.BOTH;
			gbl.setConstraints(blankLabel, gbc);
			add(blankLabel);
			
			String[] score_head;
			String[][] score_body;
			score_head = new String[matchPO.getAllScore().size()];
			score_head[0] = new String("第1节");
			score_head[1] = new String("第2节");
			score_head[2] = new String("第3节");
			score_head[3] = new String("第4节");
			if(score_head.length > 4) {
				for(int i = 4; i < score_head.length; i ++) {
					score_head[i] = new String("加时第" + (i - 3) + "节");
				}
			}
			score_body = TableContentTransfer.transferMatchScores(
					matchPO.getAllScore(),
					matchPO.getAllScore().size(),
					isFirstTeam ? 1 : 2);
			scoreTable = new SmallTable(score_head, score_body);
			scoreTable.setFont(new Font("default", Font.PLAIN, 17), new Font("default", Font.PLAIN, 15));
			gbc_score.gridx = 1;
			gbc_score.gridy = 1;
			gbc_score.gridwidth = 1;
			gbc_score.gridheight = 1;
			gbc_score.weightx = 8;
			gbc_score.weighty = 1;
			gbc_score.fill = GridBagConstraints.HORIZONTAL;
			gbl.setConstraints(scoreTable, gbc_score);
			add(scoreTable);
			
			
			
			
			
			String[][] data_body;
			ArrayList<PlayerDataOfOneMatchPO> pd;
			if(isFirstTeam) pd = matchPO.getFirstTeam_PlayerData();
			else pd = matchPO.getSecondTeam_PlayerData();
			data_body = TableContentTransfer.transferMatchDetailInfo(pd, Config.MATCH_DETAIL_INFO.length);
			for(int i = 0; i < data_body.length; i ++)
				for(int j = 0; j < data_body[0].length; j ++)
					System.out.println(data_body[i][j]);
			
			dataTable = new SlideTable(
					Config.MATCH_DETAIL_INFO, 
					data_body,
					70, 23, 500);
			dataTable.setFont(new Font("default", Font.PLAIN, 11), new Font("default", Font.PLAIN, 11), null);
			gbc_data.gridx = 1;
			gbc_data.gridy = 1;
			gbc_data.gridwidth = 1;
			gbc_data.gridheight = 1;
			gbc_data.weightx = 14;
			gbc_data.weighty = 16;
			gbc_data.fill = GridBagConstraints.BOTH;
			gbc_data.anchor = GridBagConstraints.WEST;
			
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
					if(isFirstTeam) 
						new TeamDetailFrame(TeamListPO.findTeamByShortName(matchPO.getFirstTeam()));
					else
						new TeamDetailFrame(TeamListPO.findTeamByShortName(matchPO.getSecondTeam()));
				}
			});
		}
		private void addPlayerLink() {
			TableList[] t = dataTable.table.body[0];
			for(int i = 0; i < t.length; i ++) {
				final int j = i;
				t[j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						new PlayerDetailFrame(PlayerListPO.findPlayerAccurately(t[j].elements[0].getText()));
					}
				});
			}
			
		}
		
		
		
		
		
		
	}

}
