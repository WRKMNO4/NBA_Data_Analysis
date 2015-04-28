package com.kmno4.presentation.table;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableFactory {
	private static final int
	    DEFAULT_TABLE_ROW_HEIGHT = 30,
		DEFAULT_TABLE_HEAD_ROW_HEIGHT = 45,
		DEFAULT_TABLE_UNIT_WIDTH = 100;
	public static void createTable(JTable table, JScrollPane jsp, JFrame parentFrame,
			Object[][] body,
			int viewWidth, int viewHeight,
			int x, int y) {
		createTable(table, jsp, parentFrame,
				body,
				viewWidth, viewHeight,
				x, y,
				DEFAULT_TABLE_ROW_HEIGHT, DEFAULT_TABLE_HEAD_ROW_HEIGHT,
				DEFAULT_TABLE_UNIT_WIDTH);
	}
	public static void createTable(JTable table, JScrollPane jsp, JFrame parentFrame,
			Object[][] body,
			int viewWidth, int viewHeight,
			int x, int y,
			int rowHeight, int headRowHeight,
			int unitWidth) {
		if(table != null && table.isVisible()) table.setVisible(false);
		if(jsp != null && jsp.isVisible()) jsp.setVisible(false);
		String[] head = new String[body[0].length];
		for(int i = body[0].length - 1; i >= 0; i --) head[i] = "";
		TableModel tableModel = new DefaultTableModel(body, head);
		table = new JTable(tableModel);
		table.setPreferredSize(
				new Dimension(
						unitWidth * body[0].length,
						rowHeight * (body.length - 1) + headRowHeight));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		table.setRowHeight(rowHeight);
		table.setRowHeight(0, headRowHeight);
		table.setFont(new Font("default", 0, 15));
		table.getTableHeader().setPreferredSize(new Dimension(0, 0));
		
		jsp = new JScrollPane(table);
		jsp.setBounds(x, y, viewWidth, viewHeight);
		if(unitWidth * body[0].length == viewWidth) jsp.setHorizontalScrollBar(null);
		
		table.setVisible(true);
		jsp.setVisible(true);
		parentFrame.add(jsp);
	}

}
