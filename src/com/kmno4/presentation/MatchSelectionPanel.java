package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kmno4.common.Config;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MatchSelectionPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public MatchSelectionPanel() {
		setLayout(null);
		this.setBounds(0, 0, Config.UI_WIDTH, Config.MATCH_SELECTION_PANEL_HEIGHT);
		this.setVisible(true);
		this.setBackground(Color.gray);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 75, 186, 27);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("搜索");
		lblNewLabel.setBounds(22, 22, 42, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("日历");
		lblNewLabel_1.setIcon(Config.SCHEDULE);
		lblNewLabel_1.setBounds(660, 66, 98, 43);
		add(lblNewLabel_1);
		

		textField = new JTextField();
		textField.setBounds(63, 16, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(275, 75, 164, 27);
		add(comboBox_1);
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(Config.MATCH_SELECTION_BACKGROUND.getImage(), 0, 0, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT, null);
	}
}
