package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;
/**
 * 全球队的攻防数据分析界面
 * 用柱状图分列所有球队的攻防数据
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamOffenAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	private AllTeamOffenAnalysisPanel allTeamOffenAnalysisPanel;

	private static final int 
	    LABEL_HEIGHT = 40,
	    CHART_HEIGHT = (AllTeamDataAnalysisPanel.PANEL_HEIGHT - 2 * LABEL_HEIGHT) / 2;
	private JLabel southLabel, westLabel;
	private JFreeChart southChart, westChart;
	private ChartPanel southPanel, westPanel;
	
	public AllTeamOffenAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
		this.allTeamOffenAnalysisPanel = this;
		setLayout(null);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
		
		southLabel = new JLabel("东部联盟");
		southLabel.setBounds(0, 0, getWidth(), LABEL_HEIGHT);
		southLabel.setOpaque(true);
		southLabel.setBackground(new Color(128, 128, 128, 150));
		southLabel.setForeground(Color.white);
		southLabel.setFont(new Font("default", 0, 15));
		add(southLabel);
		
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
		
	}
	
	
}
