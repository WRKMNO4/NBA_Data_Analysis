package com.kmno4.presentation.table;
import java.awt.GridLayout;

import javax.swing.JPanel;
/**
 * table样式
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class Table extends JPanel {
	/**
	 * 表头
	 */
	public TableList head;
	/**
	 * 表身组，即若干表身的集合
	 */
	public TableList[] body;
	/**
	 * 翻页部分
	 */
	public TP turn;
	
	
	public Table(String[] headStr, String[][] bodyStr) {
		super();
		setSize(SIZE_X, SIZE_Y);
		setOpaque(true);
		
		//setLayout(new GridBagLayout());
		setLayout(new GridLayout(ROW_NUM, 1));
		head = new TableList(headStr, TableList.HEAD);
		
		body = new TableList[bodyStr.length];
		for(int i = 0; i < bodyStr.length; i ++) {
			body[i] = new TableList(bodyStr[i], i % 2);
		}
		
		
		
		
		add(head);
		for(TableList t : body)
			if(t != null) add(t);
		//add(turn);
	}
	
	/**
	 * 最大列数（包括表头）
	 */
	public static final int
	    ROW_NUM = 10;
	
	
	private static final int 
	    SIZE_X = 600,
	    SIZE_Y = 400;

}
