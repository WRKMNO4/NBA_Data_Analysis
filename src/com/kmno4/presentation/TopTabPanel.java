package com.kmno4.presentation;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import PO.MatchPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.StandingDataPO;
import PO.TeamListPO;
import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;
import com.kmno4.presentation.table.TableFactory;

@SuppressWarnings("serial")
public class TopTabPanel extends JPanel implements MouseListener{
	
	public List<JLabel> tabs;
	
	private JLabel player;
	private JLabel match;
	private JLabel team;
	private JLabel hot;
	private JLabel aboutus;
	private JLabel close;
	
	private JScrollPane dataTableSP;
	private JTable dataTable;
	private TableModel dataTableModel;
	private TableCellRenderer tcr;

	/**
	 * Create the panel.
	 */
	public TopTabPanel() {
		
		this.setBounds(0, 0, Config.UI_WIDTH, Config.TOP_TAB_HEIGHT);
		this.setBackground(Color.GRAY);
		setLayout(null);
		
		
		close = new ExitLabel(MainFrame.mainFrame);
		add(close);
		
		
		player = new JLabel("球员");
		player.addMouseListener(this);
		player.setIcon(Config.TAB_PLAYER_UNPRESSED);
		team = new JLabel("球队");
		team.addMouseListener(this);
		team.setIcon(Config.TAB_TEAM_UNPRESSED);
		match = new JLabel("比赛");
		match.addMouseListener(this);
		match.setIcon(Config.TAB_MATCH_UNPRESSED);
		hot = new JLabel("帮助");
		hot.addMouseListener(this);
		hot.setIcon(Config.TAB_HOT_UNPRESSED);
		aboutus = new JLabel("关于");
		aboutus.addMouseListener(this);
		aboutus.setIcon(Config.TAB_ABOUT_UNPRESSED);

		tabs=new ArrayList<JLabel>();
		
		tabs.add(player);
		tabs.add(team);
		tabs.add(match);
		tabs.add(hot);
		tabs.add(aboutus);
		
		for(int i=0;i<tabs.size();i++){
			tabs.get(i).setBounds(Config.UI_WIDTH-(tabs.size()-i)*Config.TOP_TAB_LABLE_WIDTH, 
					Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT, 
					Config.TOP_TAB_LABLE_WIDTH,
					Config.TOP_TAB_LABLE_HEIGHT);
			tabs.get(i).setBackground(Color.WHITE);
			this.add(tabs.get(i));
		}
		
		player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPlayerInfo();
			}

		});
		team.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTeamInfo();
			}
		});
		match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMatchInfo();
			}
		});
		
		hot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHotInfo();
			}
		});
		
		aboutus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAboutUsInfo();
			}
		});
	}
	/**
	 * 在所有panel初始化之后的初始化
	 */
	public void ini() { showPlayerInfo(); }
	
	public void showPlayerInfo(){
		//显示playerPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
		MainFrame.mainFrame.playerSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.matchSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.hotSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		
		MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.球员信息.toString());
		
		refreshPlayerTable(MainFrame.mainFrame.players);
		MainFrame.mainFrame.repaint();
	}
	
	public void showTeamInfo(){
		//显示teamPanel，移开其他panel,所有PANEL统一隐藏在Frame左边		
		MainFrame.mainFrame.teamSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.hotSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.matchSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.球队信息.toString());
		
		refreshTeamTable(MainFrame.mainFrame.teams);
		MainFrame.mainFrame.repaint();
	}
	
	public void showMatchInfo(){
		//显示matchPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
		MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.matchSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.hotSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		
		MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.比赛信息.toString());
		
		refreshMatchTable(MainFrame.mainFrame.bl.getAllMatches(Config.LASTEST_SEASON));
		MainFrame.mainFrame.repaint();
	}
	
	public void showHotInfo(){
		MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.matchSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.hotSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		
		MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.热点信息.toString());
		
		refreshDailyPlayerTable(null, null, null);
		MainFrame.mainFrame.repaint();
		
	}
	
	public void showAboutUsInfo(){}
	
	
	
	//画背景
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Config.TOP_TAB_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.TOP_TAB_HEIGHT,this);
	} 
	
	/**
	 * 每次调用即刷新player列表
	 * @param players
	 */
	public void refreshPlayerTable(List<PlayerPO> players){
		System.out.println("TopTabPanel.refreshPlayerTable()");
		if(dataTable != null) dataTable.setVisible(false);
		if(dataTableSP != null) {
			dataTableSP.setVisible(false);
			MainFrame.mainFrame.remove(dataTableSP);
		}
		if(players == null || players.size() == 0) return;
		setTable(TableContentTransfer.transferPlayerBasicInfo(Config.PLAYER_BASIC_INFO.length, players));
		addPlayerLink();
		MainFrame.mainFrame.repaint();
	}
	/**
	 * 刷新team列表
	 * @param teams
	 */
	public void refreshTeamTable(ArrayList<TeamPO> teams) {
		System.out.println("TopTabPanel.refreshTeamTable()");
		if(dataTable != null) dataTable.setVisible(false);
		if(dataTableSP != null) {
			dataTableSP.setVisible(false);
			MainFrame.mainFrame.remove(dataTableSP);
		}
		if(teams == null || teams.size() == 0) return;
		setTable(TableContentTransfer.transferTeamBasicInfo(Config.TEAM_BASIC_INFO.length, teams));
		addTeamLink();
		MainFrame.mainFrame.repaint();
	}
	/**
	 * 刷新match列表
	 */
	public void refreshMatchTable(ArrayList<MatchPO> matches) {
		System.out.println("TopTabPanel.refreshMatchTable()");
		if(dataTable != null) dataTable.setVisible(false);
		if(dataTableSP != null) {
			dataTableSP.setVisible(false);
			MainFrame.mainFrame.remove(dataTableSP);
		}
		if(matches == null || matches.size() == 0) return;
		setTable(TableContentTransfer.transferMatchBasicInfo(Config.MATCH_BASIC_INFO.length, matches));
		addMatchLink();
		MainFrame.mainFrame.repaint();
	}
	
	public void refreshDailyPlayerTable(Season season, String date, PlayerData dataType) {
		if(dataTable != null) dataTable.setVisible(false);
		if(dataTableSP != null) {
			dataTableSP.setVisible(false);
			MainFrame.mainFrame.remove(dataTableSP);
		}
		if(season == null || date == null || dataType == null) return;
		ArrayList<StandingDataPO> sps = MainFrame.mainFrame.bl.getDatasOfDailyStandingPlayers(dataType);
		if(sps == null || sps.size() == 0) return;
		setTable(TableContentTransfer.transferStandingDailyPlayerInfo(
						Config.STANDING_DAILYPLAYER_TABLEHEAD.length,
						sps));
		addDailyPlayerLink();
		MainFrame.mainFrame.repaint();
	}
	public void refreshSeasonPlayerTable(Season season, PlayerData dataType) {
		if(dataTable != null) dataTable.setVisible(false);
		if(dataTableSP != null) {
			dataTableSP.setVisible(false);
			MainFrame.mainFrame.remove(dataTableSP);
		}
		if(season == null || dataType == null) return;
		setTable(TableContentTransfer.transferStandingSeasonPlayerInfo(
						Config.STANDING_SEASONPLAYER_TABLEHEAD.length,
						MainFrame.mainFrame.bl.getSeasonStandingPlayer(season, dataType), season, dataType));
		addSeasonPlayerLink();
		MainFrame.mainFrame.repaint();
	}
	public void refreshImprovePlayerTable(Season season, PlayerData dataType) {
		if(dataTable != null) dataTable.setVisible(false);
		if(dataTableSP != null) {
			dataTableSP.setVisible(false);
			MainFrame.mainFrame.remove(dataTableSP);
		}
		if(season == null || dataType == null) return;
		setTable(TableContentTransfer.transferStandingImprovedInfo(
						Config.STANDING_IMPROVE_TABLEHEAD.length,
						MainFrame.mainFrame.bl.getMostImprovePlayer(season, dataType), season, dataType));
		addImprovePlayerLink();
		MainFrame.mainFrame.repaint();
	}
	public void refreshSeasonTeamTable(Season season, TeamData dataType) {
		if(dataTable != null) dataTable.setVisible(false);
		if(dataTableSP != null) {
			dataTableSP.setVisible(false);
			MainFrame.mainFrame.remove(dataTableSP);
		}
		if(season == null || dataType == null) return;
		setTable(TableContentTransfer.transferStandingSeasonTeamInfo(
						Config.STANDING_SEASONTEAM_TABLEHEAD.length,
						MainFrame.mainFrame.bl.getSeasonStandingTeam(season, dataType), season, dataType));
		addSeasonTeamLink();
		MainFrame.mainFrame.repaint();
	}
	
	
	private HeadIconFrame headIconFrame;
	private int columNum;
	private static final int PLAYER_LINK = 0;
	private void addPlayerLink() {
//		TableList[][] t = tableBeShowing.body;
//		for(int i = 0; i < t.length; i ++) {
//			for(int j = 0; j < t[0].length; j ++) {
//				if(t[i][j].elements.length == 0) return;
//			    final JLabel label = t[i][j].elements[PLAYER_LINK];
//			    final int fj = j;
//				label.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						PlayerPO p = PlayerListPO.findPlayerAccurately(label.getText());
//						if(p == null) return;
//						new PlayerDetailFrame(p).setVisible(true);
//					}
//					@Override
//					public void mouseEntered(MouseEvent e) {
//						columNum = fj + 1;
//						double labelHeight = (double)tableBeShowing.getHeight() / (double)(tableBeShowing.getRowNum() + 2);
//						double x = (double)MainFrame.mainFrame.getX() +
//								   (double)tableBeShowing.getX() + 
//								   (double)tableBeShowing.getWidth() / tableBeShowing.head.elements.length;
//						double y = (double)MainFrame.mainFrame.getY() +
//								   (double)tableBeShowing.getY() + 
//								   (double)(columNum + 1) * labelHeight;
//						HeadIconFrame f = new HeadIconFrame(
//								PlayerListPO.findPlayerAccurately(label.getText()),
//								(int)x,
//								(int)y);
//						if(headIconFrame != null && headIconFrame.isVisible()) {
//							headIconFrame.setVisible(false);
//							headIconFrame.dispose();
//						}
//						headIconFrame = f;
//					}
//					@Override
//					public void mouseExited(MouseEvent e) {
//						if(headIconFrame != null && headIconFrame.isVisible()) {
//							headIconFrame.setVisible(false);
//							headIconFrame.dispose();
//						}
//					}
//				});
//			}
//		}
		
	}
	private static final int TEAM_LINK = 0;
	private static final int SHORT_NAME_LABEL = 1;
	private void addTeamLink() {
//		TableList[][] t = tableBeShowing.body;
//		for(int i = 0; i < t.length; i ++) {
//			for(int j = 0; j < t[0].length; j ++) {
//				if(t[i][j].elements.length == 0) return;
//			    JLabel label = t[i][j].elements[TEAM_LINK];
//			    final JLabel shortNameLabel = t[i][j].elements[SHORT_NAME_LABEL];
//				label.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						TeamPO t = TeamListPO.findTeamByShortName(shortNameLabel.getText());
//						if(t == null) return;
//						new TeamDetailFrame(t).setVisible(true);
//					}
//				});
//			}
//		}
	}
	private void addMatchLink() {
//		TableList[][] t = tableBeShowing.body;
//		for(int i = 0; i < t.length; i ++) {
//			for(int j = 0; j < t[0].length; j ++) {
//				if(t[i][j].elements.length == 0) return;
//			    TableList panel = t[i][j];
//			    final Season season;
//			    final String date, team;
//			    String s = panel.elements[0].getText();
//			    switch(s) {
//			    case "2012-2013赛季" : season = Season.season12_13; break;
//			    case "2013-2014赛季" : season = Season.season13_14; break;
//			    case "2014-2015赛季" : season = Season.season14_15; break;
//			    default: season = Season.season12_13;
//			    }
//			    date = panel.elements[1].getText();
//			    team = panel.elements[2].getText() + "-" + panel.elements[5].getText();
//			    
//				panel.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						MatchInfoDetailFrame f = new MatchInfoDetailFrame(MainFrame.mainFrame.bl.findMatch(season, date, team));
//					    f.setVisible(true);
//					}
//				});
//			}
//		}
	}

	private void addDailyPlayerLink() {
//		TableList[] t = tableBeShowing.body[0];
//		for(int i = 0; i < t.length; i ++) {
//			final int j = i;
//			t[j].addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent e) {
//					new PlayerDetailFrame(PlayerListPO.findPlayerAccurately(tableBeShowing.body[0][j].elements[0].getText()));
//				}
//			});
//		}
	}
	private void addSeasonPlayerLink() {
		addDailyPlayerLink();
	}
	private void addImprovePlayerLink() {
		addDailyPlayerLink();
	}
	private void addSeasonTeamLink() {
//		TableList[] t = tableBeShowing.body[0];
//		for(int i = 0; i < t.length; i ++) {
//			final int j = i;
//			t[j].addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent e) {
//					new TeamDetailFrame(TeamListPO.findTeamByFullName(tableBeShowing.body[0][j].elements[0].getText()));
//				}
//			});
//		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
	}



	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_CLICKED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_CLICKED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_CLICKED);
		}if(e.getSource()==hot){
			hot.setIcon(Config.TAB_HOT_CLICKED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_CLICKED);
		}
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_UNPRESSED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_UNPRESSED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_UNPRESSED);
		}if(e.getSource()==hot){
			hot.setIcon(Config.TAB_HOT_UNPRESSED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_UNPRESSED);
		}
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_ENTERED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_ENTERED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_ENTERED);
		}if(e.getSource()==hot){
			hot.setIcon(Config.TAB_HOT_ENTERED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_ENTERED);
		}
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==player){
			player.setIcon(Config.TAB_PLAYER_UNPRESSED);
		}if(e.getSource()==team){
			team.setIcon(Config.TAB_TEAM_UNPRESSED);
		}if(e.getSource()==match){
			match.setIcon(Config.TAB_MATCH_UNPRESSED);
		}if(e.getSource()==hot){
			hot.setIcon(Config.TAB_HOT_UNPRESSED);
		}if(e.getSource()==aboutus){
			aboutus.setIcon(Config.TAB_ABOUT_UNPRESSED);
		}
		
	}
	
	public void setTable(Object[][] body) {
		int y = Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE + Config.SELECTION_HEIGHT;
		TableFactory.createTable(dataTable, dataTableSP,
				MainFrame.mainFrame,
				body,
				Config.UI_WIDTH, Config.UI_HEIGHT - y,
				0, y);
	}
}
