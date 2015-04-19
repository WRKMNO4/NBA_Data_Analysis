package com.kmno4.presentation;

import javax.swing.JFrame;

import com.kmno4.presentation.button.ExitLabel;

@SuppressWarnings("serial")
public class MatchInfoDetailFrame extends JFrame {

	public MatchInfoDetailPanel matchInfoDetailPanel;
	
	public MatchInfoDetailFrame() {
		setBounds(0, 0, 700, 600);
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		matchInfoDetailPanel = new MatchInfoDetailPanel(this);
		add(matchInfoDetailPanel);
		add(new ExitLabel(this));
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
		
	}
	
	
	public static void main(String[] args) {
		new MatchInfoDetailFrame();
	}
}