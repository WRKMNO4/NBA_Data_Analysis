package com.kmno4.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PO.PlayerPO;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class PlayerDetailFrame extends JFrame {

	public JPanel playerDetailPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerDetailFrame frame = new PlayerDetailFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerDetailFrame(PlayerPO playerPO) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Config.PLAYER_DETAIL_UI_WIDTH, Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		playerDetailPanel = new PlayerDetailPanel(playerPO);
		this.add(playerDetailPanel);
		
		setVisible(true);
		
		MoveOfFrame m = new MoveOfFrame(this);
	}

}
