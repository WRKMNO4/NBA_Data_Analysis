package com.kmno4.presentation.table;
import java.awt.GridLayout;

import javax.swing.JPanel;
/**
 * 主table
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
	 * 例如TableList[2][5]为2面，每面5行(第二面可能不足5行)
	 */
	public TableList[][] body;
	/**
	 * 翻页部分
	 */
	public TP turn;
	
	
	public Table(String[] headStr, String[][] bodyStr) {
		super();
		if(bodyStr.length == 0) {
			System.out.println("bodyStr.length == 0");
			return;
		}
		if(headStr.length != bodyStr[0].length) {
			System.out.println("headStr.length != bodyStr[0].length");
			return;
		}
		setOpaque(true);
		
		if(rowNum == 0) rowNum = 8;//最大列数的初始化
		setLayout(new GridLayout(rowNum + 2, 1));
		head = new TableList(headStr, TableList.HEAD);
		add(head);
		
		pageNum = (bodyStr.length - 1) / rowNum + 1;
		body = new TableList[pageNum][rowNum];
		for(int i = 0; i < body.length; i ++) {
			for(int j = 0; j < body[i].length; j ++) {
				int k;
				if((k = i * rowNum + j) < bodyStr.length) {
				    body[i][j] = new TableList(bodyStr[k], k % 2);
				}
				else
					//空条目
					body[i][j] = new TableList(new String[]{}, TableList.BLANK);
			}
		}
		for(int i = 0; i < rowNum; i ++) {
		    add(body[TP.page][i]);
		}
		
		
		turn = new TP(this);
		add(turn);
		
	}
	
	
	/**
	 * 最大列数（不包括表头）
	 */
	public static int rowNum;
	/**
	 * 页数，不小于1
	 */
	private static int pageNum;
	public int getPageNum() {
		return pageNum;
	}
	

}
