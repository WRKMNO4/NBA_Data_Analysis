package com.kmno4.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableGroup;

import PO.TeamPO;

@SuppressWarnings("serial")
public class TeamDetailPane extends JPanel {
	private TeamDetailPane teamDetailPane;
	private TeamDetailFrame teamDetailFrame;
	private MainDataPanel mainDataPanel;
	private TableGroup seasonAvgData, seasonSumData, recentData;
	private JLabel seasonLabel, avgLabel, sumLabel, recentLabel;
	private TeamPO teamPO;
	
	private static final int PADDING = 5;
	private static final int 
	    DATA_PANEL_HEIGHT = 0,
	    SEASON_AVG_DATA_TABLE_HEIGHT = 0,
	    SEASON_SUM_DATA_TABLE_HEIGHT = 0,
	    RECENT_DATA_TABLE_HEIGHT = 0,
	    SEASON_LABEL_HEIGHT = 0,
	    AVG_LABEL_HEIGHT = 0,
	    SUM_LABEL_HEIGHT = 0,
	    RECENT_LABEL_HEIGHT = 0;

	
	public TeamDetailPane(TeamPO t, TeamDetailFrame f) {
		teamPO = t;
		teamDetailFrame = f;
		teamDetailPane = this;
		
		mainDataPanel = new MainDataPanel(teamPO);
		mainDataPanel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
		
		seasonLabel = new JLabel();
		seasonLabel.setBounds(
				PADDING, mainDataPanel.getY() + mainDataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, SEASON_LABEL_HEIGHT);
		
		avgLabel = new JLabel();
		avgLabel.setBounds(
				PADDING, seasonLabel.getY() + seasonLabel.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, AVG_LABEL_HEIGHT);
		
		seasonAvgData = new TableGroup();
		
		sumLabel = new JLabel();
		sumLabel.setBounds(
				PADDING, seasonAvgData.jsp.getY() + seasonAvgData.jsp.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, SUM_LABEL_HEIGHT);
		
		seasonSumData = new TableGroup();
		
		recentLabel= new JLabel();
		recentLabel.setBounds(
				PADDING, seasonSumData.jsp.getY() + seasonSumData.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, RECENT_LABEL_HEIGHT);
		
		recentData = new TableGroup();
		
		
		
	}
	
	class MainDataPanel extends JPanel {
		public MainDataPanel(TeamPO teamPO) {
			
		}
	}
}
