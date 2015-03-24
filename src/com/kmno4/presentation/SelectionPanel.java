package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.Zone;
import PO.PlayerPO;

import com.kmno4.common.Config;

public class SelectionPanel extends JPanel implements MouseListener{
	public  List<JLabel> sort;
	private TextField tf_search;
	
	//方位
	public int location_x;
	public int location_y;
	
	JLabel title = new JLabel("球员");
	JLabel lb_search = new JLabel("搜索");
	
//	JLabel lblA = new JLabel("得分");
//	JLabel lblB = new JLabel("篮板");
//	JLabel lblC = new JLabel("助攻");
//	JLabel lblD = new JLabel("得分/篮板/助攻");
//	JLabel lblE = new JLabel("盖帽");
//	JLabel lblF = new JLabel("抢断");
//	JLabel lblG = new JLabel("犯规");
//	JLabel lblH = new JLabel("失误");
//	JLabel lblI = new JLabel("分钟");
//	JLabel lblJ = new JLabel("效率");
//	JLabel lblK = new JLabel("投篮");
//	JLabel lblL = new JLabel("三分");
//	JLabel lblM = new JLabel("罚球");
//	JLabel lblN = new JLabel("两双");
//	JLabel lblO = new JLabel("O");
//	JLabel lblP = new JLabel("P");
//	JLabel lblQ = new JLabel("Q");
//	JLabel lblR = new JLabel("R");
//	JLabel lblS = new JLabel("S");
//	JLabel lblT = new JLabel("T");
//	JLabel lblU = new JLabel("U");
//	JLabel lblV = new JLabel("V");
//	JLabel lblW = new JLabel("W");
//	JLabel lblX = new JLabel("X");
//	JLabel lblY = new JLabel("Y");
//	JLabel lblZ = new JLabel("Z");
	
	JLabel lb_percent=new JLabel("标准");
	JLabel lb_efficiency=new JLabel("类型");	
	JLabel lb_location = new JLabel("位置");
	JLabel lb_place = new JLabel("分区");

	JComboBox cb_position = new JComboBox(Config.PICKUP_POSITION);
	JComboBox cb_district = new JComboBox(Config.PICKUP_DISTRICT);
	JComboBox cb_standard = new JComboBox(Config.PICKUP_STANDARD);
	JComboBox cb_type=new JComboBox(Config.PICKUP_TYPE);
	private final JLabel submit = new JLabel("提交");
	



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
		JLabel pickup = new JLabel("筛选");
		pickup.setBounds(69, 18, 61, 16);
		add(pickup);
		
		JLabel sort = new JLabel("排序");
		sort.setBounds(119, 18, 61, 16);
		add(sort);
		submit.setBounds(169, 18, 61, 16);
		
		add(submit);
		
		pickup.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e) {
		    	
		    }
		});
		
		sort.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent e) {
		    	
		    }
		});
		
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
		// TODO Auto-generated method stub
		if(e.getSource()==submit){
			String position=cb_position.getSelectedItem().toString();
			String district=cb_district.getSelectedItem().toString();
			String standard=cb_standard.getSelectedItem().toString();
			String type=cb_type.getSelectedItem().toString();
			
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
						
			//position为英文，三种单字母
			ArrayList<PlayerPO> players=MainFrame.mainFrame.bl.pickUpPlayersByCondition(position, zone, district, standard, dataType);
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
