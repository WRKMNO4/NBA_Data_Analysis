package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.presentation.table.TableGroup;

import PO.TeamPO;
/**
 * 球队全比赛数据部分
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamMatchAnalysisPanel extends JPanel {
	private TeamMatchAnalysisPanel teamSeasonAnalysisPanel;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	private TeamPO teamPO;
	private JComboBox<String> seasonBox;
	private JLabel seasonLabel;
	private TableGroup tg;
	
	public TeamMatchAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamSeasonAnalysisPanel = this;
		this.teamDataAnalysisFrame = f;
		
		setLayout(null);
		
	}

}
