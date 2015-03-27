package com.kmno4.presentation;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class HeadIconPanel extends JPanel {
	private JLabel head;
	private JLabel name;
	
	public HeadIconPanel(PlayerPO po) {
		this.setLayout(new GridBagLayout());
		this.setBounds(0, 0, 200, 100);
		
		JLabel head = new JLabel("Icon");
		JLabel name = new JLabel("a long long long name");
		
	}
		
}
