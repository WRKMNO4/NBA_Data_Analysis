package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import com.kmno4.common.Config;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerPO;
/**
 * 用折线图展现球员的命中率、效率、使用率、失误率、助攻率、抢断率的演变情况
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerEvolutionAnalysisPanel extends JPanel {
//	private PlayerEvolutionAnalysisPanel playerEvolutionAnalysisPanel;
//	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	public static final int 
	    PADDING = PlayerDataAnalysisPanel.PADDING,
	    COMBOBOX_HEIGHT = 30,
	    COMBOBOX_WIDTH = 150,
	    CHART_HEIGHT = PlayerDataAnalysisPanel.PANEL_HEIGHT - COMBOBOX_HEIGHT - PADDING;
	
	private JComboBox<String> conditions;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	public PlayerEvolutionAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
//		this.playerDataAnalysisFrame = f;
//		this.playerEvolutionAnalysisPanel = this;
		this.playerPO = playerPO;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setBackground(Color.white);
		setLayout(null);
		
		conditions = new JComboBox<String>(new String[]{"命中率", "效率", "使用率", "失误率", "助攻率", "抢断率"});
		conditions.setFont(new Font("default", 0, 15));
		conditions.setBounds(0, 0, COMBOBOX_WIDTH, COMBOBOX_HEIGHT);
		conditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChart();
			}
		});
		add(conditions);
		setChart();
	}
	
	private void setChart() {
		if(chartPanel != null) {
			chartPanel.setVisible(false);
			remove(chartPanel);
		}
		
		ArrayList<PlayerDataOfOneMatchPO> pdlist = playerPO.getSeasonInfo(Config.LASTEST_SEASON).getDatas();
		double[][] d = new double[1][pdlist.size()];
		String[] s = new String[pdlist.size()];
		switch(conditions.getSelectedIndex()) {
		case 0 : for(int i = 0; i < s.length; i ++) d[0][i] = pdlist.get(i).getPercentageOfShooting(); break;
		case 1 : for(int i = 0; i < s.length; i ++) d[0][i] = pdlist.get(i).getEfficiency(); break;
		case 2 : for(int i = 0; i < s.length; i ++) d[0][i] = pdlist.get(i).getPercentageOfUse(); break;
		case 3 : for(int i = 0; i < s.length; i ++) d[0][i] = pdlist.get(i).getPercentageOfFault(); break;
		case 4 : for(int i = 0; i < s.length; i ++) d[0][i] = pdlist.get(i).getPercentageOfAssist(); break;
		case 5 : for(int i = 0; i < s.length; i ++) d[0][i] = pdlist.get(i).getPercentageOfSteal(); break;
		default :
		}
		for(int i = 0; i < s.length; i ++) {
			if(Double.isNaN(d[0][i])) d[0][i] = 0;
			s[i] = i + "";
		}
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				new String[]{""},
				s, d);
		chart = ChartFactory.createLineChart("data evolution of latest season", "", "", dataset);
		chart.getCategoryPlot().getDomainAxis().setVisible(false);
		chartPanel = new ChartPanel(chart, true);
		chartPanel.setBounds(0, COMBOBOX_HEIGHT, Config.UI_WIDTH - 2 * PADDING, CHART_HEIGHT);
		add(chartPanel);
	}

}
