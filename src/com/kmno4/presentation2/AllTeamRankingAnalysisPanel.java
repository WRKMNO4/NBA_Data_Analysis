package com.kmno4.presentation2;

import javax.swing.JPanel;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class AllTeamRankingAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	private AllTeamRankingAnalysisPanel allTeamRankingAnalysisPanel;
	
	public AllTeamRankingAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
		this.allTeamRankingAnalysisPanel = this;
		setLayout(null);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
	}
}
