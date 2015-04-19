package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class HotSelectionPanel extends JPanel {
	JPanel playerPanel;
	JLabel
	    lb_daily_player,
	    lb_season_player,
	    lb_improve_player,
	    lb_season_team,
	    lb_date;
	JComboBox<String>
	    team_a,
	    team_b;
	

	/**
	 * Create the panel.
	 */

	public HotSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		playerPanel = new JPanel();
		playerPanel.setBounds(0, 0, 800, 45);
		playerPanel.setBackground(new Color(0, 0, 0, 0));
		playerPanel.setLayout(new GridLayout(1, 0));
		lb_daily_player = new JLabel("当日热点球员");
		playerPanel.add(lb_daily_player);
		lb_season_player = new JLabel("赛季热点球员");
		playerPanel.add(lb_season_player);
		lb_improve_player = new JLabel("进步最快球员");
		playerPanel.add(lb_improve_player);
		lb_season_team = new JLabel("赛季热点球队");
		playerPanel.add(lb_season_team);
		add(playerPanel);
		
		lb_daily_player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDailyPlayer();
			}
		});
		lb_season_player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showSeasonPlayer();
			}
		});
		lb_improve_player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMostProvementPlayer();
			}
		});
		lb_season_team.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showSeasonTeam();
			}
		});
		

		team_a = new JComboBox<String>();
		team_a.setBounds(27, 58, 168, 27);
		add(team_a);
		
		team_b = new JComboBox<String>();
		team_b.setBounds(259, 58, 168, 27);
		add(team_b);
		
		lb_date = new JLabel("日历");
		lb_date.setBounds(600, 62, 61, 16);
		add(lb_date);

	}
	
	
	public void showSeasonPlayer(){
		
	}
	
	public void showSeasonTeam(){
		
	}
	
	public void showDailyPlayer(){
		
	}
	
	public void showMostProvementPlayer(){
		
	}

	public void paintComponent(Graphics g){
		/*
		g.drawImage(Config.MATCH_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
		*/
	}
}
