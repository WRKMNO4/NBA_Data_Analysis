package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.kmno4.common.Config;

import PO.PlayerPO;
/**
 * 球员综合能力分析
 * 显示全球员的大表数据
 * 并且能直观显示单球员的数据，并且显示在某排序下的排名
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerPerformAnalysisPanel extends JPanel {
	private PlayerPerformAnalysisPanel playerPerformAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	public static final int 
    	PADDING = PlayerDataAnalysisPanel.PADDING;
	
	
	private JComboBox<String> conditions;
	
	public PlayerPerformAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerPerformAnalysisPanel = this;
		this.playerPO = playerPO;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setLayout(null);
		
		
		setData();
	}
	
	
	private void setData() {
		
	}

}
