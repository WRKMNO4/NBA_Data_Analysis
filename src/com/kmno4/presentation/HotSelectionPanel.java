package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class HotSelectionPanel extends JPanel implements MouseListener{
	
	JComboBox team_a;
	JComboBox team_b;
	/**
	 * Create the panel.
	 */
	public HotSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		JLabel lb_data_player = new JLabel("当日热点球员");
		lb_data_player.setBounds(0, 0, 200, 30);
		add(lb_data_player);
		JLabel lb_season_player = new JLabel("赛季热点球员");
		lb_season_player.setBounds(200, 0, 200, 30);
		add(lb_season_player);
		JLabel lb_improve_player = new JLabel("进步最快球员");
		lb_improve_player.setBounds(400, 0, 200, 30);
		add(lb_improve_player);
		JLabel lb_season_team = new JLabel("赛季热点球队");
		lb_season_team.setBounds(600, 0, 200, 30);
		add(lb_season_team);
		
		team_a = new JComboBox();
		team_a.setBounds(27, 58, 168, 27);
		add(team_a);
		
		team_b = new JComboBox();
		team_b.setBounds(259, 58, 168, 27);
		add(team_b);
		
		JLabel lb_date = new JLabel("日历");
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
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
