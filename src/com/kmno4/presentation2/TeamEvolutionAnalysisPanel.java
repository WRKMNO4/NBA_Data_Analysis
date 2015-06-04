package com.kmno4.presentation2;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kmno4.common.Config;

import PO.TeamPO;
/**
 * 排名演变部分，暂时包含一个折线图
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamEvolutionAnalysisPanel extends JPanel {
	private TeamEvolutionAnalysisPanel teamEvolutionAnalysisPanel;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	private TeamPO teamPO;
	
	public TeamEvolutionAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamDataAnalysisFrame = f;
		this.teamEvolutionAnalysisPanel = this;
		setLayout(null);
		setBounds(TeamDataAnalysisPanel.PADDING,
				2 * TeamDataAnalysisPanel.PADDING + TeamDataAnalysisPanel.SELECT_PART_HEIGHT + TeamDataAnalysisPanel.TEAM_LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * TeamDataAnalysisPanel.PADDING,
				TeamDataAnalysisPanel.PANEL_HEIGHT);
		
		createChart();
		
		
	}
	
	private JFreeChart lineChart;
	private ChartPanel chartPanel;
	private void createChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		
		lineChart = ChartFactory.createLineChart("llal", "ooo", "yyyy", dataset);
		chartPanel = new ChartPanel(lineChart, true);
		chartPanel.setBounds(0, 0, 600, 400);
		add(chartPanel);
	}
}
