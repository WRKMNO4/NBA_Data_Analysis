package com.kmno4.presentation2;

import javax.swing.JPanel;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class PlayerComparisonAnalysisPanel extends JPanel {
	private PlayerComparisonAnalysisPanel playerComparisonAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	
	public PlayerComparisonAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerComparisonAnalysisPanel = this;
		this.playerPO = playerPO;
		
	}

}
