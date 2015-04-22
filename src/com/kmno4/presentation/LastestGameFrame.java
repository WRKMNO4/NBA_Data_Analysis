package com.kmno4.presentation;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

import PO.PlayerPO;
import PO.TeamPO;

@SuppressWarnings("serial")
public class LastestGameFrame extends JFrame {
	public static LastestGameFrame lgf;
	
	private LastestGameFrame frame;
	private LastestGamePanel lastestGamePanel;
	
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
		addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
			@Override
			public void windowGainedFocus(WindowEvent e) {}
		});
		
		
		setVisible(true);

		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
	
	
}
