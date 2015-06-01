package com.kmno4.presentation2;

import javax.swing.JPanel;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class AllTeamRecentMatchAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	private AllTeamRecentMatchAnalysisPanel allTeamRecentMatchAnalysisPanel;
	
	public AllTeamRecentMatchAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
		this.allTeamRecentMatchAnalysisPanel = this;
		setLayout(null);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
	}
}
