package com.kmno4.presentation;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
//用来显示页面信息的panel
public class PageInfoPanel extends JPanel {
	public JLabel page_name;
	/**
	 * Create the panel.
	 */
	public PageInfoPanel(String pageInfo) {
		this.setBounds(0, Config.TOP_TAB_HEIGHT, Config.UI_WIDTH, Config.PAGE_INTRO_HEIGHT);
		this.setLayout(null);		
		
		page_name = new JLabel(pageInfo);
		page_name.setBounds(6, 6, Config.PAGE_INTRO_LABEL_WIDTH, Config.PAGE_INTRO_LABEL_HEIGHT);
		add(page_name);
	}
	
	public void refreshInfo(String pageInfo){
		this.page_name.setText(pageInfo);
	}
	
	public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		g.drawImage(Config.INTRO_PAGE_BG.getImage(),0, 0, Config.UI_WIDTH, Config.INTRODUCTION_WHITE, null);
	}
}
