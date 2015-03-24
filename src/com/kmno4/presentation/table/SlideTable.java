package com.kmno4.presentation.table;

/**
 * 
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SlideTable extends SmallTable {
	public SlideTable(String[] headStr, String[][] bodyString) {
		super(headStr, bodyString);
	}

	//private SmallTable table;
	/*
	public SlideTable(String[] headStr, String[][] bodyString) {
		this.setLayout(null);
		table = new SmallTable(headStr, bodyString);
		add(table);
		table.setLocation(20, 20);
		table.setSize(this.getWidth(), this.getHeight());
		System.out.println();
	}
	*/
}

