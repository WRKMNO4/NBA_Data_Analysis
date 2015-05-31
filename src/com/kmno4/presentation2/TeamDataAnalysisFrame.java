package com.kmno4.presentation2;

import java.awt.Point;

import javax.swing.JFrame;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.MoveOfFrame;
import com.kmno4.presentation.RightClickClose;
import com.kmno4.presentation.button.ExitLabel;

import PO.TeamPO;
/**
 * 球队单个分析界面
 * 内含球员分析{@link TeamPlayerAnalysisPanel}，
 * 球队全比赛分析{@link TeamMatchAnalysisPanel}，
 * 球队排名演变分析{@link TeamEvolutionAnalysisPanel}
 * 三个模块
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamDataAnalysisFrame extends JFrame {
	public TeamDataAnalysisFrame(TeamPO teamPO) {
		this(teamPO, new Point());
	}
	public TeamDataAnalysisFrame(TeamPO teamPO, Point location) {
		setBounds(location.x,
				location.y,
				MainFrame.mainFrame.getWidth(),
				MainFrame.mainFrame.getHeight());
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBackground(bgColor);
		add(new ExitLabel(this));
		
		add(new TeamDataAnalysisPanel(this, teamPO));
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
		
	}
	
	
	

}
