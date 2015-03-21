package com.kmno4.presentation;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeadIconPanel extends JPanel {

	public JLabel head;
	/**
	 * Create the panel.
	 */
	public HeadIconPanel(ImageIcon icon,String e_name) {
		this.setLayout(null);
		
		JLabel head = new JLabel("Icon");
		head.setIcon(icon);
		head.setBounds(6, 6, 80, 78);
		add(head);
		
		JLabel name = new JLabel("a long long long name");
		name.setText(e_name);
		name.setBounds(98, 37, 113, 16);
		add(name);
	}
}
