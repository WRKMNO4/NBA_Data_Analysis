package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessLogic.SortHelper.TransferSortHelper;
import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LMouseAdapter;
import com.kmno4.presentation.calendarPanel.CalendarPanel;

@SuppressWarnings("serial")
public class HotSelectionPanel extends JPanel implements ActionListener{
	JPanel playerPanel;
	public CalendarPanel calendarPanel;
	JLabel
	    lb_daily_player,
	    lb_season_player,
	    lb_improve_player,
	    lb_season_team
	    ;
	JComboBox<String>
	    daily_player_season,
	    daily_player_datatype,
	    season_hot_player_season,
	    season_hot_player_datetype,
	    season_hot_team_season,
	    season_hot_team_datatype,
	    most_improve_season,
	    most_improve_datatype;
	JLabel
		lb_date;
//		JTextField tf_date;
	JLabel
		btn_submit;
	boolean isDailyPlayer=false,isSeasonPlayer=false,isImprovePlayer=false,isSeasonTeam=false;
	

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
		lb_daily_player = new JLabel("当日热点球员",JLabel.CENTER);
		lb_daily_player.setForeground(Color.white);
		playerPanel.add(lb_daily_player);
		lb_season_player = new JLabel("赛季热点球员",JLabel.CENTER);
		lb_season_player.setForeground(Color.white);
		playerPanel.add(lb_season_player);
		lb_improve_player = new JLabel("进步最快球员",JLabel.CENTER);
		lb_improve_player.setForeground(Color.white);
		playerPanel.add(lb_improve_player);
		lb_season_team = new JLabel("赛季热点球队",JLabel.CENTER);
		lb_season_team.setForeground(Color.white);
		playerPanel.add(lb_season_team);
		add(playerPanel);	
		
		initDailyPlayer();
		initMostProvementPlayer();
		initSeasonHotTeam();
		initSeasonMostPlayer();
		//
		calendarPanel=new CalendarPanel(lb_date,"yyyy-MM-dd");
		calendarPanel.initCalendarPanel();
		MainFrame.mainFrame.add(calendarPanel);
		showDailyPlayer();
		
		lb_daily_player.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDailyPlayer();
			}
		});
		lb_season_player.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showSeasonPlayer();
			}
		});
		lb_improve_player.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMostProvementPlayer();
			}
		});
		lb_season_team.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showSeasonTeam();
			}
		});

//		tf_date.addActionListener(this);
		lb_date.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Season season=TransferSortHelper.StringToSeason(daily_player_season.getSelectedItem().toString());
				PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(daily_player_datatype.getSelectedItem().toString());
//				String date=lb_date.getText();	
				String date=lb_date.getText();
				MainFrame.mainFrame.topTabPanel.refreshDailyPlayerTable(season, date, type);
			}
		});
		
		btn_submit.addMouseListener(new LMouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isDailyPlayer){
					Season season=TransferSortHelper.StringToSeason(daily_player_season.getSelectedItem().toString());
					PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(daily_player_datatype.getSelectedItem().toString());
//					String date=lb_date.getText();	
					String date=lb_date.getText();
					MainFrame.mainFrame.topTabPanel.refreshDailyPlayerTable(season, date, type);
					MainFrame.mainFrame.topTabPanel.refreshDailyPlayerTable(season, date, type);
				}
				if(isSeasonPlayer){
					Season season=TransferSortHelper.StringToSeason(season_hot_player_season.getSelectedItem().toString());
					PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(season_hot_player_datetype.getSelectedItem().toString());
					MainFrame.mainFrame.topTabPanel.refreshSeasonPlayerTable(season,type);
					MainFrame.mainFrame.topTabPanel.refreshSeasonPlayerTable(season,type);
				}
				if(isSeasonTeam){
					Season season=TransferSortHelper.StringToSeason(season_hot_team_season.getSelectedItem().toString());
					TeamData type=TransferSortHelper.StringToDataTypeForTeam(season_hot_team_datatype.getSelectedItem().toString());
					MainFrame.mainFrame.topTabPanel.refreshSeasonTeamTable(season, type);
					MainFrame.mainFrame.topTabPanel.refreshSeasonTeamTable(season, type);

				}
				if(isImprovePlayer){
					Season season=TransferSortHelper.StringToSeason(most_improve_season.getSelectedItem().toString());
					PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(most_improve_datatype.getSelectedItem().toString());
					MainFrame.mainFrame.topTabPanel.refreshImprovePlayerTable(season,type);
					MainFrame.mainFrame.topTabPanel.refreshImprovePlayerTable(season,type);

				}
			}
		});
		daily_player_season.addActionListener(this);
	    daily_player_datatype.addActionListener(this);
	    season_hot_player_season.addActionListener(this);
	    season_hot_player_datetype.addActionListener(this);
	    season_hot_team_season.addActionListener(this);
	    season_hot_team_datatype.addActionListener(this);
	    most_improve_season.addActionListener(this);
	    most_improve_datatype.addActionListener(this);
	}
	
	public void initDailyPlayer(){
		//当日热点球员组件
				daily_player_season = new JComboBox<String>(Config.Seasons);
				daily_player_season.setBounds(45, 73, 168, 27);
				daily_player_season.setFont(new Font("default", Font.PLAIN, 14));
				add(daily_player_season);
				
				daily_player_datatype = new JComboBox<String>(Config.STANDING_DAILYPLAYER_TYPE);
				daily_player_datatype.setBounds(250, 73, 168, 27);
				daily_player_datatype.setFont(new Font("default", Font.PLAIN, 14));
				add(daily_player_datatype);
				
				//设置为当前日期
				Date dt=new Date();//
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String content=df.format(dt);
				lb_date = new JLabel(content+"  ▼");
//				lb_date.setIcon(Config.LABEL_CALENDAR_BACKGROUND);
				lb_date.setForeground(Color.white);
				lb_date.setFont(new Font("default", Font.ITALIC, 20));
				lb_date.setBounds(500, 73, 168, 27);
				add(lb_date);
				
				btn_submit=new JLabel("提交");
				btn_submit.setForeground(Color.WHITE);
				btn_submit.setFont(new Font("default", Font.ITALIC, 20));
				btn_submit.setBounds(700, 73, 50, 27);
				add(btn_submit);
				
				
//				tf_date = new JTextField();
//				tf_date.setText(df.format(dt));
//				tf_date.setBounds(658, 71, 134, 28);
//				add(tf_date);
	}
	
	public void initSeasonMostPlayer(){
		season_hot_player_season = new JComboBox<String>(Config.Seasons);
		season_hot_player_season.setBounds(45, 73, 168, 27);
		season_hot_player_season.setFont(new Font("default", Font.PLAIN, 14));
		add(season_hot_player_season);
		
		season_hot_player_datetype = new JComboBox<String>(Config.STANDING_SEASONPLAYER_TYPE);
		season_hot_player_datetype.setBounds(250, 73, 168, 27);
		season_hot_player_datetype.setFont(new Font("default", Font.PLAIN, 14));
		add(season_hot_player_datetype);
	}
	
	public void initSeasonHotTeam(){
		season_hot_team_season = new JComboBox<String>(Config.Seasons);
		season_hot_team_season.setBounds(45, 73, 168, 27);
		season_hot_team_season.setFont(new Font("default", Font.PLAIN, 14));
		season_hot_team_season.setSelectedIndex(1);
		add(season_hot_team_season);
		
		season_hot_team_datatype = new JComboBox<String>(Config.STANDING_SEASONTEAM_TYPE);
		season_hot_team_datatype.setBounds(250, 73, 168, 27);
		season_hot_team_datatype.setFont(new Font("default", Font.PLAIN, 14));
		add(season_hot_team_datatype);
	}
	
	public void initMostProvementPlayer(){
		most_improve_season = new JComboBox<String>(Config.Seasons);
		most_improve_season.setBounds(45, 73, 168, 27);
		most_improve_season.setFont(new Font("default", Font.PLAIN, 14));
		add(most_improve_season);
		
		most_improve_datatype = new JComboBox<String>(Config.STANDING_IMPROVED_TYPE);
		most_improve_datatype.setBounds(250, 73, 168, 27);
		most_improve_datatype.setFont(new Font("default", Font.PLAIN, 14));
		add(most_improve_datatype);
	}
	
	
	public void showSeasonPlayer(){
		isDailyPlayer=false;isSeasonPlayer=true;isImprovePlayer=false;isSeasonTeam=false;
	    lb_date.setVisible(false);
	    daily_player_season.setVisible(false);
	    daily_player_datatype.setVisible(false);
	    season_hot_player_season.setVisible(true);
	    season_hot_player_datetype.setVisible(true);
	    season_hot_team_season.setVisible(false);
	    season_hot_team_datatype.setVisible(false);
	    most_improve_season.setVisible(false);
	    most_improve_datatype.setVisible(false);	
//	    tf_date.setVisible(false);
	    
	    calendarPanel.setVisible(false);
//	    btn_submit.setVisible(false);
	}
	
	public void showSeasonTeam(){
		isDailyPlayer=false;isSeasonPlayer=false;isImprovePlayer=false;isSeasonTeam=true;
		 	lb_date.setVisible(false);
		    daily_player_season.setVisible(false);
		    daily_player_datatype.setVisible(false);
		    season_hot_player_season.setVisible(false);
		    season_hot_player_datetype.setVisible(false);
		    season_hot_team_season.setVisible(true);
		    season_hot_team_datatype.setVisible(true);
		    most_improve_season.setVisible(false);
		    most_improve_datatype.setVisible(false);	
//		    tf_date.setVisible(false);
		    
		    calendarPanel.setVisible(false);
//		    btn_submit.setVisible(false);

	}
	
	public void showDailyPlayer(){
		isDailyPlayer=true;isSeasonPlayer=false;isImprovePlayer=false;isSeasonTeam=false;
		 	lb_date.setVisible(true);
		    daily_player_season.setVisible(true);
		    daily_player_datatype.setVisible(true);
		    season_hot_player_season.setVisible(false);
		    season_hot_player_datetype.setVisible(false);
		    season_hot_team_season.setVisible(false);
		    season_hot_team_datatype.setVisible(false);
		    most_improve_season.setVisible(false);
		    most_improve_datatype.setVisible(false);	
//		    tf_date.setVisible(true);
		    
		    calendarPanel.setVisible(false);
//		    btn_submit.setVisible(true);
	}
	
	public void showMostProvementPlayer(){
		isDailyPlayer=false;isSeasonPlayer=false;isImprovePlayer=true;isSeasonTeam=false;
			lb_date.setVisible(false);
		    daily_player_season.setVisible(false);
		    daily_player_datatype.setVisible(false);
		    season_hot_player_season.setVisible(false);
		    season_hot_player_datetype.setVisible(false);
		    season_hot_team_season.setVisible(false);
		    season_hot_team_datatype.setVisible(false);
		    most_improve_season.setVisible(true);
		    most_improve_datatype.setVisible(true);	
//		    tf_date.setVisible(false);
		    
		    calendarPanel.setVisible(false);
//		    btn_submit.setVisible(false);
	}

	public void paintComponent(Graphics g){
		
		g.drawImage(Config.HOT_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO 未刷新表格
		if(e.getSource()==daily_player_season||e.getSource()==daily_player_datatype){
			Season season=TransferSortHelper.StringToSeason(daily_player_season.getSelectedItem().toString());
			PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(daily_player_datatype.getSelectedItem().toString());
//			String date=lb_date.getText();	
			String date=lb_date.getText();
			MainFrame.mainFrame.topTabPanel.refreshDailyPlayerTable(season, date, type);
			MainFrame.mainFrame.topTabPanel.refreshDailyPlayerTable(season, date, type);
		}
		if(e.getSource()==season_hot_player_season||e.getSource()==season_hot_player_datetype){
			Season season=TransferSortHelper.StringToSeason(season_hot_player_season.getSelectedItem().toString());
			PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(season_hot_player_datetype.getSelectedItem().toString());
			MainFrame.mainFrame.topTabPanel.refreshSeasonPlayerTable(season,type);
			MainFrame.mainFrame.topTabPanel.refreshSeasonPlayerTable(season,type);

		}
		if(e.getSource()==season_hot_team_season||e.getSource()==season_hot_team_datatype){
			Season season=TransferSortHelper.StringToSeason(season_hot_team_season.getSelectedItem().toString());
			TeamData type=TransferSortHelper.StringToDataTypeForTeam(season_hot_team_datatype.getSelectedItem().toString());
			MainFrame.mainFrame.topTabPanel.refreshSeasonTeamTable(season, type);
			MainFrame.mainFrame.topTabPanel.refreshSeasonTeamTable(season, type);

		}
		if(e.getSource()==most_improve_season||e.getSource()==most_improve_datatype){
			Season season=TransferSortHelper.StringToSeason(most_improve_season.getSelectedItem().toString());
			PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(most_improve_datatype.getSelectedItem().toString());
			MainFrame.mainFrame.topTabPanel.refreshImprovePlayerTable(season,type);
			MainFrame.mainFrame.topTabPanel.refreshImprovePlayerTable(season,type);

		}		
////		if(e.getSource()==this){
////			calendarPanel.setVisible(false);
////		}	
	}

}
