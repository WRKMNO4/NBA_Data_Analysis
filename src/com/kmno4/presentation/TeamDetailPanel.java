package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;

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
	    DATA_PANEL_HEIGHT = 240,
	    SEASON_AVG_DATA_TABLE_HEIGHT = 120,
	    SEASON_SUM_DATA_TABLE_HEIGHT = SEASON_AVG_DATA_TABLE_HEIGHT,
	    RECENT_DATA_TABLE_HEIGHT = 160,
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
		setOpaque(true);
		setBackground(Color.white);
		
		mainDataPanel = new MainDataPanel(teamPO);
		mainDataPanel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
		add(mainDataPanel);
		
		seasonLabel = new JLabel("赛季数据", JLabel.LEFT);
		seasonLabel.setOpaque(true);
		seasonLabel.setFont(new Font("default", 0, 13));
		seasonLabel.setBackground(Color.black);
		seasonLabel.setForeground(Color.white);
		seasonLabel.setBounds(
				PADDING, mainDataPanel.getY() + mainDataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, SEASON_LABEL_HEIGHT);
		add(seasonLabel);
		
		avgLabel = new JLabel("赛季场均", JLabel.LEFT);
		avgLabel.setOpaque(true);
		avgLabel.setFont(new Font("default", 0, 11));
		avgLabel.setBackground(Color.gray);
		avgLabel.setForeground(Color.white);
		avgLabel.setBounds(
				PADDING, seasonLabel.getY() + seasonLabel.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, AVG_LABEL_HEIGHT);
		add(avgLabel);
		
		seasonAvgData = new TableGroup();
		TableFactory.createTable(
				seasonAvgData, teamDetailFrame, 
				TableContentTransfer.transferTeamAvgInfo(teamPO),
				Config.UI_WIDTH - PADDING * 2, SEASON_AVG_DATA_TABLE_HEIGHT,
				PADDING, avgLabel.getY() + avgLabel.getHeight());
		PlayerDetailPanel.paintTable(seasonAvgData.table);
		
		sumLabel = new JLabel("赛季总计", JLabel.LEFT);
		sumLabel.setOpaque(true);
		sumLabel.setFont(new Font("default", 0, 11));
		sumLabel.setBackground(Color.gray);
		sumLabel.setForeground(Color.white);
		sumLabel.setBounds(
				PADDING, seasonAvgData.jsp.getY() + seasonAvgData.jsp.getHeight(), 
				Config.UI_WIDTH - PADDING * 2, SUM_LABEL_HEIGHT);
		add(sumLabel);
		
		seasonSumData = new TableGroup();
		TableFactory.createTable(
				seasonSumData, teamDetailFrame, 
				TableContentTransfer.transferTeamTotalInfo(teamPO),
				Config.UI_WIDTH - PADDING * 2, SEASON_SUM_DATA_TABLE_HEIGHT,
				PADDING, sumLabel.getY() + sumLabel.getHeight());
		PlayerDetailPanel.paintTable(seasonSumData.table);
		
		recentLabel= new JLabel("最近五场比赛", JLabel.LEFT);
		recentLabel.setFont(new Font("default", 0, 13));
		recentLabel.setBackground(Color.black);
		recentLabel.setForeground(Color.white);
		recentLabel.setOpaque(true);
		recentLabel.setBounds(
				PADDING, seasonSumData.jsp.getY() + seasonSumData.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, RECENT_LABEL_HEIGHT);
		add(recentLabel);
		
		recentData = new TableGroup();
		TableFactory.createTable(
				recentData, teamDetailFrame, 
				TableContentTransfer.transferTeamRecentMatch(teamPO),
				Config.UI_WIDTH - PADDING * 2, RECENT_DATA_TABLE_HEIGHT,
				PADDING, recentLabel.getY() + recentLabel.getHeight());
		PlayerDetailPanel.paintTable(recentData.table);
		
		
	}
	
	private static final String TEAM_DETAIL_TOP_BG = "images/player_detail_bg.png";
	class MainDataPanel extends JPanel {
		public JLabel bgLabel;
		public JLabel logoLabel;
		public JLabel info1, info2, info3, info4, info5, info6;
		
		
		public MainDataPanel(TeamPO teamPO) {
			setLayout(null);
			
			logoLabel = new JLabel();
			logoLabel.setBounds(20, 0, 230, 230);
			PlayerDetailPanel.fillLabel(teamPO.getTeamLogoURL(), logoLabel, logoLabel.getWidth(), logoLabel.getHeight());
			add(logoLabel);
			
			info1 = new JLabel("名称/缩写 : " + teamPO.getFullName() + "/" + teamPO.getShortName());
//			info1.setBounds(x, y, width, height);
			info1.setFont(new Font("default", 0, 30));
			add(info1);
			info2 = new JLabel("所在地 : " + teamPO.getCity());
			add(info1);
			info3 = new JLabel("赛区 : " + teamPO.getZone().toString());
			add(info1);
			info4 = new JLabel("分区 : " + teamPO.getDistrict());
			add(info1);
			info5 = new JLabel("主场 : " + teamPO.getHomeCourt());
			add(info1);
			info6 = new JLabel("建立时间 : " + teamPO.getTimeOfEstablishment());
			add(info1);
			
			
			
			
			
			
			
			
			bgLabel = new JLabel();
			PlayerDetailPanel.fillLabel(TEAM_DETAIL_TOP_BG, bgLabel, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
			bgLabel.setBounds(0, 0, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
			add(bgLabel);
		}
	}
}
