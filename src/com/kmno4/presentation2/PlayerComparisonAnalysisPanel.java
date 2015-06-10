package com.kmno4.presentation2;

import javax.swing.JPanel;

import com.kmno4.common.Config;

import PO.PlayerPO;
/**
 * 球员对比分析界面
 * 包含了一大堆功能
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerComparisonAnalysisPanel extends JPanel {
	private PlayerComparisonAnalysisPanel playerComparisonAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	public static final int 
    	PADDING = PlayerDataAnalysisPanel.PADDING;
	private PlayerPanel player1, player2;
//	private InfoPanel 
	
	
	public PlayerComparisonAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerComparisonAnalysisPanel = this;
		this.playerPO = playerPO;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setLayout(null);
		
	}
	
	class PlayerPanel extends JPanel {
		
	}
	
	class InfoPanel extends JPanel {
		
	}
	
	class InputPanel extends JPanel {
		
	}

}
