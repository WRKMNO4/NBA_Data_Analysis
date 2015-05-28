package com.kmno4.presentation2;

import javax.swing.JPanel;

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
	
	public TeamMatchAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamSeasonAnalysisPanel = this;
		this.teamDataAnalysisFrame = f;
		
		setLayout(null);
		
	}

}
