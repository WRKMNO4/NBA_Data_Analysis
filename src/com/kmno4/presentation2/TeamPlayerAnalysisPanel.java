package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.kmno4.common.Config;

import PO.PlayerPO;
import PO.TeamPO;
/**
 * 球员展示分析，
 * 并按照条件进行排名
 * 着重展示第一名，并有柱状图的对比
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamPlayerAnalysisPanel extends JPanel {
	private TeamPlayerAnalysisPanel teamPlayerAnalysisPanel;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	private TeamPO teamPO;
	public static final int 
	    PADDING = TeamDataAnalysisPanel.PADDING,
	    COMBOBOX_HEIGHT = 30,
	    COMBOBOX_WIDHT = 150,
	    MAIN_PLAYER_PANEL_WIDTH = 550,
	    MAIN_PLAYER_PANEL_HEIGHT = 330,
	    OTHER_PLAYER_PANEL_WIDTH = Config.UI_WIDTH - 3 * PADDING - MAIN_PLAYER_PANEL_WIDTH,
	    OTHER_PLAYER_PANEL_HEIGHT = MAIN_PLAYER_PANEL_HEIGHT + COMBOBOX_HEIGHT,
	    CHART_WIDTH = Config.UI_WIDTH - 2 * PADDING,
	    CHART_HEIGHT = TeamDataAnalysisPanel.PANEL_HEIGHT - PADDING - OTHER_PLAYER_PANEL_HEIGHT;
	    
	private JComboBox<String> conditions;
	private MainPlayerPanel mainPlayerPanel;
	private OtherPlayerPanel otherPlayerPanel;
	//TODO 柱状图 显示数据值
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	public TeamPlayerAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamDataAnalysisFrame = f;
		this.teamPlayerAnalysisPanel = this;
		setLayout(null);
		setBounds(TeamDataAnalysisPanel.PADDING,
				2 * TeamDataAnalysisPanel.PADDING + TeamDataAnalysisPanel.SELECT_PART_HEIGHT + TeamDataAnalysisPanel.TEAM_LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * TeamDataAnalysisPanel.PADDING,
				TeamDataAnalysisPanel.PANEL_HEIGHT);
		
		conditions = new JComboBox<String>();
		conditions.setBounds(0, 0, COMBOBOX_WIDHT, COMBOBOX_HEIGHT);
		conditions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		add(conditions);
		
		setPanel();
		createChart();
	}
	
	
	/**
	 * 初始化以及combobox的响应事件
	 */
	private void setPanel() {
		if(mainPlayerPanel != null) remove(mainPlayerPanel);
		if(otherPlayerPanel != null) remove(otherPlayerPanel);
		//TODO 获取球员列表等信息
		mainPlayerPanel = new MainPlayerPanel();
		add(mainPlayerPanel);
		otherPlayerPanel = new OtherPlayerPanel();
		add(otherPlayerPanel);
 	}
	/**
	 * 初始化以及响应combobox改变图表
	 */
	private void createChart() {
		if(chartPanel != null) remove(chartPanel);
		
		
		
//		chart = ChartFactory.c
	}
	
	/**
	 * 排名第一球员展示Panel
	 * @author hutao
	 *
	 */
	class MainPlayerPanel extends JPanel {
		public MainPlayerPanel() {
			setBounds(0, COMBOBOX_HEIGHT, MAIN_PLAYER_PANEL_WIDTH, MAIN_PLAYER_PANEL_HEIGHT);
			setLayout(null);
			setBackground(Color.CYAN);
			//TODO 获取到的第一名player
			PlayerPO playerPO = null;
		}
	}
	/**
	 * 剩余球员列表展示Panel
	 * @author hutao
	 *
	 */
	class OtherPlayerPanel extends JPanel {
		public OtherPlayerPanel() {
			setBounds(MAIN_PLAYER_PANEL_WIDTH + PADDING, 0, OTHER_PLAYER_PANEL_WIDTH, OTHER_PLAYER_PANEL_HEIGHT);
			setLayout(null);
			setBackground(Color.BLACK);
		}
	}
}
