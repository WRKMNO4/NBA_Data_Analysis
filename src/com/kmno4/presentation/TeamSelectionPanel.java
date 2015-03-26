package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.TeamPO;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class TeamSelectionPanel extends JPanel implements MouseListener{

	private boolean isAvg=true;

	private JComboBox avg_data;
	private JComboBox total_data;
	
	public JLabel total_sort;
	public JLabel avg_sort;
	
	
	public TeamSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		avg_data=new JComboBox(Config.TEAM_AVERAGE_INFO);
		total_data=new JComboBox(Config.TEAM_TOTAL_INFO);

		total_sort=new JLabel("总计");
		total_sort.setBounds(85, 11, 41, 16);
		total_sort.addMouseListener(this);
		avg_sort=new JLabel("场均");
		avg_sort.setBounds(85, 26, 41, 16);
		avg_sort.addMouseListener(this);
		add(avg_sort);
		add(total_sort);

		avg_data.setBounds(127, 11, 150, 27);
		total_data.setBounds(127, 11, 150, 27);
		add(avg_data);
		add(total_data);
		total_data.setVisible(false);
				
	}
	
	//画背景
	public void paintComponent(Graphics g)
	      {
				super.paintComponent(g);
				g.drawImage(Config.TEAM_SELECTION_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.SELECTION_HEIGHT,this);
	      }

	public void showAvg(){
		isAvg=true;
		avg_data.setVisible(true);
		total_data.setVisible(false);
	}
	
	public void showTotal(){
		isAvg=false;
		avg_data.setVisible(false);
		total_data.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==total_sort){
			showTotal();
		}if(e.getSource()==avg_sort){
			showAvg();
		}if(e.getSource()==total_data){
			//总数据
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortTeamsOf13_14ByComprehension(standard, dataType);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams);
		}if(e.getSource()==avg_data){
			//场均数据
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortPlayersByComprehension(standard, dataType);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams);
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
