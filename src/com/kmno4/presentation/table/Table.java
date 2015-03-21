package com.kmno4.presentation.table;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import PO.PlayerPO;
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
	
	private String[][] bodyStr;
	
	public Table(String[] headStr, String[][] bodyString) {
		this(headStr, bodyString, false);
	}
	
	
	
	public Table(String[] headStr, String[][] bodyString, boolean isSmallData) {
		super();
		bodyStr = bodyString;
		if(bodyStr.length == 0) {
			System.out.println("bodyStr.length == 0");
			return;
		}
		if(headStr.length != bodyStr[0].length) {
			System.out.println("headStr.length != bodyStr[0].length");
			return;
		}
		setOpaque(true);
		
		if(isSmallData)
			rowNum = bodyString.length;
		if(rowNum == 0) rowNum = 8;//最大列数的初始化
		setLayout(new GridLayout(rowNum + 2, 1));
		head = new TableList(headStr, TableList.HEAD);
		if(!isSmallData)
			head.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for(int i = 0; i < rowNum; i ++) {
						body[TP.page][i].setVisible(false);
						remove(body[TP.page][i]);
					}
					//bodyStr = flip(bodyStr);
					//fillTable(bodyStr, body);
					flip();
					
					for(int i = 0; i < rowNum; i ++) {
					    add(body[TP.page][i]);
					}
					remove(turn);
					add(turn);
				}
			});
		add(head);
		
		pageNum = (bodyStr.length - 1) / rowNum + 1;
		body = new TableList[pageNum][rowNum];
		
		fillTable(bodyStr, body);
		
		for(int i = 0; i < rowNum; i ++) {
		    add(body[TP.page][i]);
		}
		
		
		turn = new TP(this);
		add(turn);
		if(isSmallData) {
			hidtp(true);
		}
	}
	
	public void setFont(Font f, boolean ishead) {
		if(ishead) head.setFont(f);
		else {
			for(int i = body.length; i > 0; i --) {
				for (int j = body[0].length; j > 0; j --)
					body[i][j].setFont(f);
			}
		}
	}
	public void setForeground(Color c, boolean ishead) {
		if(ishead) head.setForeground(c);
		else {
			for(int i = body.length; i > 0; i --) {
				for (int j = body[0].length; j > 0; j --)
					body[i][j].setForeground(c);
			}
		}
	}
	
	
	public void hidtp(boolean isHid) {
		if(isHid) {
			turn.setVisible(false);
			remove(turn);
			setLayout(new GridLayout(rowNum + 1, 1));
		}
		else {
			if(turn.getParent() == this) return;
			setLayout(new GridLayout(rowNum + 2, 1));
			add(turn);
			turn.setVisible(true);
		}
	}
	
	
	private void fillTable(String[][] bodyStr, TableList[][] body) {
		for(int i = 0; i < body.length; i ++) {
			for(int j = 0; j < body[i].length; j ++) {
				int k;
				if((k = i * body[0].length + j) < bodyStr.length) {
				    body[i][j] = new TableList(bodyStr[k], k % 2);
				}
				else
					//空条目
					body[i][j] = new TableList(new String[]{}, TableList.BLANK);
			}
		}
	}
	
	private void flip() {
		TableList[][] newBody = new TableList[body.length][body[0].length];
		int blankNum = 0;
		for(int i = 0; i < body[0].length; i ++) {
			if(body[body.length - 1][i].elements.length == 0) blankNum ++;
		}
		int k = body.length * body[0].length - 1 - blankNum;
		for(int i = 0; i < body.length; i ++) {
			for(int j = 0; j < body[0].length; j ++) {
				if(k >= 0) newBody[i][j] = body[k / body[0].length][k % body[0].length];
				else newBody[i][j] = body[i][j];
				
				k --;
			}
		}
		body = newBody;
		
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
