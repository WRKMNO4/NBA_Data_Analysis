package com.kmno4.presentation;

import javax.swing.JPanel;

import com.kmno4.common.Config;
import javax.swing.JLabel;
//用来显示页面信息的panel
public class PageInfoPanel extends JPanel {
	public JLabel page_name;
	/**
	 * Create the panel.
	 */
	public PageInfoPanel() {
		this.setBounds(0, Config.TOP_TAB_HEIGHT, Config.UI_WIDTH, Config.PAGE_INTRO_HEIGHT);
		this.setLayout(null);
		
		page_name = new JLabel("球员");
		page_name.setBounds(6, 6, Config.PAGE_INTRO_LABEL_WIDTH, Config.PAGE_INTRO_LABEL_HEIGHT);
		add(page_name);
	}
}
