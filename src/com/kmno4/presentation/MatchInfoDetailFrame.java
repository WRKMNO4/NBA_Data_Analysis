package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import PO.MatchPO;

import com.alee.laf.WebLookAndFeel;
import com.kmno4.presentation.button.ExitLabel;

@SuppressWarnings("serial")
public class MatchInfoDetailFrame extends JFrame {

	public MatchInfoDetailPanel matchInfoDetailPanel;
	
	public MatchInfoDetailFrame(MatchPO matchPO) {
		this(matchPO, MainFrame.mainFrame.getLocation());
	}
	
	public MatchInfoDetailFrame(MatchPO matchPO, Point location) {
		setBounds(location.x,
				location.y,
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
