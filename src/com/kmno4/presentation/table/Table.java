package com.kmno4.presentation.table;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
/**
 * 主table
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class Table extends JPanel {
	public int page = 0;
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
		this(headStr, bodyString, DEFAULT_ROW_NUM);
	}
	
	public Table(String[] headStr, String[][] bodyString, int r) {
		super();
		page = 0;
		rowNum = r;
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
		setLayout(new GridLayout(rowNum + 2, 1));
		head = new TableList(headStr, TableList.HEAD);
		head.addMouseListener(flip = new Flip());
		add(head);
		
		pageNum = (bodyStr.length - 1) / rowNum + 1;
		body = new TableList[pageNum][rowNum];
		
		fillTable(bodyStr, body);
		
		for(int i = 0; i < rowNum; i ++) {
		    add(body[page][i]);
		}
		
		turn = new TP(this);
		add(turn);
	}
	
	public void setFont(Font headFont, Font bodyFont) {
		if(headFont != null) head.setFont(headFont);
		if(bodyFont != null) {
			for(int i = 0; i < body.length; i ++) {
				for (int j = 0; j > body[0].length; j ++)
					body[i][j].setFont(bodyFont);
			}
		}
	}
	public void setForeground(Color headColor, Color bodyColor) {
		if(headColor != null) head.setForeground(headColor);
		if(bodyColor != null) {
			for(int i = 0; i < body.length; i ++) {
				for (int j = 0; j < body[0].length; j ++)
					body[i][j].setForeground(bodyColor);
			}
		}
	}
	public void setBackground(Color headbg, Color bodybg) {
		if(headbg != null) head.setBackground(headbg);
		if(bodybg != null) {
			for(int i = 0; i < body.length; i ++) {
				for (int j = 0; j < body[0].length; j ++)
					body[i][j].setBackground(bodybg);
			}
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
	protected  int rowNum;
	public int getRowNum() {
		return rowNum;
	}
	private static final int DEFAULT_ROW_NUM = 8;
	/**
	 * 页数，不小于1
	 */
	protected  int pageNum;
	public int getPageNum() {
		return pageNum;
	}
	
	protected Flip flip;
	/**
	 * 翻转的响应
	 * @author hutao
	 *
	 */
	class Flip extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			for(int i = 0; i < rowNum; i ++) {
				body[page][i].setVisible(false);
				remove(body[page][i]);
			}
			flip();
			
			for(int i = 0; i < rowNum; i ++) {
				body[page][i].setVisible(true);
			    add(body[page][i]);
			}
			remove(turn);
			add(turn);
			
		}
	}

}
