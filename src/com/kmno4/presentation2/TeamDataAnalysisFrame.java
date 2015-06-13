package com.kmno4.presentation2;

import java.awt.Point;

import javax.swing.JFrame;

import com.kmno4.common.Config;
import com.kmno4.presentation.MoveOfFrame;
import com.kmno4.presentation.RightClickClose;
import com.kmno4.presentation.button.ExitLabel;

import PO.TeamPO;
/**
 * {@link TeamDataAnalysisPanel}
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
				Config.UI_WIDTH,
				Config.UI_HEIGHT);
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
