package com.kmno4.presentation.table;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableGroup {
	public JTable table;
	public JScrollPane jsp;
	
	public TableGroup(TableGroup t) {
		this.table = t.table;
		this.jsp = t.jsp;
	}
	public TableGroup(JTable table, JScrollPane jsp) {
		this.table = table;
		this.jsp = jsp;
	}
	public TableGroup() {}
	
}
