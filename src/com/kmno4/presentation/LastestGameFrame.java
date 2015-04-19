package com.kmno4.presentation;

import javax.swing.JFrame;

import PO.PlayerPO;
import PO.TeamPO;

@SuppressWarnings("serial")
public class LastestGameFrame extends JFrame {
	LastestGamePanel lastestGamePanel;
	
	public LastestGameFrame(TeamPO teamPO) {
		
		lastestGamePanel = new LastestGamePanel(teamPO);
	}
	public LastestGameFrame(PlayerPO playerPO) {
		lastestGamePanel = new LastestGamePanel(playerPO);
		add(lastestGamePanel);
	}
	
}
