/**
 * 
 */
package com.kmno4.presentation2;

import java.awt.Point;

import javax.swing.JFrame;

import com.kmno4.common.Config;
import com.kmno4.presentation.MoveOfFrame;
import com.kmno4.presentation.RightClickClose;
import com.kmno4.presentation.button.ExitLabel;

import PO.MatchPO;

/**
 * @author MyCapitaine
 *
 */
@SuppressWarnings("serial")
public class MatchDataAnalysisFrame extends JFrame {
	
	
	public MatchDataAnalysisFrame(MatchPO m) {
		this(m, new Point());
	}
	public MatchDataAnalysisFrame(MatchPO m, Point location) {
		
		setBounds(location.x, 
				location.y, 
				Config.UI_WIDTH,
				Config.UI_HEIGHT);
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBackground(bgColor);
		add(new ExitLabel(this));
		
		add(new MatchDataAnalysisPanel(m, this));
		
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame mof = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
}
