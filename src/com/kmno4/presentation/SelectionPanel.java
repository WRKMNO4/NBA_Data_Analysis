package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

public class SelectionPanel extends JPanel {
	public  List<JLabel> sort;
	private TextField tf_search;
	
	//方位
	public int location_x;
	public int location_y;
	
	JLabel title = new JLabel("球员");
	JLabel lb_search = new JLabel("搜索");
	
	JLabel lblA = new JLabel("A");
	JLabel lblB = new JLabel("B");
	JLabel lblC = new JLabel("C");
	JLabel lblD = new JLabel("D");
	JLabel lblE = new JLabel("E");
	JLabel lblF = new JLabel("F");
	JLabel lblG = new JLabel("G");
	JLabel lblH = new JLabel("H");
	JLabel lblI = new JLabel("I");
	JLabel lblJ = new JLabel("J");
	JLabel lblK = new JLabel("K");
	JLabel lblL = new JLabel("L");
	JLabel lblM = new JLabel("M");
	JLabel lblN = new JLabel("N");
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
	
	JLabel lb_city = new JLabel("城市");
	JComboBox cb_city = new JComboBox();
	JLabel lb_team = new JLabel("球队");
	JComboBox cb_team = new JComboBox();



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
		
		//第二行
		sort=new ArrayList<JLabel>();
		sort.add(lblA);
		sort.add(lblB);
		sort.add(lblC);
		sort.add(lblD);
		sort.add(lblE);
		sort.add(lblF);
		sort.add(lblG);
		sort.add(lblH);
		sort.add(lblI);
		sort.add(lblJ);
		sort.add(lblK);
		sort.add(lblL);
		sort.add(lblM);
		sort.add(lblN);
		sort.add(lblO);
		sort.add(lblP);
		sort.add(lblQ);
		sort.add(lblR);
		sort.add(lblS);
		sort.add(lblT);
		sort.add(lblU);
		sort.add(lblV);
		sort.add(lblW);
		sort.add(lblX);
		sort.add(lblY);
		sort.add(lblZ);

		for(int i=0;i<26;i++){
			sort.get(i).setBounds(15+i*Config.SORT_WIDTH, 45, Config.SORT_WIDTH, Config.SORT_HEIGHT);
			sort.get(i).setBackground(Color.GRAY);
			add(sort.get(i));
		}
		
		
		//第三行
		lb_city.setBounds(13, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_city);
		
		cb_city.setBounds(59, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		add(cb_city);
		
		
		lb_team.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH-Config.COMB_TEXT_GAP, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_team);
		
		cb_team.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_TEAM_WIDTH);
		add(cb_team);


	}
	
	//画背景
	public void paintComponent(Graphics g)
	      {
				super.paintComponent(g);
				g.drawImage(Config.PLAYER_SELECTION_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.SELECTION_HEIGHT ,this);
	      }
	
	public void moveIn(){
		
	}
	
	public void moveOut(){
		
	}
}
