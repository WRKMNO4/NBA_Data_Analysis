package com.kmno4.presentation.table;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TableList extends JPanel {
	public JLabel[] elements;
	
	
	public TableList(String[] ele, int type) {
		super();
		
		elements = new JLabel[ele.length];
		switch(type) {
		case head : setBackground(Color.orange); break;
		case sing : setBackground(Color.lightGray); break;
		case doub : setBackground(Color.white); break;
		default :
		}
		
		for(int i = 0; i < ele.length; i ++) {
			elements[i] = new JLabel(ele[i]);
			elements[i].setOpaque(true);
			add(elements[i]);
		}
	}
	
	
	public static final int 
        head = 0,
        sing = 1,
        doub = 2;
}
