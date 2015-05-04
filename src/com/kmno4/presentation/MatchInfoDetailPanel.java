package com.kmno4.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

import PO.MatchPO;

@SuppressWarnings("serial")
public class MatchInfoDetailPanel extends JPanel {
	private MatchInfoDetailFrame matchInfoDetailFrame;
	private MatchInfoDetailPanel matchInfoDetailPanel;
	private MainDataPanel mainDataPanel;
	private TableGroup team1, team2;
	private JLabel 
	    mainDataLabel,
	    detailDataLabel,
	    team1Label,
	    team2Label;
	private MatchPO matchPO;
	
	private static final int PADDING = 5;
	private static final int 
	    MAIN_DATA_LABEL_HEIGHT = 30,
	    MAIN_DATA_PANEL_HEIGHT = 200,
	    DETAIL_DATA_LABEL_HEIGHT = 30,
	    TEAM_1_LABEL_HEIGHT = 30,
	    TEAM_1_TABLE_HEIGHT = 155,
	    TEAM_2_LABEL_HEIGHT = 30,
	    TEAM_2_TABLE_HEIGHT = 155;
	
	public MatchInfoDetailPanel(MatchPO m, MatchInfoDetailFrame f) {
		matchPO = m;
		matchInfoDetailPanel = this;
		matchInfoDetailFrame = f;
		setBounds(0, 0, matchInfoDetailFrame.getWidth(), matchInfoDetailFrame.getHeight());
		setLayout(null);
		
		mainDataLabel = new JLabel(matchPO.getFirstTeam() + "@" + matchPO.getSecondTeam(), JLabel.LEFT);
		mainDataLabel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, MAIN_DATA_LABEL_HEIGHT);
		add(mainDataLabel);
		
		mainDataPanel = new MainDataPanel(matchPO);
		mainDataPanel.setBounds(
				PADDING, mainDataLabel.getY() + mainDataLabel.getHeight(),
				Config.UI_WIDTH - PADDING * 2, MAIN_DATA_PANEL_HEIGHT);
		add(mainDataPanel);
		
		detailDataLabel = new JLabel("技术统计", JLabel.LEFT);
		detailDataLabel.setBounds(
				PADDING, mainDataPanel.getY() + mainDataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, DETAIL_DATA_LABEL_HEIGHT);
		add(detailDataLabel);
		
		team1Label = new JLabel();
		team1Label.setBounds(
				PADDING, detailDataLabel.getY() + detailDataLabel.getHeight(),
				Config.UI_WIDTH - PADDING * 2, TEAM_1_LABEL_HEIGHT);
		add(team1Label);
		
		team1 = new TableGroup();
		TableFactory.createTable(
				team1, matchInfoDetailFrame,
				TableContentTransfer.transferMatchDetailInfo(matchPO.getFirstTeam_PlayerData()),
				Config.UI_WIDTH - PADDING * 2, TEAM_1_TABLE_HEIGHT,
				PADDING, team1Label.getY() + team1Label.getHeight());
		
		team2Label = new JLabel();
		team2Label.setBounds(
				PADDING, team1.jsp.getY() + team1.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, TEAM_2_LABEL_HEIGHT);
		add(team2Label);
		
		team2 = new TableGroup();
		TableFactory.createTable(
				team2, matchInfoDetailFrame,
				TableContentTransfer.transferMatchDetailInfo(matchPO.getSecondTeam_PlayerData()),
				Config.UI_WIDTH - PADDING * 2, TEAM_2_TABLE_HEIGHT,
				PADDING, team2Label.getY() + team2Label.getHeight());
		
	}
	
	class MainDataPanel extends JPanel {
		JLabel team1Logo, team2Logo;
		JLabel 
		    t1Info1, t1Info2, t1Info3,
		    t2Info1, t2Info2, t2Info3;
		JTable mainScore;
		
		public MainDataPanel(MatchPO matchPO) {
			
		}
	}
}
