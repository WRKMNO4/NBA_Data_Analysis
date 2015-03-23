package com.kmno4.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;

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
					TeamDetailFrame frame = new TeamDetailFrame(null);
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
	public TeamDetailFrame(TeamPO teamPO) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(
				MainFrame.mainFrame.getX() + 50,
				MainFrame.mainFrame.getY() + 100,
				Config.PLAYER_DETAIL_UI_WIDTH,
				Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setLayout(null);
		setUndecorated(true);
		
		
		teamDetailPanel = new TeamDetailPanel(teamPO, this);
		this.add(teamDetailPanel);
		
		JLabel close = new ExitLabel(this);
		add(close);
		
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
	}
}
