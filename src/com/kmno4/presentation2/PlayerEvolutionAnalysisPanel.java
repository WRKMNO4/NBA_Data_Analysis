package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import PO.PlayerPO;
/**
 * 球员的数据演变情况
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerEvolutionAnalysisPanel extends JPanel {
	private PlayerEvolutionAnalysisPanel playerEvolutionAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	
	private JComboBox<String> conditions;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	public PlayerEvolutionAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerEvolutionAnalysisPanel = this;
		this.playerPO = playerPO;
		
		
		
	}
	
	private void setChart() {
		
	}

}
