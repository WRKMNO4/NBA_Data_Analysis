package com.kmno4.presentation;

import javax.swing.JFrame;

import PO.MatchPO;

import com.alee.laf.WebLookAndFeel;
import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;

@SuppressWarnings("serial")
public class MatchInfoDetailFrame extends JFrame {

	public MatchInfoDetailPanel matchInfoDetailPanel;
	
	public MatchInfoDetailFrame(MatchPO matchPO) {
		setBounds(0, 0, Config.MATCH_DETAIL_WIDTH, Config.MATCH_DETAIL_HEIGHT);
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		matchInfoDetailPanel = new MatchInfoDetailPanel(matchPO, this);
		add(matchInfoDetailPanel);
		add(new ExitLabel(this));
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
		
	}
	
	
	public static void main(String[] args) {
		WebLookAndFeel.install();
		new MatchInfoDetailFrame(null);
	}
}
