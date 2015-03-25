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
	
//	JLabel lblA = new JLabel("篮板数");
//	JLabel lblB = new JLabel("助攻数");
//	JLabel lblC = new JLabel("在场时间");
//	JLabel lblD = new JLabel("投篮命中率");
//	JLabel lblE = new JLabel("三分命中率");
//	JLabel lblF = new JLabel("罚球命中率");
//	JLabel lblG = new JLabel("进攻数");
//	JLabel lblH = new JLabel("防守数");
//	JLabel lblI = new JLabel("抢断数");
//	JLabel lblJ = new JLabel("盖帽数");
//	JLabel lblK = new JLabel("失误数");
//	JLabel lblL = new JLabel("犯规数");
//	JLabel lblM = new JLabel("得分");
//	JLabel lblN = new JLabel("效率");
//	JLabel lblO = new JLabel("GmSc效率值");
//	JLabel lblP = new JLabel("真实命中率");
//	JLabel lblQ = new JLabel("投篮效率");
//	JLabel lblR = new JLabel("篮板率");
//	JLabel lblS = new JLabel("进攻篮板率");
//	JLabel lblT = new JLabel("防守篮板率");
//	JLabel lblU = new JLabel("助攻率");
//	JLabel lblV = new JLabel("抢断率");
//	JLabel lblW = new JLabel("盖帽率");
//	JLabel lblX = new JLabel("失误率");
//	JLabel lblY = new JLabel("Y使用率");
//	JLabel lblZ = new JLabel("Z");
	
	JLabel lb_percent=new JLabel("标准");
	JLabel lb_efficiency=new JLabel("类型");	
	JLabel lb_location = new JLabel("位置");
	JLabel lb_place = new JLabel("分区");

	JComboBox cb_position = new JComboBox(Config.PICKUP_POSITION);
	JComboBox cb_district = new JComboBox(Config.PICKUP_DISTRICT);
	JComboBox cb_standard = new JComboBox(Config.PICKUP_TYPE);
	JComboBox cb_type=new JComboBox(Config.PICKUP_STANDARD);
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
		
//		avg_sort_list=new ArrayList<JLabel>();
//		avg_sort_list.add(lblA);
//		avg_sort_list.add(lblB);
//		avg_sort_list.add(lblC);
//		avg_sort_list.add(lblD);
//		avg_sort_list.add(lblE);
//		avg_sort_list.add(lblF);
//		avg_sort_list.add(lblG);
//		avg_sort_list.add(lblH);
//		avg_sort_list.add(lblI);
//		avg_sort_list.add(lblJ);
//		avg_sort_list.add(lblK);
//		avg_sort_list.add(lblL);
//		avg_sort_list.add(lblM);
//		avg_sort_list.add(lblN);
//		avg_sort_list.add(lblO);
//		avg_sort_list.add(lblP);
//		avg_sort_list.add(lblQ);
//		avg_sort_list.add(lblR);
//		avg_sort_list.add(lblS);
//		avg_sort_list.add(lblT);
//		avg_sort_list.add(lblU);
//		avg_sort_list.add(lblV);
//		avg_sort_list.add(lblW);
//		avg_sort_list.add(lblX);
//		avg_sort_list.add(lblY);
//		avg_sort_list.add(lblZ);

//		for(int i=0;i<avg_sort_list.size();i++){
//			if(i<14){
//					//有点长的
//					avg_sort_list.get(i).setBounds(15+i*Config.SORT_WIDTH, 45, Config.SORT_WIDTH, Config.SORT_HEIGHT);
//
//			}else{
//				avg_sort_list.get(i).setBounds(15+(i-14)*Config.SORT_WIDTH,20+70, Config.SORT_WIDTH, Config.SORT_HEIGHT);
//			}
//			avg_sort_list.get(i).setBackground(Color.GRAY);
//			avg_sort_list.get(i).setForeground(Color.WHITE);
//			add(avg_sort_list.get(i));
//			avg_sort_list.get(i).setVisible(false);
//		}
		
		cb_position.addMouseListener(this);
		cb_district.addMouseListener(this);
		cb_standard.addMouseListener(this);
		cb_type.addMouseListener(this);

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
		
		cb_standard.setBounds(59, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_standard.setBackground(Color.gray);
		add(cb_standard);
		
		lb_efficiency.setForeground(Color.WHITE);
		lb_efficiency.setBounds(560, 53, 35, 16);
		add(lb_efficiency);
		
		cb_type.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_type.setBackground(Color.GRAY);
		add(cb_type);
		
		
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
		cb_standard.setVisible(true);
		cb_type.setVisible(true);
		
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
		cb_standard.setVisible(false);
		cb_type.setVisible(false);			
		avg_sort.setVisible(true);
		total_sort.setVisible(true);
		cb_avg_sort_data.setVisible(true);	
	}
	
	
	public void showSortTotal(){
		cb_avg_sort_data.setVisible(false);
		cb_total_sort_data.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==pickup){
			lb_percent.setVisible(true);
			lb_efficiency.setVisible(true);	
			lb_location.setVisible(true);
			lb_place.setVisible(true);
			cb_position.setVisible(true);
			cb_district.setVisible(true);
			cb_standard.setVisible(true);
			cb_type.setVisible(true);
//			for(int i=0;i<avg_sort_list.size();i++){
//				avg_sort_list.get(i).setVisible(false);
//			}	
			isPickup=true;
		}if(e.getSource()==sort){
			lb_percent.setVisible(false);
			lb_efficiency.setVisible(false);	
			lb_location.setVisible(false);
			lb_place.setVisible(false);
			cb_position.setVisible(false);
			cb_district.setVisible(false);
			cb_standard.setVisible(false);
			cb_type.setVisible(false);			
//			for(int i=0;i<avg_sort_list.size();i++){
//				this.add(avg_sort_list.get(i));
//				avg_sort_list.get(i).setVisible(true);
//			}
			avg_sort.setVisible(true);
			total_sort.setVisible(true);
			cb_avg_sort_data.setVisible(true);
			
			isPickup=false;
		}
		
		if(e.getSource()==avg_sort){
			cb_avg_sort_data=new JComboBox(Config.PLAYER_AVERAGE_INFO);
			cb_avg_sort_data.setVisible(true);
		}
		
		if(e.getSource()==total_sort){
			cb_avg_sort_data=new JComboBox(Config.PLAYER_TOTAL_INFO);
			cb_avg_sort_data.setVisible(true);
		}
			
		if(e.getSource()==submit){
			if(isPickup){
				String position=cb_position.getSelectedItem().toString();
				String district=cb_district.getSelectedItem().toString();
				String standard=cb_standard.getSelectedItem().toString();
				String type=cb_type.getSelectedItem().toString();			
				PlayerData dataType;
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
				}if(standard.equals("总计")){
					standard="total";
				}
				
//				switch(type){
//				case "得分":
//					dataType=PlayerData.score;
//					break;
//				case "篮板";
//					break;
//				case "助攻";
//					break;
//				case "得分/篮板/助攻";
//					break;
//				case "盖帽";
//					break;
//				case "抢断";
//					break;
//				case "犯规";
//					break;
//				case "失误";
//					break;
//				case "分钟";
//					break;
//				case "效率";
//					break;
//				case "投篮";
//					break;
//				case "三分";
//					break;
//				case "罚球";
//					break;
//				case "两双";
//					break;
//				}
				//position为英文，三种单字母
//				ArrayList<PlayerPO> players=MainFrame.mainFrame.bl.pickUpPlayersByCondition(position, zone, district, standard, dataType);
//				if(players!=null){
//					MainFrame.mainFrame.topTabPanel.refreshPlayerTable(players);
//					}
			}

		}
		
		//TODO 排序
		//如果是筛选
		if(isPickup){			
			
		}
		//如果是排序
		else{
			
		}
		
		if(isAvg){

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
