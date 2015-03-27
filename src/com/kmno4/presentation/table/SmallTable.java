package com.kmno4.presentation.table;

import java.awt.GridLayout;

/**
 * 小数据的table,
 * 隐藏翻页的功能,
 * 取消表头翻转
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SmallTable extends Table {

	public SmallTable(String[] headStr, String[][] bodyString) {
		super(headStr, bodyString, bodyString.length);
		hidtp();
		removeHeadListener();
	}
	
	
	
	
	private void hidtp() {
		turn.setVisible(false);
		remove(turn);
		setLayout(new GridLayout(rowNum + 1, 1));
	}
	private void removeHeadListener() {
		if(flip == null) return;
		head.removeMouseListener(flip);
	}

}
