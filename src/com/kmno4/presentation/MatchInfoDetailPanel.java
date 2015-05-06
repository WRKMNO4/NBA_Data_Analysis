package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.MatchPO;
import PO.PlayerListPO;
import PO.TeamListPO;
import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

@SuppressWarnings("serial")
public class MatchInfoDetailPanel extends JPanel {
	public static final ImageIcon MATCH_DETAIL_BACKGROUND=new ImageIcon("images/match_detail_bg.png");
	
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
	private TeamPO teamPO1, teamPO2;
	
	private static final int PADDING = 5;
	private static final int 
	    MAIN_DATA_LABEL_HEIGHT = 30,
	    MAIN_DATA_PANEL_HEIGHT = 250,
	    DETAIL_DATA_LABEL_HEIGHT = 30,
	    TEAM_1_LABEL_HEIGHT = 30,
	    TEAM_1_TABLE_HEIGHT = 180,
	    TEAM_2_LABEL_HEIGHT = 30,
	    TEAM_2_TABLE_HEIGHT = 180;
	
	public MatchInfoDetailPanel(MatchPO m, MatchInfoDetailFrame f) {

		matchPO = m;
		matchInfoDetailPanel = this;
		matchInfoDetailFrame = f;
		teamPO1 = TeamListPO.findTeamByShortName(matchPO.getFirstTeam());
		teamPO2 = TeamListPO.findTeamByShortName(matchPO.getSecondTeam());
		setBounds(0, 0, matchInfoDetailFrame.getWidth(), matchInfoDetailFrame.getHeight());
		setLayout(null);
		setBackground(Color.white);
		
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
		
		team1Label = new JLabel(matchPO.getFirstTeam(), JLabel.LEFT);
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
		PlayerDetailPanel.paintTable(team1.table);
		
		team2Label = new JLabel(matchPO.getSecondTeam(), JLabel.LEFT);
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
		PlayerDetailPanel.paintTable(team2.table);
		addLinks();
	}
	private void addLinks() {
		mainDataPanel.team1Logo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new TeamDetailFrame(teamPO1);
			}
		});
		mainDataPanel.team2Logo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new TeamDetailFrame(teamPO2);
			}
		});
		team1.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = team1.table.rowAtPoint(e.getPoint());
				if(row == 0) return;
				new PlayerDetailFrame(PlayerListPO.findPlayerAccurately(
						team1.table.getValueAt(row, 0).toString()));
			}
		});
		team2.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = team2.table.rowAtPoint(e.getPoint());
				if(row == 0) return;
				new PlayerDetailFrame(PlayerListPO.findPlayerAccurately(
						team2.table.getValueAt(row, 0).toString()));
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.MATCH_DETAIL_BACKGROUND.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	class MainDataPanel extends JPanel {
		public JLabel team1Logo, team2Logo, vsLabel;
		public JLabel bg;
		public TableGroup mainScore;
		
		public MainDataPanel(MatchPO matchPO) {
			setLayout(null);
			setBackground(Color.white);
			
			team1Logo = new JLabel();
			team1Logo.setBounds(0, 0, MAIN_DATA_PANEL_HEIGHT, MAIN_DATA_PANEL_HEIGHT);
			PlayerDetailPanel.fillLabel(
					teamPO1.getTeamLogoURL(),
					team1Logo, team1Logo.getWidth(), team1Logo.getHeight());
			add(team1Logo);
			
			
			team2Logo = new JLabel();
			team2Logo.setBounds(Config.UI_WIDTH - 2 * PADDING - MAIN_DATA_PANEL_HEIGHT, 0,
					MAIN_DATA_PANEL_HEIGHT, MAIN_DATA_PANEL_HEIGHT);
			PlayerDetailPanel.fillLabel(
					teamPO2.getTeamLogoURL(),
					team2Logo, team2Logo.getWidth(), team2Logo.getHeight());
			add(team2Logo);
			
			vsLabel = new JLabel("vs", JLabel.CENTER);
			vsLabel.setFont(new Font("default", 2, 60));
			vsLabel.setBounds(430, 0, 140, 140);
			add(vsLabel);
			
			mainScore = new TableGroup();
			TableFactory.createTable(
					mainScore, matchInfoDetailFrame,
					TableContentTransfer.transferMatchScores(matchPO),
					Config.UI_WIDTH - 4 * PADDING - 2 * MAIN_DATA_PANEL_HEIGHT, 100,
					MAIN_DATA_PANEL_HEIGHT + 2 * PADDING, 150,
					26, 26,
					90);
			PlayerDetailPanel.paintTable(mainScore.table);
			
		}
	}
}
