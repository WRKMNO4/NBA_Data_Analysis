package com.kmno4.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kmno4.common.Config;

public class PlayerDetailFrame extends JFrame {

	private JPanel contentPane;
	public JPanel playerDetailPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerDetailFrame frame = new PlayerDetailFrame();
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
	public PlayerDetailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Config.PLAYER_DETAIL_UI_WIDTH, Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setLayout(null);
		
		playerDetailPanel = new PlayerDetailPanel();
		this.add(playerDetailPanel);
		
		setVisible(true);
	}

}
