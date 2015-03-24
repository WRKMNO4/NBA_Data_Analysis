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
	public  List<JLabel> sort_list;
	private TextField tf_search;
	boolean isPickup=true;
	boolean isAvg=true;
	//方位
	public int location_x;
	public int location_y;
	
	JLabel title = new JLabel("球员");
	JLabel lb_search = new JLabel("搜索");
	
	JLabel lblA = new JLabel("得分");
	JLabel lblB = new JLabel("篮板");
	JLabel lblC = new JLabel("助攻");
	JLabel lblD = new JLabel("得分/篮板/助攻");
	JLabel lblE = new JLabel("盖帽");
	JLabel lblF = new JLabel("抢断");
	JLabel lblG = new JLabel("犯规");
	JLabel lblH = new JLabel("失误");
	JLabel lblI = new JLabel("分钟");
	JLabel lblJ = new JLabel("效率");
	JLabel lblK = new JLabel("投篮");
	JLabel lblL = new JLabel("三分");
	JLabel lblM = new JLabel("罚球");
	JLabel lblN = new JLabel("两双");
	JLabel lblO = new JLabel("O");
	JLabel lblP = new JLabel("P");
	JLabel lblQ = new JLabel("Q");
	JLabel lblR = new JLabel("R");
	JLabel lblS = new JLabel("S");
	JLabel lblT = new JLabel("T");
	JLabel lblU = new JLabel("U");
	JLabel lblV = new JLabel("V");
	JLabel lblW = new JLabel("W");
	JLabel lblX = new JLabel("X");
	JLabel lblY = new JLabel("Y");
	JLabel lblZ = new JLabel("Z");
	
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


	/**
	 * Create the panel.
	 */
	public SelectionPanel() {
		

		this.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		this.setBackground(Color.GRAY);
		setLayout(null);
		
		sort_list=new ArrayList<JLabel>();
		sort_list.add(lblA);
		sort_list.add(lblB);
		sort_list.add(lblC);
		sort_list.add(lblD);
		sort_list.add(lblE);
		sort_list.add(lblF);
		sort_list.add(lblG);
		sort_list.add(lblH);
		sort_list.add(lblI);
		sort_list.add(lblJ);
		sort_list.add(lblK);
		sort_list.add(lblL);
		sort_list.add(lblM);
		sort_list.add(lblN);
		sort_list.add(lblO);
		sort_list.add(lblP);
		sort_list.add(lblQ);
		sort_list.add(lblR);
		sort_list.add(lblS);
		sort_list.add(lblT);
		sort_list.add(lblU);
		sort_list.add(lblV);
		sort_list.add(lblW);
		sort_list.add(lblX);
		sort_list.add(lblY);
		sort_list.add(lblZ);

		for(int i=0;i<sort_list.size();i++){
			if(i<14){
				if(i==3){
					//有点长的
					sort_list.get(i).setBounds(15+i*Config.SORT_WIDTH, 45, Config.SORT_WIDTH*4, Config.SORT_HEIGHT);
				}else{
					sort_list.get(i).setBounds(15+i*Config.SORT_WIDTH, 45, Config.SORT_WIDTH, Config.SORT_HEIGHT);
					if(i>3){
						sort_list.get(i).setBounds(15+(i+2)*Config.SORT_WIDTH, 45, Config.SORT_WIDTH, Config.SORT_HEIGHT);
					}
				}
			}else{
				sort_list.get(i).setBounds(15+i*Config.SORT_WIDTH,20+70, Config.SORT_WIDTH, Config.SORT_HEIGHT);
			}
			sort_list.get(i).setBackground(Color.GRAY);
			sort_list.get(i).setForeground(Color.WHITE);
			add(sort_list.get(i));
			sort_list.get(i).setVisible(false);
		}
		
		
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
			for(int i=0;i<sort_list.size();i++){
				sort_list.get(i).setVisible(false);
			}	
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
			for(int i=0;i<sort_list.size();i++){
				this.add(sort_list.get(i));
				sort_list.get(i).setVisible(true);
			}
			isPickup=false;
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
				
				switch(type){
				case "得分":
					dataType=PlayerData.score;
					break;
				case "篮板";
					break;
				case "助攻";
					break;
				case "得分/篮板/助攻";
					break;
				case "盖帽";
					break;
				case "抢断";
					break;
				case "犯规";
					break;
				case "失误";
					break;
				case "分钟";
					break;
				case "效率";
					break;
				case "投篮";
					break;
				case "三分";
					break;
				case "罚球";
					break;
				case "两双";
					break;
				}
				//position为英文，三种单字母
				ArrayList<PlayerPO> players=MainFrame.mainFrame.bl.pickUpPlayersByCondition(position, zone, district, standard, dataType);
				if(players!=null){
					MainFrame.mainFrame.topTabPanel.refreshPlayerTable(players);
					}
			}

		}
		
		//TODO 排序
		if(isAvg){
			for(int i=0;i<sort_list.size();i++){
				if(e.getSource()==sort_list.get(i)){
					
				}
			}
		}else{
			for(int i=0;i<sort_list.size();i++){
				if(e.getSource()==sort_list.get(i)){
					
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
