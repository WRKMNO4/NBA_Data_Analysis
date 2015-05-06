package com.kmno4.presentation;


import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
import com.kmno4.presentation.button.LMouseAdapter;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;
import com.oracle.jrockit.jfr.DataType;

@SuppressWarnings("serial")
public class TopTabPanel extends JPanel implements MouseListener{
	
	public List<JLabel> tabs;
	
	private JLabel player;
	private JLabel match;
	private JLabel team;
	private JLabel hot;
	private JLabel aboutus;
	private JLabel close;
	private JLabel foreGround;
	private JLabel line;
	public boolean isPlayer,isMatch,isHot,isTeam,isAboutus,isPlayerClicked,isMatchClicked,isHotClicked,isTeamClicked;
	
	private final int line_speed=200;
	private int line_x,line_y;
	
	public TableGroup tg;
	private TableModel dataTableModel;
	private TableCellRenderer tcr;

	/**
	 * Create the panel.
	 */
	public TopTabPanel() {
		
		this.setBounds(0, 0, Config.UI_WIDTH, Config.TOP_TAB_HEIGHT);
		this.setBackground(Color.GRAY);
		setLayout(null);
		tg = new TableGroup();
		
		isPlayer=false;
		isMatch=isHot=isTeam=isAboutus=false;
		isPlayerClicked=isMatchClicked=isHotClicked=isTeamClicked=false;
		
		close = new ExitLabel(MainFrame.mainFrame);
		add(close);
		
		line=new JLabel();
		line.setIcon(Config.TOP_LINE);
		line.setSize(Config.TOP_TAB_LABLE_WIDTH, 1);
		add(line);
		
		
		foreGround=new JLabel();
		foreGround.setIcon(Config.LABEL_FOREGROUND);
		foreGround.setForeground(Color.white);
		foreGround.setSize(Config.TOP_TAB_LABLE_WIDTH, Config.TOP_TAB_LABLE_HEIGHT);
		add(foreGround);
		
		player = new JLabel("球员",JLabel.CENTER);
		player.addMouseListener(this);	
//		player.setIcon(Config.TAB_PLAYER_UNPRESSED);
		team = new JLabel("球队",JLabel.CENTER);
		team.addMouseListener(this);
//		team.setIcon(Config.TAB_TEAM_UNPRESSED);
		match = new JLabel("比赛",JLabel.CENTER);
		match.addMouseListener(this);
//		match.setIcon(Config.TAB_MATCH_UNPRESSED);
		hot = new JLabel("热点",JLabel.CENTER);
		hot.addMouseListener(this);
//		hot.setIcon(Config.TAB_HOT_UNPRESSED);
		aboutus = new JLabel("关于",JLabel.CENTER);
		aboutus.addMouseListener(this);
//		aboutus.setIcon(Config.TAB_ABOUT_UNPRESSED);

		tabs=new ArrayList<JLabel>();
		
		tabs.add(hot);
		tabs.add(player);
		tabs.add(team);
		tabs.add(match);
		tabs.add(aboutus);
		
		for(int i=0;i<tabs.size();i++){
			tabs.get(i).setBounds(Config.UI_WIDTH-(tabs.size()-i)*Config.TOP_TAB_LABLE_WIDTH-50, 
					Config.TOP_TAB_HEIGHT-Config.TOP_TAB_LABLE_HEIGHT-5, 
					Config.TOP_TAB_LABLE_WIDTH,
					Config.TOP_TAB_LABLE_HEIGHT);
			tabs.get(i).setForeground(Color.WHITE);
			tabs.get(i).setFont(new Font("default", Font.PLAIN, 25));
			this.add(tabs.get(i));
		}
		//初始化线条位置
		line_x=tabs.get(0).getX();
		line_y=Config.TOP_TAB_HEIGHT-47;
		line.setLocation(line_x,line_y);
		
		player.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPlayerInfo();
			}

		});
		team.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTeamInfo();
			}
		});
		match.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMatchInfo();
			}
		});
		
		hot.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showHotInfo();
			}
		});
		
		aboutus.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAboutUsInfo();
			}
		});
		
		LineThread lineThread=new LineThread();
		lineThread.start();
	}
	
	public void labelClicked(JLabel l){

		foreGround.setLocation(l.getX(), l.getY());
	}
	
	
	/**
	 * 在所有panel初始化之后的初始化
	 */
	public void ini() { showHotInfo(); }
	
	public void showPlayerInfo(){
		isPlayerClicked=true;
		isMatchClicked=isHotClicked=isTeamClicked=false;
		
		labelClicked(player);
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
		isTeamClicked=true;
		isPlayerClicked=isMatchClicked=isHotClicked=false;
		
		labelClicked(team);
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
		isMatchClicked=true;
		isPlayerClicked=isHotClicked=isTeamClicked=false;
		
		labelClicked(match);
		//显示matchPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
		MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.matchSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.hotSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		
		MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.比赛信息.toString());
		
		refreshMatchTable(MainFrame.mainFrame.bl.getAllMatches(MainFrame.mainFrame.matchSelectionPanel.current_season));
		MainFrame.mainFrame.repaint();
	}
	
	
	public void showHotInfo(){
		isHotClicked=true;
		isPlayerClicked=isMatchClicked=isTeamClicked=false;
		
		labelClicked(hot);
		MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.matchSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		MainFrame.mainFrame.hotSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		
		MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.热点信息.toString());
		
		refreshDailyPlayerTable(PlayerData.numberOfMatchs);
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
//		System.out.println("TopTabPanel.refreshPlayerTable()");
		hidTable();
		if(players == null || players.size() == 0) return;
		setTable(TableContentTransfer.transferPlayerSortAvgInfo((ArrayList<PlayerPO>)players));
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				PlayerPO p;
				Object o = table.getValueAt(row, column);
				if(o != null && (p = PlayerListPO.findPlayerAccurately(o.toString())) != null) {
					PlayerDetailPanel.fillLabel(p.getPortraitURL(), this, TABLE_UNIT_HEIGHT, TABLE_UNIT_HEIGHT * 185 / 230);
				}
				else setIcon(null);
				setOpaque(true);
				if(row == 0) setBackground(new Color(0, 0, 0, 170)); 
				else if(row % 2 != 0) setBackground(new Color(0, 0, 0, 110)); 
				else setBackground(new Color(0, 0, 0, 0)); 
				
				
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
			
		};
		dtcr.setOpaque(false);
		tg.table.setDefaultRenderer(Object.class, dtcr);
		tg.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		
		addPlayerLink();
		MainFrame.mainFrame.repaint();
	}
	/**
	 * 刷新team列表
	 * @param teams
	 */
	public void refreshTeamTable(ArrayList<TeamPO> teams) {
		hidTable();
		if(teams == null || teams.size() == 0) return;
		setTable(TableContentTransfer.transferTeamBasicInfo(teams),
				TABLE_UNIT_HEIGHT, TABLE_UNIT_HEIGHT, 140);
		tg.jsp.setHorizontalScrollBar(null);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				TeamPO t;
				Object o = table.getValueAt(row, column);
				if(o != null && (t = TeamListPO.findTeamByFullName(o.toString())) != null)
					PlayerDetailPanel.fillLabel(t.getTeamLogoURL(), this, TABLE_UNIT_HEIGHT, TABLE_UNIT_HEIGHT);
				else setIcon(null);
				setOpaque(true);
				if(row == 0) setBackground(new Color(0, 0, 0, 170)); 
				else if(row % 2 != 0) setBackground(new Color(0, 0, 0, 110)); 
				else setBackground(new Color(0, 0, 0, 0)); 
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
			
		};
		dtcr.setOpaque(false);
		tg.table.setDefaultRenderer(Object.class, dtcr);
		tg.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		
		addTeamLink();
		MainFrame.mainFrame.repaint();
	}
	/**
	 * 刷新match列表
	 */
	public void refreshMatchTable(ArrayList<MatchPO> matches) {
		hidTable();
		if(matches == null || matches.size() == 0) return;
		setTable(TableContentTransfer.transferMatchBasicInfo(matches),
				(int)(TABLE_UNIT_HEIGHT * 1.5), TABLE_UNIT_HEIGHT, 200);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				TeamPO t;
				Object o = table.getValueAt(row, column);
				if(o != null && (t = TeamListPO.findTeamByShortName(o.toString())) != null)
					PlayerDetailPanel.fillLabel(t.getTeamLogoURL(), this, (int)(TABLE_UNIT_HEIGHT * 1.5), (int)(TABLE_UNIT_HEIGHT * 1.5));
				else {
					setIcon(null);
					setHorizontalAlignment(JLabel.CENTER);
				}
				setOpaque(true);
				if(row == 0) setBackground(new Color(0, 0, 0, 170)); 
				else if(row % 2 != 0) setBackground(new Color(0, 0, 0, 110)); 
				else setBackground(new Color(0, 0, 0, 0)); 
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
			
		};
		dtcr.setOpaque(false);
		tg.table.setDefaultRenderer(Object.class, dtcr);
		MainFrame.mainFrame.remove(tg.jsp);
		MainFrame.mainFrame.add(tg.jsp, MainFrame.mainFrame.getComponentCount());
		addMatchLink();
		MainFrame.mainFrame.repaint();
	}
	
	/**
	 * 热点的几个表格都应用的样式
	 * @author hutao
	 *
	 */
	class HotTableCellRender extends DefaultTableCellRenderer {
		boolean isPlayer;
		public HotTableCellRender(boolean isPlayer) { 
			this.isPlayer = isPlayer;
			setOpaque(false);
		}
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Object o;
			if(isPlayer) {
				PlayerPO p;
				o = table.getValueAt(row, column);
				if(o != null && (p = PlayerListPO.findPlayerAccurately(o.toString())) != null)
					PlayerDetailPanel.fillLabel(p.getPortraitURL(), this, HOT_UNIT_HEIGHT * 230 / 185, HOT_UNIT_HEIGHT);
				else setIcon(null);
			}
			else {
				TeamPO t;
				o = table.getValueAt(row, column);
				if(o != null && (t = TeamListPO.findTeamByFullName(o.toString())) != null)
					PlayerDetailPanel.fillLabel(t.getTeamLogoURL(), this, (int)(TABLE_UNIT_HEIGHT * 1.5), (int)(TABLE_UNIT_HEIGHT * 1.5));
				else setIcon(null);
			}
			
			setOpaque(true);
			if(row == 0) setBackground(new Color(0, 0, 0, 170)); 
			else if(row % 2 != 0) setBackground(new Color(0, 0, 0, 110)); 
			else setBackground(new Color(0, 0, 0, 0)); 
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}
	private static final int HOT_UNIT_HEIGHT = (Config.UI_HEIGHT - Config.TOP_TAB_HEIGHT - Config.INTRODUCTION_WHITE - Config.SELECTION_HEIGHT) / 6 - 1;
	private static final int HOT_UNIT_WIDTH = Config.UI_WIDTH / 4;
	
	public void refreshDailyPlayerTable(PlayerData dataType) {
		hidTable();
		if(dataType == null) return; 
		ArrayList<StandingDataPO> sps = MainFrame.mainFrame.bl.getDatasOfDailyStandingPlayer(dataType,5);
		if(sps == null || sps.size() == 0) return;
		setTable(TableContentTransfer.transferStandingDailyPlayerInfo(sps),
				HOT_UNIT_HEIGHT, HOT_UNIT_HEIGHT, HOT_UNIT_WIDTH);
		tg.table.setDefaultRenderer(Object.class, new HotTableCellRender(true));
		MainFrame.mainFrame.remove(tg.jsp);
		MainFrame.mainFrame.add(tg.jsp, MainFrame.mainFrame.getComponentCount());
		addDailyPlayerLink();
		MainFrame.mainFrame.repaint();
	}
	public void refreshSeasonPlayerTable(Season season, PlayerData dataType) {
//		System.out.println("TopTabPanel.refreshSeasonPlayerTable()");
		hidTable();
		if(season == null || dataType == null) return;
		setTable(TableContentTransfer.transferStandingSeasonPlayerInfo(MainFrame.mainFrame.bl.getSeasonStandingPlayer(season, dataType), season, dataType),
				HOT_UNIT_HEIGHT, HOT_UNIT_HEIGHT, HOT_UNIT_WIDTH);
		tg.table.setDefaultRenderer(Object.class, new HotTableCellRender(true));
		
		addSeasonPlayerLink();
		MainFrame.mainFrame.repaint();
	}
	public void refreshImprovePlayerTable(Season season, PlayerData dataType) {
//		System.out.println("TopTabPanel.refreshImprovePlayerTable()");
		hidTable();
		if(season == null || dataType == null) return;
		setTable(TableContentTransfer.transferStandingImprovedInfo(MainFrame.mainFrame.bl.getMostImprovePlayer(season, dataType), season, dataType),
				HOT_UNIT_HEIGHT, HOT_UNIT_HEIGHT, HOT_UNIT_WIDTH);
		tg.table.setDefaultRenderer(Object.class, new HotTableCellRender(true));
		
		addImprovePlayerLink();
		MainFrame.mainFrame.repaint();
	}
	public void refreshSeasonTeamTable(Season season, TeamData dataType) {
//		System.out.println("TopTabPanel.refreshSeasonTeamTable()");
		hidTable();
		if(season == null || dataType == null) return;
		setTable(TableContentTransfer.transferStandingSeasonTeamInfo(MainFrame.mainFrame.bl.getSeasonStandingTeam(season, dataType), season, dataType),
				HOT_UNIT_HEIGHT, HOT_UNIT_HEIGHT, HOT_UNIT_WIDTH);
		tg.table.setDefaultRenderer(Object.class, new HotTableCellRender(false));
		
		addSeasonTeamLink();
		MainFrame.mainFrame.repaint();
	}
	
	private void hidTable() {
		if(tg.table != null) tg.table.setVisible(false);
		if(tg.jsp != null) {
			tg.jsp.setVisible(false);
			MainFrame.mainFrame.remove(tg.jsp);
		}
	}
	
	private void addPlayerLink() {
		tg.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int 
				    row = tg.table.rowAtPoint(e.getPoint()),
					col = tg.table.columnAtPoint(e.getPoint());
				if(row == 0 || col != 0) return;
				PlayerPO p = PlayerListPO.findPlayerAccurately(tg.table.getValueAt(row, col).toString());
				new PlayerDetailFrame(p);
			}
		});
	}
	
	private void addTeamLink() {
		tg.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int 
				    row = tg.table.rowAtPoint(e.getPoint()),
					col = tg.table.columnAtPoint(e.getPoint());
				if(row == 0 || ( col != 0 && col != 1)) return;
				String name = tg.table.getValueAt(row, col).toString();
				TeamPO p = col == 0 ? TeamListPO.findTeamByFullName(name) : TeamListPO.findTeamByShortName(name);
				new TeamDetailFrame(p);
			}
		});
	}
	private void addMatchLink() {
		tg.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int 
				    row = tg.table.rowAtPoint(e.getPoint());
				if(row == 0) return;
				MatchPO m = MainFrame.mainFrame.bl.findMatch(
						MainFrame.mainFrame.matchSelectionPanel.current_season,
						tg.table.getValueAt(row, 0).toString(),
						tg.table.getValueAt(row, 1) + "-" + tg.table.getValueAt(row, 4));
				new MatchInfoDetailFrame(m);
			}
		});
	}

	private void addDailyPlayerLink() {
		tg.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tg.table.rowAtPoint(e.getPoint());
				if(row == 0) return;
				PlayerPO p = PlayerListPO.findPlayerAccurately(tg.table.getValueAt(row, 0).toString());	
				new PlayerDetailFrame(p);
			}
		});
	}
	private void addSeasonPlayerLink() {
		addDailyPlayerLink();
	}
	private void addImprovePlayerLink() {
		addDailyPlayerLink();
	}
	private void addSeasonTeamLink() {
		tg.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tg.table.rowAtPoint(e.getPoint());
				if(row == 0) return;
				TeamPO t = TeamListPO.findTeamByFullName(tg.table.getValueAt(row, 0).toString());
				new TeamDetailFrame(t);
			}
		});
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
	}



	@Override
	public void mousePressed(MouseEvent e) {

	}



	@Override
	public void mouseReleased(MouseEvent e) {

		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==player){
			isPlayer=true;
			isTeam=false;
			isMatch=false;
			isHot=false;
			isAboutus=false;
		}else if(e.getSource()==team){
			isPlayer=false;
			isTeam=true;
			isMatch=false;
			isHot=false;
			isAboutus=false;
		}else if(e.getSource()==match){
			isPlayer=false;
			isTeam=false;
			isMatch=true;
			isHot=false;
			isAboutus=false;
		}else if(e.getSource()==hot){
			isPlayer=false;
			isTeam=false;
			isMatch=false;
			isHot=true;
			isAboutus=false;
		}else if(e.getSource()==aboutus){
			isPlayer=false;
			isTeam=false;
			isMatch=false;
			isHot=false;
			isAboutus=true;
		}
	}



	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getY()>30||e.getY()<0){
			if(e.getSource()==player){
				isPlayer=false;
			}else if(e.getSource()==team){
				isTeam=false;
			}else if(e.getSource()==match){
				isMatch=false;
			}else if(e.getSource()==hot){
				isHot=false;
			}else if(e.getSource()==aboutus){
				isAboutus=false;
			}
		}
		
	}
	
	private static final int TABLE_UNIT_HEIGHT = 60;
	public void setTable(Object[][] body) {
		int y = Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE + Config.SELECTION_HEIGHT;
		TableFactory.createTable(tg,
				MainFrame.mainFrame,
				body,
				Config.UI_WIDTH, Config.UI_HEIGHT - y,
				0, y,
				TABLE_UNIT_HEIGHT, TABLE_UNIT_HEIGHT, 0);
		tg.table.setForeground(Color.white);
	}
	public void setTable(Object[][] body,
			int rowHeight, int headRowHeight, int UnitWidth) {
		int y = Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE + Config.SELECTION_HEIGHT;
		TableFactory.createTable(tg,
				MainFrame.mainFrame,
				body,
				Config.UI_WIDTH, Config.UI_HEIGHT - y,
				0, y,
				rowHeight, headRowHeight, UnitWidth);
		tg.table.setForeground(Color.white);
	}
	
	class LineThread extends Thread{
		@Override
		public void run() {
			while(true){
				if(isPlayer){
					moveLine(player.getX());
				}else if(isTeam){
					moveLine(team.getX());
				}else if(isMatch){
					moveLine(match.getX());
				}else if(isHot){
					moveLine(hot.getX());
				}else if(isAboutus){
					moveLine(aboutus.getX());
				}if(!isPlayer&&!isTeam&&!isMatch&&!isHot&&!isAboutus){
					if(isPlayerClicked){
						moveLine(player.getX());
					}else if(isTeamClicked){
						moveLine(team.getX());
					}else if(isHotClicked){
						moveLine(hot.getX());
					}else if(isMatchClicked){
						moveLine(match.getX());
					}
				}
			}
		}
		
		public void moveLine(int target_x){
			int a=400;//加速度
			int v=200;//速度，单位px/s			
			if(line_x>target_x){
				while(true){
					line_x-=10;
					line.setLocation(line_x, Config.TOP_TAB_HEIGHT-47);
					repaint();
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(line_x<=target_x){
						break;
					}
				}
			}if(line_x<target_x){
				while(true){
					line_x+=10;
					line.setLocation(line_x, Config.TOP_TAB_HEIGHT-47);
					repaint();
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(line_x>=target_x){
						break;
					}
				}
			}
		}
	} 
}
