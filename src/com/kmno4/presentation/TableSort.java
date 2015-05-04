package com.kmno4.presentation;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableSort {
	public static void addHeadSortListener(JTable table) {
		DefaultTableModel tm = (DefaultTableModel)table.getModel();
		
		
		table.addMouseListener(new MouseAdapter());
	}

}
