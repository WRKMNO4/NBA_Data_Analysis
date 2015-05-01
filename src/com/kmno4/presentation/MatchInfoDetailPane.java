package com.kmno4.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableGroup;

import PO.MatchPO;

@SuppressWarnings("serial")
public class MatchInfoDetailPane extends JPanel {
	private MatchInfoDetailFrame matchInfoDetailFrame;
	private MatchInfoDetailPane matchInfoDetailPanel;
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
	    MAIN_DATA_LABEL_HEIGHT = 0,
	    MAIN_DATA_PANEL_HEIGHT = 0,
	    DETAIL_DATA_LABEL_HEIGHT = 0,
	    TEAM_1_LABEL_HEIGHT = 0,
	    TEAM_1_TABLE_HEIGHT = 0,
	    TEAM_2_LABEL_HEIGHT = 0,
	    TEAM_2_TABLE_HEIGHT = 0;
	
	public MatchInfoDetailPane(MatchPO m, MatchInfoDetailFrame f) {
		matchPO = m;
		matchInfoDetailPanel = this;
		matchInfoDetailFrame = f;
		
		mainDataLabel = new JLabel();
		mainDataLabel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, MAIN_DATA_LABEL_HEIGHT);
		
		mainDataPanel = new MainDataPanel(matchPO);
		mainDataPanel.setBounds(
				PADDING, mainDataLabel.getY() + mainDataLabel.getHeight(),
				Config.UI_WIDTH - PADDING * 2, MAIN_DATA_PANEL_HEIGHT);
		
		detailDataLabel = new JLabel();
		detailDataLabel.setBounds(
				PADDING, mainDataPanel.getY() + mainDataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, DETAIL_DATA_LABEL_HEIGHT);
		
		team1Label = new JLabel();
		team1Label.setBounds(
				PADDING, detailDataLabel.getY() + detailDataLabel.getHeight(),
				Config.UI_WIDTH - PADDING * 2, TEAM_1_LABEL_HEIGHT);
		
		team1 = new TableGroup();
		
		team2Label = new JLabel();
		team2Label.setBounds(
				PADDING, team1.jsp.getY() + team1.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, TEAM_2_LABEL_HEIGHT);
		
		team2 = new TableGroup();
		
	}
	
	class MainDataPanel extends JPanel {
		public MainDataPanel(MatchPO matchPO) {
			
		}
	}
}
