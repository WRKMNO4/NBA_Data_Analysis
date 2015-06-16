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
//	private MatchDataAnalysisFrame matchDataAnalysisFrame;
//	private MatchDataComparePanel matchDataComparePanel;
	private MatchPO matchPO;
	public static final int
		PADDING = 10,
		COMBOBOX_HEIGHT = 30, COMBOBOX_WIDTH = 270,
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
//		matchDataAnalysisFrame = f;
//		matchDataComparePanel = this;
		t1 = TeamListPO.findTeamByShortName(matchPO.getFirstTeam());
		t2 = TeamListPO.findTeamByShortName(matchPO.getSecondTeam());
		setLayout(null);
		setOpaque(false);
		setBounds(PADDING, 2 * PADDING + MatchDataAnalysisPanel.LABEL_HEIGHT + MatchDataAnalysisPanel.SELECT_PANEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING, MatchDataAnalysisPanel.PANEL_HEIGHT);
		
		conditions = new JComboBox<String>(new String[] {
				"投篮命中数/三分命中数/罚球命中数",
				"篮板数/进攻篮板数/防守篮板数",
				"助攻数/抢断数/盖帽数",
				"得分/进攻效率/防守效率",
				"投篮命中率/三分命中率/罚球"
		});
		conditions.setBounds(0, 0, COMBOBOX_WIDTH, COMBOBOX_HEIGHT);
		conditions.setFont(new Font("default", 0, 15));
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
		if(infos == null) {
			infos = new JLabel[3];
			for(int i = 0; i < 3; i ++) {
				infos[i] = new JLabel("", JLabel.CENTER);
				infos[i].setFont(new Font("default", 0, 15));
				add(infos[i]);
			}
			int width = 100, height = 20,
				x = COMBOBOX_WIDTH + PADDING - width / 2,
				y = 0 + height / 2,
				r = CHART_WIDTH / 2;
			infos[0].setBounds(x + r, y, width, height);
			infos[1].setBounds(x + (int)(r * 0.134), y + r * 3 / 2, width, height);
			infos[2].setBounds(x + (int)(r * 1.866), y + r * 3 / 2, width, height);
		}
		
		
		
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		TeamDataPO tdp1 = matchPO.getFirstTeamData(),
				tdp2 = matchPO.getSecondTeamData();	
		XYSeries data1 = new XYSeries(t1.getFullName());
		XYSeries data2 = new XYSeries(t2.getFullName());
		double delta;
		switch(conditions.getSelectedIndex()) {
		case 0 : 
			data1.add(0, tdp1.getNumberOfShooting()); data1.add(120, tdp1.getNumberOf3_point()); data1.add(240, tdp1.getNumberOfFreeThrow());
			data2.add(0, tdp2.getNumberOfShooting()); data2.add(120, tdp2.getNumberOf3_point()); data2.add(240, tdp2.getNumberOfFreeThrow());
			delta = 5;
			infos[0].setText("投篮命中数"); infos[1].setText("三分命中数"); infos[2].setText("罚球命中数");
			break;
		case 1 : 
			data1.add(0, tdp1.getNumberOfRebound()); data1.add(120, tdp1.getNumberOfAttackRebound()); data1.add(240, tdp1.getEfficiencyOfDefenseRebound());
			data2.add(0, tdp2.getNumberOfRebound()); data2.add(120, tdp2.getNumberOfAttackRebound()); data2.add(240, tdp2.getEfficiencyOfDefenseRebound());
			delta = 10;
			infos[0].setText("篮板数"); infos[1].setText("进攻篮板数"); infos[2].setText("防守篮板数");
			break;
		case 2 : 
			data1.add(0, tdp1.getNumberOfAssist()); data1.add(120, tdp1.getNumberOfSteal()); data1.add(240, tdp1.getNumberOfBlock());
			data2.add(0, tdp2.getNumberOfAssist()); data2.add(120, tdp2.getNumberOfSteal()); data2.add(240, tdp2.getNumberOfBlock());
			delta = 5;
			infos[0].setText("助攻数"); infos[1].setText("抢断数"); infos[2].setText("盖帽数");
			break;
		case 3 : 
			data1.add(0, tdp1.getScore()); data1.add(120, tdp1.getEfficiencyOfAttack()); data1.add(240, tdp1.getEfficiencyOfDefense());
			data2.add(0, tdp2.getScore()); data2.add(120, tdp2.getEfficiencyOfAttack()); data2.add(240, tdp2.getEfficiencyOfDefense());
			delta = 20;
			infos[0].setText("得分"); infos[1].setText("进攻效率"); infos[2].setText("防守效率");
			break;
		case 4 : 
			data1.add(0, tdp1.getPercentageOfShooting()); data1.add(120, tdp1.getPercentageOf3_point()); data1.add(240, tdp1.getPercentageOfFreeThrow());
			data2.add(0, tdp2.getPercentageOfShooting()); data2.add(120, tdp2.getPercentageOf3_point()); data2.add(240, tdp2.getPercentageOfFreeThrow());
			delta = 0.1;
			infos[0].setText("投篮命中率"); infos[1].setText("三分命中率"); infos[2].setText("罚球命中率");
			break;
		default : delta = 1;
		}
		
		dataset.addSeries(data1);
		dataset.addSeries(data2);
		
		jfc = ChartFactory.createPolarChart("", dataset, true, false, false);
		PolarPlot polarplot = (PolarPlot)jfc.getPlot();
		NumberAxis numberAxis = (NumberAxis)polarplot.getAxis();
		numberAxis.setTickUnit(new NumberTickUnit(delta));
		polarplot.setAngleLabelsVisible(false);
		
		cp = new ChartPanel(jfc);
		cp.setBounds(conditions.getX() + conditions.getWidth() + PADDING, 0, CHART_WIDTH, CHART_HEIGHT);
//		cp.setBackground(new Color(0, 0, 0, 0));
		cp.setVisible(true);
		add(cp);
	}
}
