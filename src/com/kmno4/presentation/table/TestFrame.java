package com.kmno4.presentation.table;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestFrame extends JFrame{
	
	public TestFrame() {
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		
		Table t = new Table(
				    new String[]{"a", "b", "c", "d"}, 
				    new String[][]{
					    {"aa", "bb", "cc", "dd"},
					    {"aaa", "bbb", "ccc", "ddd"}
				    });
		t.setLocation(0, 0);
		
		add(t);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TestFrame t = new TestFrame();
	}

}
