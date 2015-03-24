package com.kmno4.presentation.table;

import javax.swing.JPanel;

/**
 * 
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SlideTable extends JPanel {
	private SmallTable table;
	
	public SlideTable(String[] headStr, String[][] bodyString) {
		table = new SmallTable(headStr, bodyString);
	}

}

