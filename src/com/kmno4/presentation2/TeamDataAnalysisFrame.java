package com.kmno4.presentation2;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.MoveOfFrame;
import com.kmno4.presentation.RightClickClose;
import com.kmno4.presentation.TeamDetailFrame;
import com.kmno4.presentation.button.ExitLabel;

import PO.TeamPO;

@SuppressWarnings("serial")
public class TeamDataAnalysisFrame extends JFrame {
	private JPanel current_panel;
	private TeamSeasonAnalysisPanel teamSeasonAnalysisPanel;
	private TeamOffenAnalysisPanel teamOffenAnalysisPanel;
	private TeamEvolutionAnalysisPanel teamEvolutionAnalysisPanel;
	private TeamPO teamPO;
	
	public TeamDataAnalysisFrame(TeamPO teamPO) {
		this(teamPO, new Point());
	}
	public TeamDataAnalysisFrame(TeamPO teamPO, Point location) {
		this.teamPO = teamPO;
		setBounds(location.x,
				location.y,
				MainFrame.mainFrame.getWidth(),
				MainFrame.mainFrame.getHeight());
		setLayout(null);
		setUndecorated(true);setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBackground(bgColor);
		add(new ExitLabel(this));
		
		add(current_panel = (teamSeasonAnalysisPanel = new TeamSeasonAnalysisPanel(teamPO, this)));
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
		
	}
	
	/**
	 * 切换到球队赛季分析
	 */
	public void ToSeasonAnalysis() {
		remove(current_panel);
		add(current_panel = (teamSeasonAnalysisPanel = new TeamSeasonAnalysisPanel(teamPO, this)));
		repaint();
	}
	/**
	 * 切换到球队攻防分析
	 */
	public void ToOffenAnalysis() {
		remove(current_panel);
		add(current_panel = (teamOffenAnalysisPanel = new TeamOffenAnalysisPanel(teamPO, this)));
		repaint();
	}
	/**
	 * 切换到球队演变分析
	 */
	public void ToEvolutionAnalysis() {
		remove(current_panel);
		add(current_panel = (teamEvolutionAnalysisPanel = new TeamEvolutionAnalysisPanel(teamPO, this)));
		repaint();
	}
	
	/**
	 * 切换到teamDetailFrame界面
	 */
	public void returnToDetailFrame() {
		new TeamDetailFrame(teamPO, this.getLocation());
		setVisible(false);
		dispose();
	}

}
