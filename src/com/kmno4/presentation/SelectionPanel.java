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
	JComboBox cb_location = new JComboBox();
	JLabel lb_team = new JLabel("分区");
	JComboBox cb_team = new JComboBox();
	private final JLabel label = new JLabel("比率");



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
//		sort=new ArrayList<JLabel>();
//		sort.add(lblA);
//		sort.add(lblB);
//		sort.add(lblC);
//		sort.add(lblD);
//		sort.add(lblE);
//		sort.add(lblF);
//		sort.add(lblG);
//		sort.add(lblH);
//		sort.add(lblI);
//		sort.add(lblJ);
//		sort.add(lblK);
//		sort.add(lblL);
//		sort.add(lblM);
//		sort.add(lblN);
//		sort.add(lblO);
//		sort.add(lblP);
//		sort.add(lblQ);
//		sort.add(lblR);
//		sort.add(lblS);
//		sort.add(lblT);
//		sort.add(lblU);
//		sort.add(lblV);
//		sort.add(lblW);
//		sort.add(lblX);
//		sort.add(lblY);
//		sort.add(lblZ);

//		for(int i=0;i<14;i++){
//			if(i==3){
//				//有点长的
//				sort.get(i).setBounds(15+i*Config.SORT_WIDTH, 45, Config.SORT_WIDTH*4, Config.SORT_HEIGHT);
//			}else{
//				sort.get(i).setBounds(15+i*Config.SORT_WIDTH, 45, Config.SORT_WIDTH, Config.SORT_HEIGHT);
//				if(i>3){
//					sort.get(i).setBounds(15+(i+2)*Config.SORT_WIDTH, 45, Config.SORT_WIDTH, Config.SORT_HEIGHT);
//				}
//			}
//			sort.get(i).setBackground(Color.GRAY);
//			add(sort.get(i));
//			
//			//设置监听
//			sort.get(i).addMouseListener(this);
//		}
		
		
		//第三行
		lb_location.setBounds(13, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_location);
		
		
//		String a="a";
//		String b="b";
//		String c="c";
//		final List<String> list=new ArrayList<String>();
//		list.add(a);
//		list.add(b);
//		list.add(c);
//		
//		final JLabel label=new JLabel("<位置>");
//		label.setBounds(59, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
//		label.addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				Combox com=new Combox(list,label.getX(), label.getY()+15, label);
//				com.setVisible(true);
//				
//			}
//		});
//		add(label);
				
		
		cb_location.setBounds(59, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		add(cb_location);
		
		
		lb_team.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH-Config.COMB_TEXT_GAP, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_team);
		
		cb_team.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_TEAM_WIDTH);
		add(cb_team);
		label.setBounds(15, 53, 35, 16);
		
		add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(59, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		comboBox.setBackground(Color.gray);
		add(comboBox);
		
		lb_efficiency.setForeground(Color.WHITE);
		lb_efficiency.setBounds(560, 53, 35, 16);
		add(lb_efficiency);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(21*Config.SORT_WIDTH-Config.SELECTION_COMB_TEAM_WIDTH, 49, Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_CITY_WIDTH);
		add(comboBox_1);


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
