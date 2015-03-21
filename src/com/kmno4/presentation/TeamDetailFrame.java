package com.kmno4.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class TeamDetailFrame extends JFrame {
	public JPanel teamDetailPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamDetailFrame frame = new TeamDetailFrame();
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
	public TeamDetailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Config.PLAYER_DETAIL_UI_WIDTH, Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setLayout(null);
		setUndecorated(true);
		
		
		teamDetailPanel = new TeamDetailPanel();
		this.add(teamDetailPanel);
		
		setVisible(true);
	}
}
