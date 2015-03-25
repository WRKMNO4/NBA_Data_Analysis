package com.kmno4.presentation.table;

import javax.swing.JPanel;

/**
 * 
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SlideTable extends JPanel {
	/*
	public SlideTable(String[] headStr, String[][] bodyString) {
		super(headStr, bodyString);
	}
	*/
	private SmallTable table;
	
	public SlideTable(String[] headStr, String[][] bodyString) {
		super();
		setLayout(null);
		table = new SmallTable(headStr, bodyString);
		add(table);
		table.setLocation(0, 0);
		table.setSize(1000, 50);
	}
	
}

