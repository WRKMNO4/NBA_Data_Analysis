package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessLogic.SortHelper.TransferSortHelper;
import Enum.TeamData;
import PO.TeamPO;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class TeamSelectionPanel extends JPanel implements MouseListener,ActionListener{

	private boolean isAvg=true;

	private JComboBox cb_avg_data;
	private JComboBox cb_total_data;
	
	public JLabel total_sort;
	public JLabel avg_sort;
	
	
	public TeamSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		cb_avg_data=new JComboBox(Config.TEAM_AVERAGE_INFO);
		cb_total_data=new JComboBox(Config.TEAM_TOTAL_INFO);
		cb_avg_data.setBounds(127, 11, 150, 27);
		cb_total_data.setBounds(127, 11, 150, 27);
		this.add(cb_avg_data);
		this.add(cb_total_data);
		cb_avg_data.setVisible(false);
		cb_total_data.setVisible(false);
		cb_total_data.addActionListener(this);
		cb_avg_data.addActionListener(this);
		
		total_sort=new JLabel("总计");
		total_sort.setBounds(85, 5, 40, 15);
		total_sort.addMouseListener(this);
		avg_sort=new JLabel("场均");
		avg_sort.setBounds(85, 20, 40, 15);
		avg_sort.addMouseListener(this);
		add(avg_sort);
		add(total_sort);

	}
	
	//画背景
	public void paintComponent(Graphics g)
	      {
				super.paintComponent(g);
				g.drawImage(Config.TEAM_SELECTION_BACKGROUND.getImage(), 0, 0,Config.UI_WIDTH,Config.SELECTION_HEIGHT,this);
	      }

	public void showAvg(){
		isAvg=true;
		cb_avg_data.setVisible(true);
		cb_total_data.setVisible(false);
	}
	
	public void showTotal(){
		isAvg=false;
		cb_avg_data.setVisible(false);
		cb_total_data.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==total_sort){
			showTotal();
		}if(e.getSource()==avg_sort){
			showAvg();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cb_total_data){
			//总数据
			String data=cb_total_data.getSelectedItem().toString();
			TeamData dataType=TransferSortHelper.StringToDataTypeForTeam(data);
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortTeamsOf13_14ByComprehension("total", dataType);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams);
		}if(e.getSource()==cb_avg_data){
			//场均数据
			String data=cb_avg_data.getSelectedItem().toString();
			TeamData dataType=TransferSortHelper.StringToDataTypeForTeam(data);
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortTeamsOf13_14ByComprehension("avg", dataType);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams);
		}
	}
}
