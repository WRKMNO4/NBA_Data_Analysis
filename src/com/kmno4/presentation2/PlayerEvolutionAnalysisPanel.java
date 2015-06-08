package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import sun.security.krb5.internal.PAData;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;

import PO.PlayerPO;
/**
 * 用折线图展现球员的命中率、效率、使用率、失误率的演变情况
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerEvolutionAnalysisPanel extends JPanel {
	private PlayerEvolutionAnalysisPanel playerEvolutionAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	public static final int 
	    PADDING = PlayerDataAnalysisPanel.PADDING,
	    COMBOBOX_HEIGHT = 30,
	    COMBOBOX_WIDTH = 150,
	    CHART_HEIGHT = PlayerDataAnalysisPanel.PANEL_HEIGHT - COMBOBOX_HEIGHT;
	
	private JComboBox<String> conditions;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	public PlayerEvolutionAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerEvolutionAnalysisPanel = this;
		this.playerPO = playerPO;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setLayout(null);
		
		conditions = new JComboBox<String>();
		conditions.setBounds(0, 0, COMBOBOX_WIDTH, COMBOBOX_HEIGHT);
		
		setChart();
	}
	
	private void setChart() {
		if(chartPanel != null) remove(chartPanel);
		
//		TODO
//		ArrayList<Double> data = MainFrame.mainFrame.bl.getAllMatchesDataOfOnePlayerOfOneSeason(dataType, playerPO, season)
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		chart = ChartFactory.createLineChart("lal", "lalala", "nanan", dataset);
		chartPanel = new ChartPanel(chart, true);
		chartPanel.setBounds(0, 0, Config.UI_WIDTH - 2 * PADDING, CHART_HEIGHT);
		add(chartPanel);
	}

}
