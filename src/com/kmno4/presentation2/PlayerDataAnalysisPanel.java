package com.kmno4.presentation2;

import javax.swing.JPanel;

import com.kmno4.presentation.PlayerDetailFrame;

import PO.PlayerPO;
/**
 * 球员数据分析界面
 * 内含球员综合能力分析界面{@link PlayerPerformAnalysisPanel}，
 * 球员对比分析界面{@link PlayerComparisonAnalysisPanel}，
 * 球员演变分析界面{@link PlayerEvolutionAnalysisPanel}
 * 三个模块
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerDataAnalysisPanel extends JPanel {
	private PlayerDataAnalysisPanel playerDataAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	
	private JPanel current_panel;
	private PlayerPerformAnalysisPanel playerPerformAnalysisPanel;
	private PlayerComparisonAnalysisPanel playerComparisonAnalysisPanel;
	private PlayerEvolutionAnalysisPanel playerEvolutionAnalysisPanel;
	private PlayerPO playerPO;
	
	public PlayerDataAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerPO = playerPO;
		this.playerDataAnalysisPanel = this;
		
		
		add(current_panel = (playerEvolutionAnalysisPanel = new PlayerEvolutionAnalysisPanel(playerPO, playerDataAnalysisFrame)));
		
	}
	/**
	 * 切换到球员综合能力分析
	 */
	public void ToPerformAnalysis() {
		remove(current_panel);
		add(current_panel = (playerPerformAnalysisPanel = new PlayerPerformAnalysisPanel(playerPO, playerDataAnalysisFrame)));
		repaint();
	}
	/**
	 * 切换到球员对比
	 */
	public void ToComparisonAnalysis() {
		remove(current_panel);
		add(current_panel = (playerComparisonAnalysisPanel = new PlayerComparisonAnalysisPanel(playerPO, playerDataAnalysisFrame)));
		repaint();
	}
	/**
	 * 切换到球员演变分析
	 */
	public void ToEvolutionAnalysis() {
		remove(current_panel);
		add(current_panel = (playerEvolutionAnalysisPanel = new PlayerEvolutionAnalysisPanel(playerPO, playerDataAnalysisFrame)));
		repaint();
	}
	/**
	 * 切换到playerDetailFrame界面
	 */
	public void returnToDetailFrame() {
		new PlayerDetailFrame(playerPO, this.getLocation());
		playerDataAnalysisFrame.setVisible(false);
		playerDataAnalysisFrame.dispose();
	}
}
