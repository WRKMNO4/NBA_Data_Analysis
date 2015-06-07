package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessLogic.SortHelper.TransferSortHelper;
import Enum.Season;
import Enum.TeamData;
import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LMouseAdapter;
import com.kmno4.presentation2.AllTeamDataAnalysisFrame;

@SuppressWarnings("serial")
public class TeamSelectionPanel extends JPanel implements MouseListener,ActionListener{

	private boolean isAvg;

	private JComboBox<String> cb_avg_data;
	private JComboBox<String> cb_total_data;
	private JComboBox<String> cb_season;
	
	public JLabel total_sort;
	public JLabel avg_sort;
	public JLabel lb_season;
	
	private JLabel foreGround;
	private JLabel toAnalysis;
	
	public TeamSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		isAvg = false;
		
		cb_avg_data=new JComboBox<String>(Config.TEAM_AVERAGE_INFO_OVERALL);
		cb_total_data=new JComboBox<String>(Config.TEAM_TOTAL_INFO_OVERALL);
		cb_season=new JComboBox<String>(Config.Seasons);
		cb_avg_data.setBounds(127+20, 8, Config.COMBOBOX_WIDTH, Config.COMBOBOX_HEIGHT);
		cb_total_data.setBounds(127+20, 8, Config.COMBOBOX_WIDTH, Config.COMBOBOX_HEIGHT);
		cb_season.setBounds(400,8,150,27);
		
		cb_avg_data.setFont(new Font("default", Font.PLAIN, 14));
		cb_total_data.setFont(new Font("default", Font.PLAIN, 14));
		cb_season.setFont(new Font("default", Font.PLAIN, 14));
		this.add(cb_avg_data);
		this.add(cb_total_data);
		this.add(cb_season);
		cb_avg_data.setVisible(false);
		cb_total_data.setVisible(true);
		cb_total_data.addActionListener(this);
		cb_avg_data.addActionListener(this);
		cb_season.addActionListener(this);
		
		toAnalysis = new JLabel("点此查看全球队数据分析");
		toAnalysis.setBounds(600, 8, 200, 27);
		toAnalysis.setForeground(Color.white);
		toAnalysis.setFont(new Font("default", 2, 16));
		toAnalysis.addMouseListener(new LMouseAdapter(MainFrame.mainFrame) {
			public void mouseClicked(MouseEvent e) {
				new AllTeamDataAnalysisFrame();
			}
		});
		add(toAnalysis);
		
		lb_season=new JLabel("赛季");
		lb_season.setBounds(350, 15, 40, 15);
		lb_season.setForeground(Color.WHITE);
		add(lb_season);
		
		
		total_sort=new JLabel("总计",JLabel.CENTER);
		total_sort.setBounds(85+20, 5, 40, 15);
		total_sort.setForeground(Color.white);
		total_sort.addMouseListener(this);
		avg_sort=new JLabel("场均",JLabel.CENTER);
		avg_sort.setBounds(85+20, 23, 40, 15);
		avg_sort.addMouseListener(this);
		avg_sort.setForeground(Color.WHITE);
		add(avg_sort);
		add(total_sort);
		
		foreGround=new JLabel();
		foreGround.setIcon(Config.LABEL_FOREGROUND);
		foreGround.setBounds(total_sort.getX(), total_sort.getY(),40, 15);
		add(foreGround);

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
		foreGround.setBounds(avg_sort.getX(), avg_sort.getY(),40, 15);
	}
	
	public void showTotal(){
		isAvg=false;
		cb_avg_data.setVisible(false);
		cb_total_data.setVisible(true);
		foreGround.setBounds(total_sort.getX(), total_sort.getY(),40, 15);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==total_sort){
			showTotal();
		}else if(e.getSource()==avg_sort){
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
		LMouseAdapter.enter(e);
		MainFrame.mainFrame.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		LMouseAdapter.exit(e);
		MainFrame.mainFrame.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Season season=TransferSortHelper.StringToSeason(cb_season.getSelectedItem().toString());
//		if(e.getSource() == cb_season) System.out.println("aaaaaa");
		if(e.getSource()==cb_total_data||(e.getSource()==cb_season && !isAvg)){
			//总数据
			String data=cb_total_data.getSelectedItem().toString();
			TeamData dataType=TransferSortHelper.StringToDataTypeForTeam(data);
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortTeamsByComprehension("total", dataType,season);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams, season, false);
		}else if(e.getSource()==cb_avg_data||(e.getSource()==cb_season && isAvg)){
			//场均数据
			String data=cb_avg_data.getSelectedItem().toString();
			TeamData dataType=TransferSortHelper.StringToDataTypeForTeam(data);
			ArrayList<TeamPO> teams=MainFrame.mainFrame.bl.sortTeamsByComprehension("avg", dataType,season);
			MainFrame.mainFrame.topTabPanel.refreshTeamTable(teams, season, true);
		}
	}
}
