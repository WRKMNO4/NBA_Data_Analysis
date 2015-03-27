package com.kmno4.presentation;

import javax.swing.JFrame;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class HeadIconFrame extends JFrame {
	private HeadIconPanel headIconPanel;
	public HeadIconFrame(PlayerPO po) {
		setBounds(0, 0, 0, 0);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		
		headIconPanel = new HeadIconPanel(po);
		add(headIconPanel);
		
	}
}
