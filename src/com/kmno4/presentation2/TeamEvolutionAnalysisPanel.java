package com.kmno4.presentation2;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;

import PO.TeamPO;
/**
 * 排名演变部分，暂时包含一个折线图
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamEvolutionAnalysisPanel extends JPanel {
//	private TeamEvolutionAnalysisPanel teamEvolutionAnalysisPanel;
//	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	private TeamPO teamPO;
	
	public TeamEvolutionAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
//		this.teamDataAnalysisFrame = f;
//		this.teamEvolutionAnalysisPanel = this;
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
		int[] rank = MainFrame.mainFrame.bl.getgetRanksOfTeamByTeamFullName(teamPO.getFullName());
		double[][] value = new double[1][rank.length];
		for(int i = 0; i < rank.length; i ++) value[0][i] = rank[i];
		String[] year = new String[rank.length];
		for(int i = 0; i < rank.length; i ++)
			year[i] = (2002 + i) + "";
		
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(new String[]{teamPO.getShortName()}, year, value);
		
		
		lineChart = ChartFactory.createLineChart("rank of 2002-2015", "", "", dataset);
		CategoryPlot p = lineChart.getCategoryPlot();
		ValueAxis v = p.getRangeAxis();
		v.setUpperMargin(1);
		v.setLowerMargin(1);
		v.setRange(0, 15);
		chartPanel = new ChartPanel(lineChart, true);
		chartPanel.setBounds(0, 0, getWidth(), getHeight());
		add(chartPanel);
	}
}
