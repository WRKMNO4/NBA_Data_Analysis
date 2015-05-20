package com.kmno4.presentation2;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.MoveOfFrame;
import com.kmno4.presentation.PlayerDetailFrame;
import com.kmno4.presentation.RightClickClose;
import com.kmno4.presentation.button.ExitLabel;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class PlayerDataAnalysisFrame extends JFrame {
	private JPanel current_panel;
	private PlayerSeasonAnalysisPanel playerSeasonAnalysisPanel;
	private PlayerOffenAnalysisPanel playerOffenAnalysisPanel;
	private PlayerEvolutionAnalysisPanel playerEvolutionAnalysisPanel;
	private PlayerCostPerformAnalysisPanel playerCostPerformAnalysisPanel;
	private PlayerPO playerPO;
	
	public PlayerDataAnalysisFrame(PlayerPO playerPO) {
		this(playerPO, new Point());
	}
	public PlayerDataAnalysisFrame(PlayerPO playerPO, Point location) {
		this.playerPO = playerPO;
		setBounds(location.x, 
				location.y, 
				MainFrame.mainFrame.getWidth(),
				MainFrame.mainFrame.getHeight());
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBackground(bgColor);
		add(new ExitLabel(this));
		
		add(current_panel = (playerSeasonAnalysisPanel = new PlayerSeasonAnalysisPanel(playerPO, this)));
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
	/**
	 * 切换到球员赛季分析
	 */
	public void ToSeasonAnalysis() {
		remove(current_panel);
		add(current_panel = (playerSeasonAnalysisPanel = new PlayerSeasonAnalysisPanel(playerPO, this)));
		repaint();
	}
	/**
	 * 切换到球员攻防分析
	 */
	public void ToOffenAnalysis() {
		remove(current_panel);
		add(current_panel = (playerOffenAnalysisPanel = new PlayerOffenAnalysisPanel(playerPO, this)));
		repaint();
	}
	/**
	 * 切换到球员演变分析
	 */
	public void ToEvolutionAnalysis() {
		remove(current_panel);
		add(current_panel = (playerEvolutionAnalysisPanel = new PlayerEvolutionAnalysisPanel(playerPO, this)));
		repaint();
	}
	/**
	 * 切换到球员性价比分析
	 */
	public void ToCostPerformAnalysis() {
		remove(current_panel);
		add(current_panel = (playerCostPerformAnalysisPanel = new PlayerCostPerformAnalysisPanel(playerPO, this)));
		repaint();
	}
	/**
	 * 切换到playerDetailFrame界面
	 */
	public void returnToDetailFrame() {
		new PlayerDetailFrame(playerPO, this.getLocation());
		setVisible(false);
		dispose();
	}
	
}
