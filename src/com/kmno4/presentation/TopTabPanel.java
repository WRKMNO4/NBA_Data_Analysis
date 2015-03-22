package com.kmno4.presentation;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.PlayerListPO;
import PO.PlayerPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;
import com.kmno4.presentation.table.Table;
import com.kmno4.presentation.table.TableList;

@SuppressWarnings("serial")
public class TopTabPanel extends JPanel {
	
	public List<JLabel> tabs;
	
	private JLabel player;
	private JLabel match;
	private JLabel team;
	private JLabel help;
	private JLabel aboutus;
	private JLabel close;
	

	/**
	 * 用于引用当前显示的表格
	 */
	private Table tableBeShowing;


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
		team = new JLabel("球队");
		match = new JLabel("比赛");
		help = new JLabel("帮助");
		aboutus = new JLabel("关于");

		tabs=new ArrayList<JLabel>();
		
		tabs.add(player);
		tabs.add(team);
		tabs.add(match);
		tabs.add(help);
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
				//显示playerPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
				MainFrame.mainFrame.playerSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
						Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.Player.toString());
				
				createAndShowPlayerTable();
				MainFrame.mainFrame.repaint();
			}
		});
		team.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//显示teamPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
				MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
						Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.teamSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.Team.toString());
				
				createAndShowTeamTable();
				MainFrame.mainFrame.repaint();
			}
		});
		match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//显示matchPanel，移开其他panel,所有PANEL统一隐藏在Frame左边
				MainFrame.mainFrame.playerSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
						Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.teamSelectionPanel.setBounds(0-Config.UI_WIDTH, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				MainFrame.mainFrame.pageInfoPanel.refreshInfo(Pages.Match.toString());
				
				createAndShowMatchTable();
				MainFrame.mainFrame.repaint();
			}
		});
		
		createAndShowPlayerTable();
	}
	
	
	
	//画背景
	public void paintComponent(Graphics g)
	      {
				super.paintComponent(g);
				g.drawImage(Config.TOP_TAB_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.TOP_TAB_HEIGHT,this);
	      }
	
	/**
	 * 第l列为进入具体信息Frame的链接
	 */
	private static final int l = 0;
	private void createAndShowPlayerTable() {
		if(tableBeShowing == null) { //第一次创建table
			tableBeShowing = new Table(
				Config.PLAYER_BASIC_INFO,
					TableContentTransfer.transferPlayerBasicInfo( Config.PLAYER_BASIC_INFO.length,MainFrame.mainFrame.players));
			setTableBounds();
			MainFrame.mainFrame.add(tableBeShowing);
			addPlayerLink();
			return;
		}
		tableBeShowing.setVisible(false);
		MainFrame.mainFrame.remove(tableBeShowing);
		tableBeShowing = new Table(
				Config.PLAYER_BASIC_INFO,
				TableContentTransfer.transferPlayerBasicInfo(Config.PLAYER_BASIC_INFO.length, MainFrame.mainFrame.players));
		setTableBounds();
		MainFrame.mainFrame.add(tableBeShowing);
		addPlayerLink();
	}
	private void createAndShowTeamTable() {
		tableBeShowing.setVisible(false);
		MainFrame.mainFrame.remove(tableBeShowing);
		tableBeShowing = new Table(
				new String[]{"a", "b", "c", "d"}, 
				new String[][]{
						{"team", "bb", "cc", "dd"},
						{"team", "bb", "cc", "dd"}
				});
		setTableBounds();
		MainFrame.mainFrame.add(tableBeShowing);
	}
	private void createAndShowMatchTable() {
		tableBeShowing.setVisible(false);
		MainFrame.mainFrame.remove(tableBeShowing);
		tableBeShowing = new Table(
				new String[]{"a", "b", "c", "d"}, 
				new String[][]{
						{"match", "bb", "cc", "dd"},
						{"match", "bb", "cc", "dd"}
				});
		setTableBounds();
		MainFrame.mainFrame.add(tableBeShowing);
	}
	private void setTableBounds() {
		int y = Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE + Config.SELECTION_HEIGHT + 10;
		tableBeShowing.setBounds(
				0, 
				y,
				Config.UI_WIDTH,
				Config.UI_HEIGHT - y);
	}
	
	private JLabel label;
	private void addPlayerLink() {
		TableList[][] t = tableBeShowing.body;
		for(int i = 0; i < t.length; i ++) {
			for(int j = 0; j < t[0].length; j ++) {
			    try {
			    	label = t[i][j].elements[l];
			    }
			    catch(Exception e) {//对于空条目
			    	break;
			    }
				
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						PlayerPO p = PlayerListPO.findPlayerByName(label.getText());
						//if(p == null) return;
						new PlayerDetailFrame(p).setVisible(true);
					}
				});
			}
		}
		
	}

}
