package com.kmno4.presentation;

import java.awt.EventQueue;

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

	/**
	 * Create the frame.
	 */
	public PlayerDetailFrame(PlayerPO playerPO) {
		setBounds(MainFrame.mainFrame.getX(),
				MainFrame.mainFrame.getY(),
				MainFrame.mainFrame.getWidth(),
				MainFrame.mainFrame.getHeight());
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		playerDetailPanel = new PlayerDetailPanel(playerPO, this);
		add(playerDetailPanel);
		
		JLabel close = new ExitLabel(this);
		add(close);
		
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}

}
