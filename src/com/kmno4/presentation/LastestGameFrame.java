package com.kmno4.presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import PO.PlayerPO;
import PO.TeamPO;

@SuppressWarnings("serial")
public class LastestGameFrame extends JFrame {
	LastestGameFrame frame;
	LastestGamePanel lastestGamePanel;
	
	public LastestGameFrame(TeamPO teamPO, int x, int y) {
		lastestGamePanel = new LastestGamePanel(teamPO, this);
		setLocation(x, y);
		ini();
	}
	public LastestGameFrame(PlayerPO playerPO, int x, int y) {
		lastestGamePanel = new LastestGamePanel(playerPO, this);
		setLocation(x, y);
		ini();
	}
	private void ini() {
		add(lastestGamePanel);
		frame = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setUndecorated(true);
		
		setVisible(true);

		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
	
	
}
