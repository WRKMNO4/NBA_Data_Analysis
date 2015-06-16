/**
 * 
 */
package com.kmno4.presentation2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

import com.kmno4.common.Config;

import PO.MatchPO;

/**
 * @author MyCapitaine
 *
 */
@SuppressWarnings("serial")
public class MatchDataComparePanel extends JPanel {
	private MatchDataAnalysisFrame matchDataAnalysisFrame;
	private MatchDataComparePanel matchDataComparePanel;
	private MatchPO matchPO;
	
	private JComboBox<String> conditions;
	private TeamPanel team1, team2;
	public MatchDataComparePanel(MatchPO m, MatchDataAnalysisFrame f) {
		matchPO = m;
		matchDataAnalysisFrame = f;
		matchDataComparePanel = this;
		setLayout(null);
		setOpaque(false);
//		setBounds(0, 0, Config.UI_WIDTH, Config.UI_HEIGHT);
		
		int k = m.getAllScore().size();
		String[] sl = new String[k];
		sl[0] = "第1节";
		sl[1] = "第2节";
		sl[2] = "第3节";
		sl[3] = "第4节";
		int i = k - 4;
		while(i > 0) {
			sl[i + 3] = "加时第" + i + "节";
			i --;
		}
		conditions = new JComboBox<String>(sl);
		conditions.setBounds(PADDING, PADDING, COMBOBOX_WIDTH, COMBOBOX_HEIGHT);
		conditions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comp();
			}
		});
		comp();
		
	}
	
	
	public static final int
		PADDING = 10,
		COMBOBOX_HEIGHT = 30, COMBOBOX_WIDTH = 200,
		TEAM_PANEL_WIDTH = 450,
		TEAM_PANEL_HEIGHT = Config.UI_HEIGHT - 3 * PADDING - COMBOBOX_HEIGHT,
		LOGO_WIDTH = 150;
	
	class TeamPanel extends JPanel {
		JLabel teamLabel;
		JFreeChart jfc;
		ChartPanel cp;
		public TeamPanel(boolean isFirst) {
			setLayout(null);
//			setBounds(isFirst ? PADDING : , y, width, height);
			
//			XYSeriesCollection
			
			
		}
	}
	
	private void comp() {
		if(team1 != null) {
			team1.setVisible(false);
			remove(team1);
		}
		if(team2 != null) {
			team2.setVisible(false);
			remove(team2);
		}
		team1 = new TeamPanel(true);
		add(team1);
		team2 = new TeamPanel(false);
		add(team2);
		
	}
}
