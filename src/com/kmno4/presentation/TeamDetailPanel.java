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
import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LMouseAdapter;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;
import com.kmno4.presentation2.TeamDataAnalysisFrame;

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
		seasonLabel.setFont(new Font("default", 2, 16));
		seasonLabel.setBackground(new Color(20, 79, 139, 150));
		seasonLabel.setForeground(Color.white);
		seasonLabel.setBounds(
				PADDING, mainDataPanel.getY() + mainDataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, SEASON_LABEL_HEIGHT);
		add(seasonLabel);
		
		avgLabel = new JLabel("赛季场均", JLabel.LEFT);
		avgLabel.setOpaque(true);
		avgLabel.setFont(new Font("default", 2, 12));
		avgLabel.setBackground(new Color(128, 128, 128, 150));
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
		seasonAvgData.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		
		sumLabel = new JLabel("赛季总计", JLabel.LEFT);
		sumLabel.setOpaque(true);
		sumLabel.setFont(new Font("default", 2, 12));
		sumLabel.setBackground(new Color(128, 128, 128, 150));
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
		seasonSumData.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		
		recentLabel= new JLabel("最近五场比赛", JLabel.LEFT);
		recentLabel.setFont(new Font("default", 2, 16));
		recentLabel.setBackground(new Color(20, 79, 139, 150));
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
		recentData.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		addLinks();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Config.DETAIL_BG.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	private void addLinks() {
		recentData.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = recentData.table.rowAtPoint(e.getPoint());
				if(row == 0) return;
				MatchPO m = MainFrame.mainFrame.bl.findMatch(
						TableContentTransfer.getSeasonByString(recentData.table.getValueAt(row, 0).toString()),
						recentData.table.getValueAt(row, 1).toString(),
						recentData.table.getValueAt(row, 2).toString().replace('@', '-'));
				new MatchInfoDetailFrame(m);
			}
		});
	}
	
	private static final String TEAM_DETAIL_TOP_BG = "images/player_detail_bg.png";
	class MainDataPanel extends JPanel {
		public JLabel bgLabel;
		public JLabel logoLabel;
		public JLabel info1, info2, info3, info4, info5, info6, info7;
		
		
		public MainDataPanel(TeamPO teamPO) {
			setLayout(null);
			
			logoLabel = new JLabel();
			logoLabel.setBounds(20, 0, 230, 230);
			PlayerDetailPanel.fillLabel(teamPO.getTeamLogoURL(), logoLabel, logoLabel.getWidth(), logoLabel.getHeight());
			add(logoLabel);
			
			int delta = 50;
			info1 = new JLabel("名称/缩写 : " + teamPO.getFullName() + "/" + teamPO.getShortName());
			info1.setBounds(300, 20, 300, 50);
			info1.setFont(new Font("default", 2, 20));
			info1.setForeground(Color.white);
			add(info1);
			info2 = new JLabel("所在地 : " + teamPO.getCity());
			info2.setBounds(300, info1.getY() + delta, 300, 50);
			info2.setFont(new Font("default", 2, 20));
			info2.setForeground(Color.white);
			add(info2);
			info3 = new JLabel("赛区 : " + teamPO.getZone().toString());
			info3.setBounds(300, info2.getY() + delta, 300, 50);
			info3.setFont(new Font("default", 2, 20));
			info3.setForeground(Color.white);
			add(info3);
			info4 = new JLabel("分区 : " + teamPO.getDistrict());
			info4.setBounds(600, 20, 300, 50);
			info4.setFont(new Font("default", 2, 20));
			info4.setForeground(Color.white);
			add(info4);
			info5 = new JLabel("主场 : " + teamPO.getHomeCourt());
			info5.setBounds(600, info4.getY() + delta, 300, 50);
			info5.setFont(new Font("default", 2, 20));
			info5.setForeground(Color.white);
			add(info5);
			info6 = new JLabel("建立时间 : " + teamPO.getTimeOfEstablishment());
			info6.setBounds(600, info5.getY() + delta, 300, 50);
			info6.setFont(new Font("default", 2, 20));
			info6.setForeground(Color.white);
			add(info6);
			
			info7 = new JLabel("点此查看更详细信息");
			info7.setBounds(600, info6.getY() + 3 * delta / 2, 200, 30);
			info7.setFont(new Font("default", 2, 20));
			info7.setForeground(Color.white);
			info7.addMouseListener(new LMouseAdapter(teamDetailFrame) {
				public void mouseClicked(MouseEvent e) {
					new TeamDataAnalysisFrame(teamPO, teamDetailFrame.getLocation());
					teamDetailFrame.setVisible(false);
					teamDetailFrame.dispose();
				}
			});
			add(info7);

//			bgLabel = new JLabel();
//			PlayerDetailPanel.fillLabel(TEAM_DETAIL_TOP_BG, bgLabel, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
//			bgLabel.setBounds(0, 0, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
//			add(bgLabel);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(Config.NULL.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		}
	}
}
