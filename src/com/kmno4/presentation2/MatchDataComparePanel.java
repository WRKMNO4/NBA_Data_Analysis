/**
 * 
 */
package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.kmno4.common.Config;
import com.kmno4.presentation.PlayerDetailPanel;

import PO.MatchPO;
import PO.TeamDataPO;
import PO.TeamListPO;
import PO.TeamPO;

/**
 * @author MyCapitaine
 *
 */
@SuppressWarnings("serial")
public class MatchDataComparePanel extends JPanel {
	private MatchDataAnalysisFrame matchDataAnalysisFrame;
	private MatchDataComparePanel matchDataComparePanel;
	private MatchPO matchPO;
	public static final int
		PADDING = 10,
		COMBOBOX_HEIGHT = 30, COMBOBOX_WIDTH = 200,
		TEAM_WIDTH = 230,
		CHART_HEIGHT = MatchDataAnalysisPanel.PANEL_HEIGHT - PADDING,
		CHART_WIDTH = CHART_HEIGHT;
	
	private JComboBox<String> conditions;
	private JLabel team1, team2;
	private JLabel team1Name, team2Name;
	private JFreeChart jfc;
	private ChartPanel cp;
	private JLabel[] infos;
	private TeamPO t1, t2;
	public MatchDataComparePanel(MatchPO m, MatchDataAnalysisFrame f) {
		matchPO = m;
		matchDataAnalysisFrame = f;
		matchDataComparePanel = this;
		t1 = TeamListPO.findTeamByShortName(matchPO.getFirstTeam());
		t2 = TeamListPO.findTeamByShortName(matchPO.getSecondTeam());
		setLayout(null);
		setOpaque(false);
		setBounds(PADDING, 2 * PADDING + MatchDataAnalysisPanel.LABEL_HEIGHT + MatchDataAnalysisPanel.SELECT_PANEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING, MatchDataAnalysisPanel.PANEL_HEIGHT);
		
		int k = m.getAllScore().size();
		String[] sl = new String[k + 1];
		sl[0] = "合计";
		sl[1] = "第1节";
		sl[2] = "第2节";
		sl[3] = "第3节";
		sl[4] = "第4节";
		int i = k - 4;
		while(i > 0) {
			sl[i + 4] = "加时第" + i + "节";
			i --;
		}
		conditions = new JComboBox<String>(sl);
		conditions.setBounds(0, 0, COMBOBOX_WIDTH, COMBOBOX_HEIGHT);
		conditions.setFont(new Font("default", 0, 16));
		conditions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createChart();
			}
		});
		add(conditions);
		
		team1 = new JLabel();
		team1.setBounds(0, conditions.getY() + conditions.getHeight() + PADDING, TEAM_WIDTH, TEAM_WIDTH);
		PlayerDetailPanel.fillLabel(t1.getTeamLogoURL(), team1, TEAM_WIDTH, TEAM_WIDTH);
		add(team1);
		team1Name = new JLabel(t1.getFullName() + "/" + t1.getShortName());
		team1Name.setBounds(PADDING, team1.getY() + team1.getHeight() + PADDING, 200, 30);
		team1Name.setForeground(Color.white);
		team1Name.setFont(new Font("default", 2, 20));
		add(team1Name);
		
		team2 = new JLabel();
		team2.setBounds(0, team1Name.getY() + team1Name.getHeight() + PADDING, TEAM_WIDTH, TEAM_WIDTH);
		PlayerDetailPanel.fillLabel(t2.getTeamLogoURL(), team2, TEAM_WIDTH, TEAM_WIDTH);
		add(team2);
		team2Name = new JLabel(t2.getFullName() + "/" + t2.getShortName());
		team2Name.setBounds(PADDING, team2.getY() + team2.getHeight() + PADDING, 200, 30);
		team2Name.setForeground(Color.white);
		team2Name.setFont(new Font("default", 2, 20));
		add(team2Name);
		

		createChart();
	}
	
	
	
	private void createChart() {
		if(cp != null) {
			cp.setVisible(false);
			remove(cp);
		}
		
		
		XYSeriesCollection dataset = new XYSeriesCollection();

		TeamDataPO tdp = matchPO.getFirstTeamData();
		XYSeries data1 = new XYSeries(t1.getFullName());
		data1.add(0, tdp.getScore());
		data1.add(90, tdp.getNumberOfRebound());
		data1.add(180, tdp.getNumberOfAssist());
		data1.add(270, tdp.getNumberOfSteal());
		dataset.addSeries(data1);
		tdp = matchPO.getSecondTeamData();
		XYSeries data2 = new XYSeries(t2.getFullName());
		data2.add(0, tdp.getScore());
		data2.add(90, tdp.getNumberOfRebound());
		data2.add(180, tdp.getNumberOfAssist());
		data2.add(270, tdp.getNumberOfSteal());
		dataset.addSeries(data2);
		
		jfc = ChartFactory.createPolarChart("", dataset, true, false, false);
		PolarPlot polarplot = (PolarPlot)jfc.getPlot();
		NumberAxis numberAxis = (NumberAxis)polarplot.getAxis();
		numberAxis.setTickUnit(new NumberTickUnit(10));
		polarplot.setAngleLabelsVisible(false);
//		polarplot.geta
		
		cp = new ChartPanel(jfc);
		cp.setBounds(team1.getX() + team1.getWidth() + PADDING, 0, CHART_WIDTH, CHART_HEIGHT);
//		cp.setBackground(new Color(0, 0, 0, 0));
		cp.setVisible(true);
		add(cp);
	}
}
