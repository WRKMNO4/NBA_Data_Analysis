package com.kmno4.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

import PO.TeamPO;

@SuppressWarnings("serial")
public class TeamDetailPanel extends JPanel {
	private TeamDetailPanel teamDetailPane;
	private TeamDetailFrame teamDetailFrame;
	private MainDataPanel mainDataPanel;
	private TableGroup seasonAvgData, seasonSumData, recentData;
	private JLabel seasonLabel, avgLabel, sumLabel, recentLabel;
	private TeamPO teamPO;
	
	private static final int PADDING = 5;
	private static final int 
	    DATA_PANEL_HEIGHT = 200,
	    SEASON_AVG_DATA_TABLE_HEIGHT = 120,
	    SEASON_SUM_DATA_TABLE_HEIGHT = SEASON_AVG_DATA_TABLE_HEIGHT,
	    RECENT_DATA_TABLE_HEIGHT = 200,
	    SEASON_LABEL_HEIGHT = 30,
	    AVG_LABEL_HEIGHT = 15,
	    SUM_LABEL_HEIGHT = AVG_LABEL_HEIGHT,
	    RECENT_LABEL_HEIGHT = 30;

	
	public TeamDetailPanel(TeamPO t, TeamDetailFrame f) {
		teamPO = t;
		teamDetailFrame = f;
		teamDetailPane = this;
		setBounds(0, 0, teamDetailFrame.getWidth(), teamDetailFrame.getHeight());
		setLayout(null);
		
		mainDataPanel = new MainDataPanel(teamPO);
		mainDataPanel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
		add(mainDataPanel);
		
		seasonLabel = new JLabel("赛季数据", JLabel.LEFT);
		seasonLabel.setBounds(
				PADDING, mainDataPanel.getY() + mainDataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, SEASON_LABEL_HEIGHT);
		add(seasonLabel);
		
		avgLabel = new JLabel("赛季场均", JLabel.LEFT);
		avgLabel.setBounds(
				PADDING, seasonLabel.getY() + seasonLabel.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, AVG_LABEL_HEIGHT);
		add(avgLabel);
		
		seasonAvgData = new TableGroup();
		TableFactory.createTable(
				seasonAvgData, teamDetailFrame, 
				body,
				Config.UI_WIDTH - PADDING * 2, SEASON_AVG_DATA_TABLE_HEIGHT,
				PADDING, avgLabel.getY() + avgLabel.getHeight());
		
		sumLabel = new JLabel("赛季总计", JLabel.LEFT);
		sumLabel.setBounds(
				PADDING, seasonAvgData.jsp.getY() + seasonAvgData.jsp.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, SUM_LABEL_HEIGHT);
		add(sumLabel);
		
		seasonSumData = new TableGroup();
		TableFactory.createTable(
				seasonSumData, teamDetailFrame, 
				body,
				Config.UI_WIDTH - PADDING * 2, SEASON_SUM_DATA_TABLE_HEIGHT,
				PADDING, sumLabel.getY() + sumLabel.getHeight());
		
		recentLabel= new JLabel("最近五场比赛", JLabel.LEFT);
		recentLabel.setBounds(
				PADDING, seasonSumData.jsp.getY() + seasonSumData.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, RECENT_LABEL_HEIGHT);
		add(recentLabel);
		
		recentData = new TableGroup();
		TableFactory.createTable(
				recentData, teamDetailFrame, 
				body,
				Config.UI_WIDTH - PADDING * 2, RECENT_DATA_TABLE_HEIGHT,
				PADDING, recentLabel.getY() + recentLabel.getHeight());
		
		
		
	}
	
	class MainDataPanel extends JPanel {
		JLabel logoLabel;
		JLabel info1, info2, info3, info4, info5, info6;
		
		
		public MainDataPanel(TeamPO teamPO) {
			
		}
	}
}
