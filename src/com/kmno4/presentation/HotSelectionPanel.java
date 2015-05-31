package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
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
public class HotSelectionPanel extends JPanel implements ActionListener,MouseMotionListener,MouseListener{
//	JPanel playerPanel;
//	public CalendarPanel calendarPanel;
	JLabel
	    lb_daily_player,
	    lb_season_player,
	    lb_improve_player,
	    lb_season_team
	    ;
	JComboBox<String>
//	    daily_player_season,
	    daily_player_datatype,
	    season_hot_player_season,
	    season_hot_player_datetype,
	    season_hot_team_season,
	    season_hot_team_datatype,
	    most_improve_season,
	    most_improve_datatype;
	JLabel	
		lb_date,lb_protection;
//		JTextField tf_date;
//	JLabel
//		btn_submit;
	boolean isDailyPlayer=false,isSeasonPlayer=false,isImprovePlayer=false,isSeasonTeam=false;
	
	private JLabel foreGround;

	/**
	 * Create the panel.
	 */

	public HotSelectionPanel() {
		
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
//		playerPanel = new JPanel();
//		playerPanel.setBounds(0, 0, Config.UI_WIDTH, 45);
//		playerPanel.setBackground(new Color(0, 0, 0, 0));
//		playerPanel.setLayout(new GridLayout(1, 0));
		lb_daily_player = new JLabel("当日热点球员",JLabel.CENTER);
		lb_daily_player.setBounds(0, 0, Config.UI_WIDTH/4, 45);
		lb_daily_player.setForeground(Color.white);
		add(lb_daily_player);
		lb_season_player = new JLabel("赛季热点球员",JLabel.CENTER);
		lb_season_player.setBounds(Config.UI_WIDTH/4, 0, Config.UI_WIDTH/4, 45);
		lb_season_player.setForeground(Color.white);
		add(lb_season_player);
		lb_improve_player = new JLabel("进步最快球员",JLabel.CENTER);
		lb_improve_player.setBounds(2*Config.UI_WIDTH/4, 0, Config.UI_WIDTH/4, 45);
		lb_improve_player.setForeground(Color.white);
		add(lb_improve_player);
		lb_season_team = new JLabel("赛季热点球队",JLabel.CENTER);
		lb_season_team.setBounds(3*Config.UI_WIDTH/4, 0, Config.UI_WIDTH/4, 45);
		lb_season_team.setForeground(Color.white);
		add(lb_season_team);
//		add(playerPanel);	
		//遮罩
		lb_protection=new JLabel();
		lb_protection.setBounds(0, 0, Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		ImageIcon bg=Config.HOT_SELECTION_PROTECTION;
		bg.setImage(Config.HOT_SELECTION_PROTECTION.getImage().getScaledInstance(Config.UI_WIDTH,Config.SELECTION_HEIGHT,Image.SCALE_DEFAULT));
		lb_protection.setIcon(bg);
		lb_protection.addMouseMotionListener(this);
//		add(lb_protection);
		foreGround=new JLabel();
		foreGround.setIcon(Config.LABEL_FOREGROUND);
		foreGround.setBounds(lb_daily_player.getX(), lb_daily_player.getY(), lb_daily_player.getWidth(), lb_daily_player.getHeight());
		add(foreGround);
		
		initDailyPlayer();
		initMostProvementPlayer();
		initSeasonHotTeam();
		initSeasonMostPlayer();
		//
//		calendarPanel=new CalendarPanel(lb_date,"yyyy-MM-dd");
//		calendarPanel.initCalendarPanel();
//		MainFrame.mainFrame.add(calendarPanel);
		showDailyPlayer();
		
		lb_daily_player.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDailyPlayer();
				refreshDailyPlayer();
			}
		});
		lb_season_player.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			@Override
			public void mouseClicked(MouseEvent e) {
				showSeasonPlayer();
				refreshSeasonPlayer();
			}
		});
		lb_improve_player.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMostProvementPlayer();
				refreshImprovePlayer();
			}
		});
		lb_season_team.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			@Override
			public void mouseClicked(MouseEvent e) {
				showSeasonTeam();
				refreshSeasonTeam();
			}
			
		});


	    daily_player_datatype.addActionListener(this);
	    season_hot_player_season.addActionListener(this);
	    season_hot_player_datetype.addActionListener(this);
	    season_hot_team_season.addActionListener(this);
	    season_hot_team_datatype.addActionListener(this);
	    most_improve_season.addActionListener(this);
	    most_improve_datatype.addActionListener(this);
	    
		new refThread().start();
	}
	
	public void initDailyPlayer(){
		//当日热点球员组件
//				daily_player_season = new JComboBox<String>(Config.Seasons);
//				daily_player_season.setBounds(45, 73, 168, 27);
//				daily_player_season.setFont(new Font("default", Font.PLAIN, 14));
//				add(daily_player_season);
				
				daily_player_datatype = new JComboBox<String>(Config.STANDING_DAILYPLAYER_TYPE);
				daily_player_datatype.setBounds(45, 73, 168, 27);
				daily_player_datatype.setFont(new Font("default", Font.PLAIN, 14));
				add(daily_player_datatype);
				
				//设置为当前日期
//				Date dt=new Date();//
//				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//				String content=df.format(dt);
				lb_date = new JLabel(Config.LASTEST_DATE);
				lb_date.setForeground(Color.white);
				lb_date.setFont(new Font("default", Font.PLAIN, 20));
				lb_date.setBounds(500, 73, 168, 27);
				add(lb_date);
				
				
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
		foreGround.setBounds(lb_season_player.getX(), lb_daily_player.getY(), lb_daily_player.getWidth(), lb_daily_player.getHeight());

		isDailyPlayer=false;isSeasonPlayer=true;isImprovePlayer=false;isSeasonTeam=false;
	    lb_date.setVisible(false);
//	    daily_player_season.setVisible(false);
	    daily_player_datatype.setVisible(false);
	    season_hot_player_season.setVisible(true);
	    season_hot_player_datetype.setVisible(true);
	    season_hot_team_season.setVisible(false);
	    season_hot_team_datatype.setVisible(false);
	    most_improve_season.setVisible(false);
	    most_improve_datatype.setVisible(false);	
//	    tf_date.setVisible(false);
	    
//	    calendarPanel.setVisible(false);
//	    btn_submit.setVisible(false);
	}
	
	public void showSeasonTeam(){
		foreGround.setBounds(lb_season_team.getX(), lb_daily_player.getY(), lb_daily_player.getWidth(), lb_daily_player.getHeight());

		isDailyPlayer=false;isSeasonPlayer=false;isImprovePlayer=false;isSeasonTeam=true;
		 	lb_date.setVisible(false);
//		    daily_player_season.setVisible(false);
		    daily_player_datatype.setVisible(false);
		    season_hot_player_season.setVisible(false);
		    season_hot_player_datetype.setVisible(false);
		    season_hot_team_season.setVisible(true);
		    season_hot_team_datatype.setVisible(true);
		    most_improve_season.setVisible(false);
		    most_improve_datatype.setVisible(false);	
//		    tf_date.setVisible(false);
		    
//		    calendarPanel.setVisible(false);
//		    btn_submit.setVisible(false);

	}
	
	public void showDailyPlayer(){
		foreGround.setBounds(lb_daily_player.getX(), lb_daily_player.getY(), lb_daily_player.getWidth(), lb_daily_player.getHeight());
		
		isDailyPlayer=true;isSeasonPlayer=false;isImprovePlayer=false;isSeasonTeam=false;
		 	lb_date.setVisible(true);
//		    daily_player_season.setVisible(true);
		    daily_player_datatype.setVisible(true);
		    season_hot_player_season.setVisible(false);
		    season_hot_player_datetype.setVisible(false);
		    season_hot_team_season.setVisible(false);
		    season_hot_team_datatype.setVisible(false);
		    most_improve_season.setVisible(false);
		    most_improve_datatype.setVisible(false);	
//		    tf_date.setVisible(true);
		    
//		    calendarPanel.setVisible(false);
//		    btn_submit.setVisible(true);
	}
	
	public void showMostProvementPlayer(){
		foreGround.setBounds(lb_improve_player.getX(), lb_daily_player.getY(), lb_daily_player.getWidth(), lb_daily_player.getHeight());

		isDailyPlayer=false;isSeasonPlayer=false;isImprovePlayer=true;isSeasonTeam=false;
			lb_date.setVisible(false);
//		    daily_player_season.setVisible(false);
		    daily_player_datatype.setVisible(false);
		    season_hot_player_season.setVisible(false);
		    season_hot_player_datetype.setVisible(false);
		    season_hot_team_season.setVisible(false);
		    season_hot_team_datatype.setVisible(false);
		    most_improve_season.setVisible(true);
		    most_improve_datatype.setVisible(true);	
//		    tf_date.setVisible(false);
		    
//		    calendarPanel.setVisible(false);
//		    btn_submit.setVisible(false);
	}

	public void paintComponent(Graphics g){
		
		g.drawImage(Config.HOT_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//
		if(e.getSource()==daily_player_datatype){
			refreshDailyPlayer();
		}
		if(e.getSource()==season_hot_player_season||e.getSource()==season_hot_player_datetype){
			refreshSeasonPlayer();
		}
		if(e.getSource()==season_hot_team_season||e.getSource()==season_hot_team_datatype){
			refreshSeasonTeam();
		}
		if(e.getSource()==most_improve_season||e.getSource()==most_improve_datatype){
			refreshImprovePlayer();
		}		
////		if(e.getSource()==this){
////			calendarPanel.setVisible(false);
////		}	
	}
	
	public void refreshDailyPlayer(){
//		Season season=TransferSortHelper.StringToSeason(daily_player_season.getSelectedItem().toString());
		PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(daily_player_datatype.getSelectedItem().toString());
//		String date=lb_date.getText();	
//		String date=lb_date.getText();
		MainFrame.mainFrame.topTabPanel.refreshDailyPlayerTable( type);
//		MainFrame.mainFrame.topTabPanel.refreshDailyPlayerTable( type);
	}
	
	public void refreshSeasonPlayer(){
		Season season=TransferSortHelper.StringToSeason(season_hot_player_season.getSelectedItem().toString());
		PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(season_hot_player_datetype.getSelectedItem().toString());
		MainFrame.mainFrame.topTabPanel.refreshSeasonPlayerTable(season,type);
//		MainFrame.mainFrame.topTabPanel.refreshSeasonPlayerTable(season,type);
	}
	
	public void refreshSeasonTeam(){
		Season season=TransferSortHelper.StringToSeason(season_hot_team_season.getSelectedItem().toString());
		TeamData type=TransferSortHelper.StringToDataTypeForTeam(season_hot_team_datatype.getSelectedItem().toString());
		MainFrame.mainFrame.topTabPanel.refreshSeasonTeamTable(season, type);
//		MainFrame.mainFrame.topTabPanel.refreshSeasonTeamTable(season, type);
	}
	
	public void refreshImprovePlayer(){
		Season season=TransferSortHelper.StringToSeason(most_improve_season.getSelectedItem().toString());
		PlayerData type=TransferSortHelper.StringToDataTypeForPlayer(most_improve_datatype.getSelectedItem().toString());
		MainFrame.mainFrame.topTabPanel.refreshImprovePlayerTable(season,type);
//		MainFrame.mainFrame.topTabPanel.refreshImprovePlayerTable(season,type);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		// TODO Auto-generated method stub
//		if(e.getX()>lb_protection.getX()&&e.getY()>lb_protection.getY())
//			lb_protection.setVisible(false);
//		if(e.getYOnScreen()>this.getTopLevelAncestor().getY()&&e.getXOnScreen()>this.getX()&&e.getXOnScreen()<(this.getX()+Config.UI_WIDTH)){
//			lb_protection.setVisible(false);
//		}else{
//			lb_protection.setVisible(true);
//		}
		
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
//		if(e.getSource()==MainFrame.mainFrame.hotSelectionPanel){
//			lb_protection.setVisible(false);
//		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		if(e.getSource()==MainFrame.mainFrame.hotSelectionPanel){
//			lb_protection.setVisible(true);
//		}
	}
	
	class refThread extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					if(MainFrame.mainFrame.topTabPanel.isHotClicked){
						if(isDailyPlayer){
							refreshDailyPlayer();
						}if(isImprovePlayer){
							refreshImprovePlayer();
						}if(isSeasonPlayer){
							refreshSeasonPlayer();
						}if(isSeasonTeam){
							refreshSeasonTeam();
						}			
						lb_date.setText(Config.LASTEST_DATE);
					}
					Thread.sleep(10 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
