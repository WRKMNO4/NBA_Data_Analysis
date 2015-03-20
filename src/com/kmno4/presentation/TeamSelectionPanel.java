package com.kmno4.presentation;

import java.awt.Color;

import javax.swing.JPanel;

import com.kmno4.common.Config;

import javax.swing.JLabel;

public class TeamSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TeamSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		JLabel e1 = new JLabel("东一");
		e1.setBounds(6, 30, 108, 99);
		add(e1);
		
		JLabel e2 = new JLabel("东二");
		e2.setBounds(117, 30, 120, 99);
		add(e2);
		
		JLabel e3 = new JLabel("东三");
		e3.setBounds(240, 30, 113, 99);
		add(e3);
		
		JLabel w1 = new JLabel("西一");
		w1.setBounds(399, 30, 120, 99);
		add(w1);
		
		JLabel w2 = new JLabel("西二");
		w2.setBounds(521, 30, 120, 99);
		add(w2);
		
		JLabel w3 = new JLabel("西三");
		w3.setBounds(643, 30, 120, 99);
		add(w3);
	}
}
