package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.PlayerData;
import Enum.Zone;
import PO.PlayerPO;

import com.kmno4.common.Config;

public class SelectionPanel extends JPanel implements MouseListener{
	public  List<JLabel> avg_sort_list;
	private TextField tf_search;
	boolean isPickup=true;
	boolean isAvg=true;
	//方位
	public int location_x;
	public int location_y;
	
	JLabel title = new JLabel("球员");
	JLabel lb_search = new JLabel("搜索");
	
	JLabel lb_percent=new JLabel("标准");
	JLabel lb_efficiency=new JLabel("类型");	
	JLabel lb_location = new JLabel("位置");
	JLabel lb_place = new JLabel("分区");

	JComboBox cb_position = new JComboBox(Config.PICKUP_POSITION);
	JComboBox cb_district = new JComboBox(Config.PICKUP_DISTRICT);
	JComboBox cb_type = new JComboBox(Config.PICKUP_TYPE);
	JComboBox cb_standard=new JComboBox(Config.PICKUP_STANDARD);
	private final JLabel submit = new JLabel("提交");
	
	JLabel pickup = new JLabel("筛选");
	
	JLabel sort = new JLabel("排序");
	JLabel avg_sort=new JLabel("场均数据");
	JLabel total_sort=new JLabel("总数据");
	JComboBox cb_avg_sort_data=new JComboBox(Config.PLAYER_AVERAGE_INFO);
	JComboBox cb_total_sort_data=new JComboBox(Config.PLAYER_TOTAL_INFO);


	/**
	 * Create the panel.
	 */
	public SelectionPanel() {
		

		this.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		this.setBackground(Color.GRAY);
		setLayout(null);
		
		
		cb_position.addMouseListener(this);
		cb_district.addMouseListener(this);
		cb_type.addMouseListener(this);
		cb_standard.addMouseListener(this);

		//第一行
		lb_search.setBounds(606, 11, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_search);
		
		tf_search = new TextField();
//		tf_search.setText("输入关键字");
		tf_search.setBounds(650, 11,Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_SEARCH_HEIGHT);
		tf_search.setBackground(Color.GRAY);
		add(tf_search);
		
		title.setBounds(15, 11, 30, 30);
		add(title);
		

		lb_location.setBounds(13, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_location);
					
		cb_position.setBounds(59, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_position.setBackground(Color.GRAY);
		add(cb_position);
		
		
		lb_place.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH-Config.COMB_TEXT_GAP, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_place);
		
		cb_district.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_TEAM_WIDTH);
		cb_district.setBackground(Color.GRAY);
		add(cb_district);
		
		lb_percent.setBounds(15, 53, 35, 16);		
		add(lb_percent);
		
		cb_type.setBounds(59, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_type.setBackground(Color.gray);
		add(cb_type);
		
		lb_efficiency.setForeground(Color.WHITE);
		lb_efficiency.setBounds(560, 53, 35, 16);
		add(lb_efficiency);
		
		cb_standard.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_standard.setBackground(Color.GRAY);
		add(cb_standard);
		
		
		//
		pickup.setBounds(69, 18, 35, 16);
		add(pickup);
		pickup.addMouseListener(this);
		
		sort.setBounds(119, 18, 35, 16);
		add(sort);
		sort.addMouseListener(this);
		submit.setBounds(169, 18, 35, 16);
		add(submit);
		submit.addMouseListener(this);

		avg_sort.setBounds(15, 45, Config.SORT_WIDTH*2, Config.SORT_HEIGHT);
		total_sort.setBounds(200, 45, Config.SORT_WIDTH*2, Config.SORT_HEIGHT);
		cb_avg_sort_data.setBounds(15, 70, Config.SORT_WIDTH*4, Config.SORT_HEIGHT);
		cb_total_sort_data.setBounds(15, 70, Config.SORT_WIDTH*4, Config.SORT_HEIGHT);
		add(avg_sort);
		add(total_sort);
		add(cb_avg_sort_data);
		add(cb_total_sort_data);
		avg_sort.setVisible(false);
		total_sort.setVisible(false);
		cb_avg_sort_data.setVisible(false);
		cb_total_sort_data.setVisible(false);

	}
	
	//画背景
	public void paintComponent(Graphics g)
	      {
				super.paintComponent(g);
				g.drawImage(Config.PLAYER_SELECTION_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.SELECTION_HEIGHT,this);
	      }
	
	public void moveIn(){
		
	}
	
	public void moveOut(){
		
	}
	
	public void showPickup(){
		lb_percent.setVisible(true);
		lb_efficiency.setVisible(true);	
		lb_location.setVisible(true);
		lb_place.setVisible(true);
		cb_position.setVisible(true);
		cb_district.setVisible(true);
<<<<<<< HEAD
		cb_standard.setVisible(true);
		cb_type.setVisible(true);		
=======
		cb_type.setVisible(true);
		cb_standard.setVisible(true);		
		
>>>>>>> origin/master
		avg_sort.setVisible(false);
		total_sort.setVisible(false);
		cb_avg_sort_data.setVisible(false);	
		cb_total_sort_data.setVisible(false);
	}
			
	public void showSortAvg(){
		lb_percent.setVisible(false);
		lb_efficiency.setVisible(false);	
		lb_location.setVisible(false);
		lb_place.setVisible(false);
		cb_position.setVisible(false);
		cb_district.setVisible(false);
<<<<<<< HEAD
		cb_standard.setVisible(false);
		cb_type.setVisible(false);			
=======
		cb_type.setVisible(false);
		cb_standard.setVisible(false);			
		
>>>>>>> origin/master
		avg_sort.setVisible(true);
		total_sort.setVisible(true);
		cb_avg_sort_data.setVisible(true);	
		cb_total_sort_data.setVisible(false);
	}
	
	
	public void showSortTotal(){
		cb_avg_sort_data.setVisible(false);
		cb_total_sort_data.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==pickup){
			showPickup();
			isPickup=true;
		}if(e.getSource()==sort){
			showSortAvg();
			isPickup=false;
		}
		
		if(e.getSource()==avg_sort){
			showSortAvg();
			isAvg=true;
		}
		
		if(e.getSource()==total_sort){
			showSortTotal();
			isAvg=false;
		}
			
		if(e.getSource()==submit){
			if(isPickup){
				String position=cb_position.getSelectedItem().toString();
				String district=cb_district.getSelectedItem().toString();
				String type=cb_type.getSelectedItem().toString();
				String standard=cb_standard.getSelectedItem().toString();		
				System.out.println(standard+" "+type);
				PlayerData dataType = null;
				Zone zone=null;
				if(district.equals("E")){
					zone=Zone.E;
					district=null;
				}if(district.equals("W")){
					zone=Zone.W;
					district=null;
				}				
				if(standard.equals("场均")){
					standard="avg";
<<<<<<< HEAD
				}if(standard.equals("总计")){
=======
				}else if(type.equals("总计")){
>>>>>>> origin/master
					standard="total";
				}
				
				switch(type){
				case "得分":
					dataType=PlayerData.score;
					break;
				case "篮板":
					dataType=PlayerData.numberOfRebound;
					break;
				case "助攻":
					dataType=PlayerData.numberOfAssist;
					break;
				case "得分/篮板/助攻":
					dataType=PlayerData.comprehension;
					break;
				case "盖帽":
					dataType=PlayerData.numberOfBlock;
					break;
				case "抢断":
					dataType=PlayerData.numberOfSteal;
					break;
				case "犯规":
					dataType=PlayerData.numberOfFoul;
					break;
				case "失误":
					dataType=PlayerData.numberOfFault;
					break;
				case "分钟":
					dataType=PlayerData.presentTime;
					break;
				case "效率":
					dataType=PlayerData.efficiency;
					break;
				case "投篮":
					dataType=PlayerData.numberOfShooting;
					break;
				case "三分":
					dataType=PlayerData.numberOf3_Point;
					break;
				case "罚球":
					dataType=PlayerData.numberOfFreeThrow;
					break;
				case "两双":
					dataType = PlayerData.double_double;
					break;
				}
				System.out.println(dataType.toString());
				//position为英文，三种单字母
				ArrayList<PlayerPO> players=MainFrame.mainFrame.bl.pickUpPlayersByCondition(position, zone, district, standard, dataType);
				if(players!=null){
					MainFrame.mainFrame.topTabPanel.refreshPlayerTable(players);
					}
			}else{
				//此处是筛选
				if(isAvg){
					
				}
			}

		}
						
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

