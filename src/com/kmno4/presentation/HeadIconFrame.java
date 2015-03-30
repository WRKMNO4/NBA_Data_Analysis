package com.kmno4.presentation;

import javax.swing.JFrame;

import com.kmno4.common.Config;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class HeadIconFrame extends JFrame {
	private HeadIconPanel headIconPanel;
	public HeadIconFrame(PlayerPO po, int x, int y) {
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(Config.HEAD_ICON_FRAME_WIDTH, Config.HEAD_ICON_FRAME_HEIGHT);
		setLocation(x, y - getHeight());
		headIconPanel = new HeadIconPanel(po);
		add(headIconPanel);
		
		setVisible(true);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
}
