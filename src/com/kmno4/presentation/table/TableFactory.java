package com.kmno4.presentation.table;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableFactory {
	private static final int
	    DEFAULT_TABLE_ROW_HEIGHT = 30,
		DEFAULT_TABLE_HEAD_ROW_HEIGHT = 45,
		DEFAULT_TABLE_UNIT_WIDTH = 100;
	public static void createTable(TableGroup tg, JFrame parentFrame,
			Object[][] body,
			int viewWidth, int viewHeight,
			int x, int y) {
		createTable(tg, parentFrame,
				body,
				viewWidth, viewHeight,
				x, y,
				DEFAULT_TABLE_ROW_HEIGHT, DEFAULT_TABLE_HEAD_ROW_HEIGHT,
				DEFAULT_TABLE_UNIT_WIDTH);
	}
	public static void createTable(TableGroup tg, JFrame parentFrame,
			Object[][] body,
			int viewWidth, int viewHeight,
			int x, int y,
			int rowHeight, int headRowHeight,
			int unitWidth) {
		if(tg.table != null && tg.table.isVisible()) tg.table.setVisible(false);
		if(tg.jsp != null && tg.jsp.isVisible()) tg.jsp.setVisible(false);
		String[] head = new String[body[0].length];
		for(int i = body[0].length - 1; i >= 0; i --) head[i] = "";
		TableModel tableModel = new DefaultTableModel(body, head);
		tg.table = new JTable(tableModel);
		//TODO
//		DefaultTableCellRenderer tc = new DefaultTableCellRenderer();
//		tc.setOpaque(false);
//		tg.table.setOpaque(false);
//		tg.table.setDefaultRenderer(Object.class, tc);
		tg.table.setPreferredSize(
				new Dimension(
						unitWidth * body[0].length,
						rowHeight * (body.length - 1) + headRowHeight));
		tg.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tg.table.setEnabled(false);
		tg.table.setRowHeight(rowHeight);
		tg.table.setRowHeight(0, headRowHeight);
		tg.table.setFont(new Font("default", 0, 15));
		tg.table.getTableHeader().setPreferredSize(new Dimension(0, 0));
		
		tg.jsp = new JScrollPane(tg.table);
		tg.jsp.setBounds(x, y, viewWidth, viewHeight);
		if(unitWidth * body[0].length == viewWidth) tg.jsp.setHorizontalScrollBar(null);
		
		tg.table.setVisible(true);
		tg.jsp.setVisible(true);
		parentFrame.add(tg.jsp);
		
//		tg.jsp.getViewport().setOpaque(false);
//		tg.jsp.setOpaque(false);
	}

}
