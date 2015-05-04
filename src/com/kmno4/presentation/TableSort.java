package com.kmno4.presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableSort {
	public static void addHeadSortListener(JTable table) {
		DefaultTableModel tm = (DefaultTableModel)table.getModel();
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

}
