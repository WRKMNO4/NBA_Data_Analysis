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
import Enum.Season;
import Enum.TeamData;
import PO.TeamPO;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class TeamSelectionPanel extends JPanel implements MouseListener,ActionListener{

	private boolean isAvg=true;

	private JComboBox<String> cb_avg_data;
	private JComboBox<String> cb_total_data;
	private JComboBox<String> cb_season;
	
	public JLabel total_sort;
	public JLabel avg_sort;
	public JLabel lb_season;
	
	
	public TeamSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		cb_avg_data=new JComboBox<String>(Config.TEAM_AVERAGE_INFO);
		cb_total_data=new JComboBox<String>(Config.TEAM_TOTAL_INFO);
		cb_season=new JComboBox<String>(Config.Seasons);
		cb_avg_data.setBounds(127, 11, 150, 27);
		cb_total_data.setBounds(127, 11, 150, 27);
		cb_season.setBounds(400,11,150,27);
		this.add(cb_avg_data);
		this.add(cb_total_data);
		this.add(cb_season);
		cb_avg_data.setVisible(true);
		cb_total_data.setVisible(false);
		cb_total_data.addActionListener(this);
		cb_avg_data.addActionListener(this);
		
		lb_season=new JLabel("赛季");
		lb_season.setBounds(300, 15, 40, 15);
		lb_season.setForeground(Color.WHITE);
		
		
		total_sort=new JLabel("总计");
		total_sort.setBounds(85, 5, 40, 15);
		total_sort.setForeground(Color.white);
		total_sort.addMouseListener(this);
		avg_sort=new JLabel("场均");
		avg_sort.setBounds(85, 25, 40, 15);
		avg_sort.addMouseListener(this);
		avg_sort.setForeground(Color.WHITE);
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
		if(e.getSource()==total_sort){
			showTotal();
		}if(e.getSource()==avg_sort){
			showAvg();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Season season=TransferSortHelper.StringToSeason(cb_season.getSelectedItem().toString());
		if(e.getSource()==cb_total_data||e.getSource()==cb_season){
			//总数据
			String data=cb_total_data.getSelectedItem().toString();
			TeamData dataType=TransferSortHelper.StringToDataTypeForTeam(data);
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortTeamsByComprehension("total", dataType,season);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams);
		}else if(e.getSource()==cb_avg_data||e.getSource()==cb_season){
			//场均数据
			String data=cb_avg_data.getSelectedItem().toString();
			TeamData dataType=TransferSortHelper.StringToDataTypeForTeam(data);
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortTeamsByComprehension("avg", dataType,season);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams);
		}
	}
}
