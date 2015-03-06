package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.kmno4.common.Config;

import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class SelectionPanel extends JPanel {
	
	private TextField tf_search;
	

	/**
	 * Create the panel.
	 */
	public SelectionPanel() {
		
		this.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		setLayout(null);
		
		
		
		tf_search = new TextField();
		tf_search.setBounds(685, 5, 105, 22);
		tf_search.setBackground(Color.BLUE);
		add(tf_search);
		
		JLabel label = new JLabel("搜索");
		label.setBounds(606, 11, 61, 16);
		add(label);
		
		JLabel label_1 = new JLabel("字母排序表");
		label_1.setBounds(6, 25, 89, 16);
		add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(86, 90, 113, 27);
		add(comboBox);
		
		JLabel label_2 = new JLabel("城市");
		label_2.setBounds(6, 94, 61, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("球队");
		label_3.setBounds(606, 94, 61, 16);
		add(label_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(685, 90, 105, 27);
		add(comboBox_1);

	}
	
	//画背景
	public void paintComponent(Graphics g)
	      {
	         int x=0,y=0;
	         java.net.URL imgURL=getClass().getResource("images/selection_bg.png");
	         ImageIcon icon=new ImageIcon(imgURL);
	         g.drawImage(icon.getImage(),x,y,getSize().width,getSize().height,this);
	         while(true)
	         {
	           g.drawImage(icon.getImage(),x,y,this);
	           if(x>getSize().width && y>getSize().height)break;
	           //保证在窗口大于图片时，图片仍能覆盖整个窗口
	           if(x>getSize().width)
	           {
	              x=0;
	              y+=icon.getIconHeight();
	           }
	           else
	            x+=icon.getIconWidth();
	         }
	      }    
}
