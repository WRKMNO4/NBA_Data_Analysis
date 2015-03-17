package com.kmno4.presentation;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.Table;

public class TopTabPanel extends JPanel {
	
	public List<JLabel> tabs;
	
	private JLabel player;
	private JLabel match;
	private JLabel team;
	private JLabel help;
	private JLabel aboutus;
	
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
				showPlayerTable();
				MainFrame.mainFrame.repaint();
			}
		});
		team.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTeamTable();
				MainFrame.mainFrame.repaint();
			}
		});
		match.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMatchTable();
				MainFrame.mainFrame.repaint();
			}
		});
		
		showPlayerTable();
	}
	
	
	private void showPlayerTable() {
		if(tableBeShowing == null) { //第一次创建table
			tableBeShowing = new Table(
					new String[]{"a", "b", "c", "d"}, 
					new String[][]{
							{"player", "bb", "cc", "dd"},
							{"player", "bb", "cc", "dd"}
					});
			setTableBounds();
			MainFrame.mainFrame.add(tableBeShowing);
			return;
		}
		tableBeShowing.setVisible(false);
		MainFrame.mainFrame.remove(tableBeShowing);
		tableBeShowing = new Table(
				new String[]{"a", "b", "c", "d"}, 
				new String[][]{
						{"player", "bb", "cc", "dd"},
						{"player", "bb", "cc", "dd"}
				});
		setTableBounds();
		MainFrame.mainFrame.add(tableBeShowing);
		
	}
	private void showTeamTable() {
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
	private void showMatchTable() {
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
		tableBeShowing.setBounds(0, 285, 500, 280);
	}
	
	
	
	
	
	
}
