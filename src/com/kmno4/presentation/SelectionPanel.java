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
	
	JLabel lb_percent=new JLabel("比率");
	JLabel lb_efficiency=new JLabel("效率");	
	JLabel lb_location = new JLabel("位置");
	JLabel lb_place = new JLabel("分区");

	JComboBox cb_location = new JComboBox();
	JComboBox cb_palce = new JComboBox();
	JComboBox cb_percent = new JComboBox();
	JComboBox cb_effitency=new JComboBox();
	



	/**
	 * Create the panel.
	 */
	public SelectionPanel() {
		
		this.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		this.setBackground(Color.GRAY);
		setLayout(null);
		
				
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
					
		cb_location.setBounds(59, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_location.setBackground(Color.GRAY);
		add(cb_location);
		
		
		lb_place.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH-Config.COMB_TEXT_GAP, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_place);
		
		cb_palce.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_TEAM_WIDTH);
		cb_palce.setBackground(Color.GRAY);
		add(cb_palce);
		
		lb_percent.setBounds(15, 53, 35, 16);		
		add(lb_percent);
		
		cb_percent.setBounds(59, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_percent.setBackground(Color.gray);
		add(cb_percent);
		
		lb_efficiency.setForeground(Color.WHITE);
		lb_efficiency.setBounds(560, 53, 35, 16);
		add(lb_efficiency);
		
		cb_effitency.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		cb_effitency.setBackground(Color.GRAY);
		add(cb_effitency);


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
