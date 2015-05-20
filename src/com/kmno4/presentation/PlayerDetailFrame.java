package com.kmno4.presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;

import PO.PlayerPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;

@SuppressWarnings("serial")
public class PlayerDetailFrame extends JFrame {

	public PlayerDetailPanel playerDetailPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerDetailFrame frame = new PlayerDetailFrame(null);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PlayerDetailFrame(PlayerPO playerPO) {
		this(playerPO, MainFrame.mainFrame.getLocation());
	}
	
	public PlayerDetailFrame(PlayerPO playerPO, Point location) {
		setBounds(location.x,
				location.y,
				MainFrame.mainFrame.getWidth(),
				MainFrame.mainFrame.getHeight());
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.white);

		JLabel close = new ExitLabel(this);
		add(close);
		
		playerDetailPanel = new PlayerDetailPanel(playerPO, this);
		add(playerDetailPanel);
		
		
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}

}
