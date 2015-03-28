package com.kmno4.presentation;

import javax.swing.JFrame;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class HeadIconFrame extends JFrame {
	private HeadIconPanel headIconPanel;
	public HeadIconFrame(PlayerPO po, int x, int y) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setBounds(x, y, 200, 100);
		
		headIconPanel = new HeadIconPanel(po);
		add(headIconPanel);
		
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
}
