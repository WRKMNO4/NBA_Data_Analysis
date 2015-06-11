package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import PO.TeamDataPO;
import PO.TeamListPO;
import PO.TeamPO;

import com.kmno4.common.Config;
/**
 * 全球队的攻防数据分析界面
 * 用柱状图分列所有球队的攻防数据
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamOffenAnalysisPanel extends JPanel {
//	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
//	private AllTeamOffenAnalysisPanel allTeamOffenAnalysisPanel;

	private static final int 
	    LABEL_HEIGHT = 40,
	    CHART_HEIGHT = (AllTeamDataAnalysisPanel.PANEL_HEIGHT - 2 * LABEL_HEIGHT) / 2;
	private JLabel eastLabel, westLabel;
	private JFreeChart eastChart, westChart;
	private ChartPanel eastPanel, westPanel;
	
	public AllTeamOffenAnalysisPanel(AllTeamDataAnalysisFrame f) {
//		this.allTeamDataAnalysisFrame = f;
//		this.allTeamOffenAnalysisPanel = this;
		setLayout(null);
		setOpaque(false);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
		
		eastLabel = new JLabel("东部联盟");
		eastLabel.setBounds(0, 0, getWidth(), LABEL_HEIGHT);
		eastLabel.setOpaque(true);
		eastLabel.setBackground(new Color(128, 128, 128, 150));
		eastLabel.setForeground(Color.white);
		eastLabel.setFont(new Font("default", 0, 15));
		add(eastLabel);
		
		westLabel = new JLabel("西部联盟");
		westLabel.setBounds(0, LABEL_HEIGHT + CHART_HEIGHT, getWidth(), LABEL_HEIGHT);
		westLabel.setOpaque(true);
		westLabel.setBackground(new Color(128, 128, 128, 150));
		westLabel.setForeground(Color.white);
		westLabel.setFont(new Font("default", 0, 15));
		add(westLabel);
		
		createChart();
	}

	
	private void createChart() {
		ArrayList<TeamPO> westTeams = TeamListPO.getAllWestTeams();
		ArrayList<TeamPO> eastTeams = TeamListPO.getAllEastTeams();
		double[][] wd = new double[2][westTeams.size()];
		String[] wc = new String[westTeams.size()];
		double[][] ed = new double[2][eastTeams.size()];
		String[] ec = new String[eastTeams.size()];
		String[] rowKeys = {"attack", "defense"};
 		for(int i = 0; i < westTeams.size(); i ++) {
 			TeamDataPO tdp = westTeams.get(i).getSeasonInfo(Config.LASTEST_SEASON).getAverageTeamData();
 			wd[0][i] = tdp.getEfficiencyOfAttack();
 			wd[1][i] = tdp.getEfficiencyOfDefense();
 			wc[i] = westTeams.get(i).getShortName();
 		}
 		for(int i = 0; i < eastTeams.size(); i ++) {
 			TeamDataPO tdp = eastTeams.get(i).getSeasonInfo(Config.LASTEST_SEASON).getAverageTeamData();
 			ed[0][i] = tdp.getEfficiencyOfAttack();
 			ed[1][i] = tdp.getEfficiencyOfDefense();
 			ec[i] = eastTeams.get(i).getShortName();
 		}
		CategoryDataset 
		    eastData = DatasetUtilities.createCategoryDataset(rowKeys, ec, ed),
			westData = DatasetUtilities.createCategoryDataset(rowKeys, wc, wd);
		eastChart = ChartFactory.createBarChart("", "", "", eastData);
		CategoryPlot p = eastChart.getCategoryPlot();
		((BarRenderer)p.getRenderer()).setItemMargin(0);
		westChart = ChartFactory.createBarChart("", "", "", westData);
		p = westChart.getCategoryPlot();
		((BarRenderer)p.getRenderer()).setItemMargin(0);
		eastPanel = new ChartPanel(eastChart);
		westPanel = new ChartPanel(westChart);
		eastPanel.setBounds(0, LABEL_HEIGHT, getWidth(), CHART_HEIGHT);
		westPanel.setBounds(0, CHART_HEIGHT + 2 * LABEL_HEIGHT, getWidth(), CHART_HEIGHT);
		add(westPanel);
		add(eastPanel);
	}
	
	
}
