package com.kmno4.presentation;

import java.awt.Color;

import javax.swing.JFrame;

import PO.MatchPO;

import com.alee.laf.WebLookAndFeel;
import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;

@SuppressWarnings("serial")
public class MatchInfoDetailFrame extends JFrame {

	public MatchInfoDetailPanel matchInfoDetailPanel;
	
	public MatchInfoDetailFrame(MatchPO matchPO) {
		setBounds(MainFrame.mainFrame.getX(),
				MainFrame.mainFrame.getY(),
				MainFrame.mainFrame.getWidth(),
				MainFrame.mainFrame.getHeight());
		setLayout(null);
		setUndecorated(true);
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		add(new ExitLabel(this));
		matchInfoDetailPanel = new MatchInfoDetailPanel(matchPO, this);
		add(matchInfoDetailPanel);
		
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
